package io.nuls.block.constant;

import io.nuls.block.model.ChainParameters;
import io.nuls.tools.core.annotation.Configuration;
import io.nuls.tools.core.annotation.Value;

import java.io.File;

/**
 * 配置信息,所有时间配置默认单位为毫秒
 *
 * @author captain
 * @version 1.0
 * @date 18-11-20 上午11:01
 */
@Configuration(domain = "block")
public class BlockConfig {

    /**
     * db文件存放目录
     */
    private String dataFolder;

    /**
     * 国际化
     */
    private String language;

    /**
     * 分叉链监视线程执行间隔
     */
    private int forkChainsMonitorInterval;

    /**
     * 孤儿链监视线程执行间隔
     */
    private int orphanChainsMonitorInterval;

    /**
     * 孤儿链维护线程执行间隔
     */
    private int orphanChainsMaintainerInterval;

    /**
     * 数据库监视线程执行间隔
     */
    private int storageSizeMonitorInterval;

    /**
     * 网络监视线程执行间隔
     */
    private int networkResetMonitorInterval;

    /**
     * TxGroup请求器线程执行间隔
     */
    private int txGroupRequestorInterval;

    /**
     * TxGroup请求器任务执行延时
     */
    private int txGroupTaskDelay;

    @Value("DataPath")
    private String dataPath;

    /**
     * 启动后自动回滚多少个区块
     */
    private int testAutoRollbackAmount;

    /**
     * 默认链配置
     */
    private ChainParameters defaultChainParameter;

    public void setDataFolder(String dataFolder) {
        this.dataFolder = dataFolder;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getForkChainsMonitorInterval() {
        return forkChainsMonitorInterval;
    }

    public void setForkChainsMonitorInterval(int forkChainsMonitorInterval) {
        this.forkChainsMonitorInterval = forkChainsMonitorInterval;
    }

    public int getOrphanChainsMonitorInterval() {
        return orphanChainsMonitorInterval;
    }

    public void setOrphanChainsMonitorInterval(int orphanChainsMonitorInterval) {
        this.orphanChainsMonitorInterval = orphanChainsMonitorInterval;
    }

    public int getOrphanChainsMaintainerInterval() {
        return orphanChainsMaintainerInterval;
    }

    public void setOrphanChainsMaintainerInterval(int orphanChainsMaintainerInterval) {
        this.orphanChainsMaintainerInterval = orphanChainsMaintainerInterval;
    }

    public int getStorageSizeMonitorInterval() {
        return storageSizeMonitorInterval;
    }

    public void setStorageSizeMonitorInterval(int storageSizeMonitorInterval) {
        this.storageSizeMonitorInterval = storageSizeMonitorInterval;
    }

    public int getNetworkResetMonitorInterval() {
        return networkResetMonitorInterval;
    }

    public void setNetworkResetMonitorInterval(int networkResetMonitorInterval) {
        this.networkResetMonitorInterval = networkResetMonitorInterval;
    }

    public int getTxGroupRequestorInterval() {
        return txGroupRequestorInterval;
    }

    public void setTxGroupRequestorInterval(int txGroupRequestorInterval) {
        this.txGroupRequestorInterval = txGroupRequestorInterval;
    }

    public int getTxGroupTaskDelay() {
        return txGroupTaskDelay;
    }

    public void setTxGroupTaskDelay(int txGroupTaskDelay) {
        this.txGroupTaskDelay = txGroupTaskDelay;
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public int getTestAutoRollbackAmount() {
        return testAutoRollbackAmount;
    }

    public void setTestAutoRollbackAmount(int testAutoRollbackAmount) {
        this.testAutoRollbackAmount = testAutoRollbackAmount;
    }

    public ChainParameters getDefaultChainParameter() {
        return defaultChainParameter;
    }

    public void setDefaultChainParameter(ChainParameters defaultChainParameter) {
        this.defaultChainParameter = defaultChainParameter;
    }

    public String getDataFolder() {
        return dataPath + File.separator + dataFolder;
    }

}
