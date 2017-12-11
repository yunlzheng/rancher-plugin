package jenkins.plugins.rancher.util;

public class TimeoutException extends RuntimeException {
    public TimeoutException() {
        super("execute time out");
    }
}
