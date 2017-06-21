package jenkins.plugins.rancher;

import jenkins.plugins.rancher.action.ServiceUpgrade;
import jenkins.plugins.rancher.entity.Service;
import jenkins.plugins.rancher.entity.Services;
import jenkins.plugins.rancher.entity.Stack;
import jenkins.plugins.rancher.entity.Stacks;

import java.io.IOException;
import java.util.Optional;


/**
 * Note: 获取资源API
 */
public class RancherClient extends HttpClient {


    /**
     * 获取Rancher Client实例对象
     *
     * @param endpoint:  rancher account key api address
     * @param accesskey: rancher account accesskey
     * @param secretKey: rancher account secretkey
     */
    public RancherClient(String endpoint, String accesskey, String secretKey) {
        super(endpoint, accesskey, secretKey);
    }

    public Optional<Stacks> stacks(String environmentId) throws IOException {
        return Optional.ofNullable(get("/projects/" + environmentId + "/stacks", Stacks.class));
    }

    public Optional<Services> services(String stackId) throws IOException {
        return Optional.ofNullable(get("/stacks/" + stackId + "/services", Services.class));
    }

    public Optional<Service> service(String serviceId) throws IOException {
        return Optional.ofNullable(get("/services/" + serviceId, Service.class));
    }

    public Optional<Stack> createStack(Stack stack, String environmentId) throws IOException {
        return Optional.ofNullable(post(String.format("/projects/%s/stack", environmentId), stack, Stack.class));
    }

    public Optional<Service> createService(Service service, String environmentId, String stackId) throws IOException {
        service.setStackId(stackId);
        return Optional.ofNullable(post(String.format("/projects/%s/service", environmentId), service, Service.class));
    }


    public Optional<Service> upgradeService(String environmentId, String serviceId, ServiceUpgrade serviceUpgrade) throws IOException {
        return Optional.ofNullable(post(String.format("/projects/%s/services/%s/?action=upgrade", environmentId, serviceId), serviceUpgrade, Service.class));
    }


    public Optional<Service> rollbackService(String environmentId, String serviceId) throws IOException {
        return Optional.ofNullable(post(String.format("/projects/%s/services/%s/?action=rollback", environmentId, serviceId), Service.class));
    }

    public Optional<Service> finishUpgradeService(String environmentId, String serviceId) throws IOException {
        return Optional.ofNullable(post(String.format("/projects/%s/services/%s/?action=finishupgrade", environmentId, serviceId), Service.class));
    }


}
