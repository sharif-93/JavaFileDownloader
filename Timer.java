import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Timer extends Thread {

    private volatile boolean isEnabled = true;

    @Override
    public void run() {
        Instant start = Instant.now();
        while (isEnabled) {
            System.out.print(">");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }
        Duration downloadTime = Duration.between(start, Instant.now());
        System.out.println(
                "\nDownload completed in " + downloadTime.toSeconds() + "." + downloadTime.toMillisPart() + " seconds");
    }

    public void shutdown() {
        this.isEnabled = false;
    }
}
