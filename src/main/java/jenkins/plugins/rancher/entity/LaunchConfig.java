package jenkins.plugins.rancher.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LaunchConfig {
    private String imageUuid;
    private String kind;
    private List<String> ports = new ArrayList<>();
    private String type;
    private boolean stdinOpen = true;

    private List<String> dataVolumes;
    private List<String> dataVolumesFrom;

    private LogConfig logConfig;

    private String workingDir;
    private List<String> entryPoint;
    private List<String> command;
    private Map<String, Object> environment = new HashMap<>();
    private Map<String, String> labels = new HashMap<>();

    private boolean tty = true;

    public List<String> getCommand() {
        return command;
    }

    public void setCommand(List<String> command) {
        this.command = command;
    }

    public List<String> getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(List<String> entryPoint) {
        this.entryPoint = entryPoint;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

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

    public LogConfig getLogConfig() {
        return logConfig;
    }

    public void setLogConfig(LogConfig logConfig) {
        this.logConfig = logConfig;
    }
}
