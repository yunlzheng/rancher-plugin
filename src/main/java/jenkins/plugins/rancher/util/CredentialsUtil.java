package jenkins.plugins.rancher.util;

import com.cloudbees.plugins.credentials.CredentialsMatcher;
import com.cloudbees.plugins.credentials.CredentialsMatchers;
import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import com.cloudbees.plugins.credentials.domains.DomainRequirement;
import hudson.security.ACL;
import jenkins.model.Jenkins;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials;

public class CredentialsUtil {

    public static List<StandardUsernamePasswordCredentials> getCredentials() {
        return lookupCredentials(
                StandardUsernamePasswordCredentials.class,
                Jenkins.getInstance(),
                ACL.SYSTEM, Collections.<DomainRequirement>emptyList());
    }

    public static Optional<StandardUsernamePasswordCredentials> getCredential(String credentialId) {
        List<StandardUsernamePasswordCredentials> standardUsernamePasswordCredentials = getCredentials();
        CredentialsMatcher matcher = CredentialsMatchers.withId(credentialId);
        return Optional.ofNullable(CredentialsMatchers.firstOrNull(standardUsernamePasswordCredentials, matcher));
    }

}
