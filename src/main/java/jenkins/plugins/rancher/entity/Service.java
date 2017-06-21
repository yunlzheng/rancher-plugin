package jenkins.plugins.rancher.entity;


public class Service extends Resource {

    private String name;

    private int scale = 1;

    private String stackId;

    private LaunchConfig launchConfig;

    private boolean startOnCreate = true;

    private String state;

    public Service() {
        super("service");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getScale() {
        return scale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getStackId() {
        return stackId;
    }

    public void setStackId(String stackId) {
        this.stackId = stackId;
    }

    public LaunchConfig getLaunchConfig() {
        return launchConfig;
    }

    public void setLaunchConfig(LaunchConfig launchConfig) {
        this.launchConfig = launchConfig;
    }

    public boolean isStartOnCreate() {
        return startOnCreate;
    }

    public void setStartOnCreate(boolean startOnCreate) {
        this.startOnCreate = startOnCreate;
    }


    @Override
    public String toString() {
        return "Service{" +
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                "stackId='" + stackId + '\'' +
                '}';
    }
}
