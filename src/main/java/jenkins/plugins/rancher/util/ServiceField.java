package jenkins.plugins.rancher.util;

import com.google.common.base.Strings;
import hudson.AbortException;

public class ServiceField {
    private final String stackName;
    private final String serviceName;

    public ServiceField(String service) throws AbortException {

        if (Strings.isNullOrEmpty(service)) {
            throw new AbortException("ServerName is Empty");
        }

        String[] stackNameAndServiceName = service.split("/");
        if (stackNameAndServiceName.length != 2) {
            throw new AbortException("ServerName is Empty");
        }
        this.stackName = stackNameAndServiceName[0].trim();
        this.serviceName = stackNameAndServiceName[1].trim();
    }

    public String getStackName() {
        return stackName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
