package jenkins.plugins.rancher.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LaunchConfig {
    private String imageUuid;
    private String kind;
    private List<String> ports;
    private String type;
    private boolean stdinOpen = true;
    private Map<String, Object> environment;
    private List<String> dataVolumes;
    private List<String> dataVolumesFrom;

    private boolean tty = true;

    public List<String> getDataVolumes() {
        return dataVolumes;
    }

    public void setDataVolumes(List<String> dataVolumes) {
        this.dataVolumes = dataVolumes;
    }

    public List<String> getDataVolumesFrom() {
        return dataVolumesFrom;
    }

    public void setDataVolumesFrom(List<String> dataVolumesFrom) {
        this.dataVolumesFrom = dataVolumesFrom;
    }

    public Map<String, Object> getEnvironment() {
        return environment;
    }

    public void setEnvironment(Map<String, Object> environment) {
        this.environment = environment;
    }

    public boolean isStdinOpen() {
        return stdinOpen;
    }

    public void setStdinOpen(boolean stdinOpen) {
        this.stdinOpen = stdinOpen;
    }

    public boolean isTty() {
        return tty;
    }

    public void setTty(boolean tty) {
        this.tty = tty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUuid() {
        return imageUuid;
    }

    public void setImageUuid(String imageUuid) {
        this.imageUuid = imageUuid;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<String> getPorts() {
        return ports;
    }

    public void setPorts(List<String> ports) {
        this.ports = ports;
    }
}
