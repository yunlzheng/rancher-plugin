package jenkins.plugins.rancher.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceUpgrade {

    private InServiceStrategy inServiceStrategy;

    public InServiceStrategy getInServiceStrategy() {
        return inServiceStrategy;
    }

    public void setInServiceStrategy(InServiceStrategy inServiceStrategy) {
        this.inServiceStrategy = inServiceStrategy;
    }

}
