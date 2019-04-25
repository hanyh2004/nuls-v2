package io.nuls.test.cases;

import io.nuls.api.provider.Result;
import io.nuls.api.provider.ServiceManager;
import io.nuls.api.provider.network.NetworkProvider;
import io.nuls.test.Config;
import io.nuls.test.controller.RemoteCaseReq;
import io.nuls.test.controller.RemoteResult;
import io.nuls.test.utils.RestFulUtils;
import io.nuls.test.utils.Utils;
import io.nuls.tools.core.ioc.SpringLiteContext;
import io.nuls.tools.log.Log;
import io.nuls.tools.model.StringUtils;
import io.nuls.tools.parse.MapUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: zhoulijun
 * @Time: 2019-04-25 14:03
 * @Description: 功能描述
 */
public abstract class CallRemoteTestCase<T,P> extends BaseTestCase<T,P> {

    protected NetworkProvider networkProvider = ServiceManager.get(NetworkProvider.class);

    protected List<String> getRemoteNodes() throws TestFailException {
        Result<String> nodes = networkProvider.getNodes();
        Config config = SpringLiteContext.getBean(Config.class);
        if(!config.isMaster()){
            throw new RuntimeException("非master节点不允许进行远程调用");
        }
        List<String> nodeList;
        if(StringUtils.isNotBlank(config.getTestNodeList())){
            nodeList = Arrays.asList(config.getTestNodeList().split(","));
        }else{
            nodeList = nodes.getList().stream().map(node->node.split(":")[0]).filter(node->config.getNodeExclude().indexOf(node)==-1).collect(Collectors.toList());
        }
        if(nodeList.isEmpty()){
            throw new TestFailException("remote fail ,network node is empty");
        }
        int testNodeCount = config.getTestNodeCount() > nodeList.size() ? nodeList.size() : config.getTestNodeCount();
        return nodeList.subList(0,testNodeCount);
    }

    public Map doRemoteTest(String node, Class<? extends TestCaseIntf> caseCls, Object param) throws TestFailException {
        RemoteCaseReq req = new RemoteCaseReq();
        req.setCaseClass(caseCls);
        if(param != null){
            req.setParam(Utils.toJson(param));
        }
        RestFulUtils.getInstance().setServerUri("http://" + node.split(":")[0] + ":9999/api");
        Log.debug("call {} remote case:{}",node,req);
        RemoteResult<Map> result = RestFulUtils.getInstance().post("remote/call", MapUtils.beanToMap(req));
        Log.debug("call remote case returl :{}",result);
        checkResultStatus(new Result(result.getData()));
        return result.getData();
    }

}
