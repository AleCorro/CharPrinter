public class Interruptor implements Runnable {

    private Thread threadToInterrupt;
    private long timeToInterrupt;

    public Interruptor(Thread threadToInterrupt, long timeToInterrupt) {
        this.threadToInterrupt = threadToInterrupt;
        this.timeToInterrupt = timeToInterrupt;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeToInterrupt);
            threadToInterrupt.interrupt();
        } catch (InterruptedException ex) {

        }
    }
}
