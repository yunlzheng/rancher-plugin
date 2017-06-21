package jenkins.plugins.rancher;


import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractProject;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import jenkins.tasks.SimpleBuildStep;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import javax.annotation.Nonnull;
import java.io.IOException;

public class RancherBuilder extends Builder implements SimpleBuildStep {

    private final String endpoint;
    private final String accessKey;
    private final String secretKey;
    private final String service;
    private final String image;
    private final boolean confirm;
    private final String ports;
    private final String environments;

    @DataBoundConstructor
    public RancherBuilder(
            String endpoint, String accessKey, String secretKey, String service,
            String image, boolean confirm, String ports, String environments) {
        this.endpoint = endpoint;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.service = service;
        this.image = image;
        this.confirm = confirm;
        this.ports = ports;
        this.environments = environments;
    }

    @Override
    public void perform(@Nonnull Run<?, ?> run, @Nonnull FilePath workspace, @Nonnull Launcher launcher, @Nonnull TaskListener listener) throws InterruptedException, IOException {

    }

    public String getAccessKey() {
        return accessKey;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getEnvironments() {
        return environments;
    }

    public String getImage() {
        return image;
    }

    public String getPorts() {
        return ports;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getService() {
        return service;
    }

    @Extension // This indicates to Jenkins that this is an implementation of an extension point.
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {

        public DescriptorImpl() {
            load();
        }

        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            // Indicates that this builder can be used with all kinds of project types
            return true;
        }

        public String getDisplayName() {
            return "Deploy/Upgrade Rancher Service";
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            save();
            return super.configure(req, formData);
        }

    }

}
