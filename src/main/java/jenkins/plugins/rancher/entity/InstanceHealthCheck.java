package jenkins.plugins.rancher.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstanceHealthCheck {
    private int initializingTimeout;
    private int healthyThreshold;
    private int interval;
    private String name;
    private int port;
    private int reinitializingTimeout;
    private String requestLine;
    private int responseTimeout;
    private String strategy;
    private int unhealthyThreshold;
    private RecreateOnQuorumStrategyConfig recreateOnQuorumStrategyConfig;

    public int getInitializingTimeout() {
        return initializingTimeout;
    }

    public void setInitializingTimeout(int initializingTimeout) {
        this.initializingTimeout = initializingTimeout;
    }

    public RecreateOnQuorumStrategyConfig getRecreateOnQuorumStrategyConfig() {
        return recreateOnQuorumStrategyConfig;
    }

    public void setRecreateOnQuorumStrategyConfig(RecreateOnQuorumStrategyConfig recreateOnQuorumStrategyConfig) {
        this.recreateOnQuorumStrategyConfig = recreateOnQuorumStrategyConfig;
    }

    public int getHealthyThreshold() {
        return healthyThreshold;
    }

    public void setHealthyThreshold(int healthyThreshold) {
        this.healthyThreshold = healthyThreshold;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getReinitializingTimeout() {
        return reinitializingTimeout;
    }

    public void setReinitializingTimeout(int reinitializingTimeout) {
        this.reinitializingTimeout = reinitializingTimeout;
    }

    public String getRequestLine() {
        return requestLine;
    }

    public void setRequestLine(String requestLine) {
        this.requestLine = requestLine;
    }

    public int getResponseTimeout() {
        return responseTimeout;
    }

    public void setResponseTimeout(int responseTimeout) {
        this.responseTimeout = responseTimeout;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public int getUnhealthyThreshold() {
        return unhealthyThreshold;
    }

    public void setUnhealthyThreshold(int unhealthyThreshold) {
        this.unhealthyThreshold = unhealthyThreshold;
    }
}
