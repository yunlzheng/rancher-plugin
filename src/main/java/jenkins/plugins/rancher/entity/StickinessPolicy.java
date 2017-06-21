package jenkins.plugins.rancher.entity;

public class StickinessPolicy {

    private String cookie;

    private String domain;

    private boolean indirect;

    private Mode mode;

    private String name;

    private boolean nocache;

    private boolean postonly;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isIndirect() {
        return indirect;
    }

    public void setIndirect(boolean indirect) {
        this.indirect = indirect;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNocache() {
        return nocache;
    }

    public void setNocache(boolean nocache) {
        this.nocache = nocache;
    }

    public boolean isPostonly() {
        return postonly;
    }

    public void setPostonly(boolean postonly) {
        this.postonly = postonly;
    }
}
