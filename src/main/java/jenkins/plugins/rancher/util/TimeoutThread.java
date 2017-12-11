package jenkins.plugins.rancher.util;

public class TimeoutThread extends Thread {

    private long timeout;

    private boolean cancled = false;

    public TimeoutThread(long timeout) {
        this.timeout = timeout;
        this.setDaemon(true);
    }

    public synchronized void cancel() {
        cancled = true;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(timeout);
            if (!cancled) {
                throw new TimeoutException();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
