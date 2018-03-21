package jenkins.plugins.rancher.action;


import jenkins.plugins.rancher.entity.LaunchConfig;

public class InServiceStrategy {

    private int batchSize = 1;
    private int intervalMillis = 2000;
    private LaunchConfig launchConfig;
    private boolean startFirst = true;

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getIntervalMillis() {
        return intervalMillis;
    }

    public void setIntervalMillis(int intervalMillis) {
        this.intervalMillis = intervalMillis;
    }

    public LaunchConfig getLaunchConfig() {
        return launchConfig;
    }

    public void setLaunchConfig(LaunchConfig launchConfig) {
        this.launchConfig = launchConfig;
    }

    public boolean isStartFirst() {
        return startFirst;
    }

    public void setStartFirst(boolean startFirst) {
        this.startFirst = startFirst;
    }
}
