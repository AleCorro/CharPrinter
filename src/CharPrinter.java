public class CharPrinter implements Runnable {

    private char character;
    private long waitTime;

    public CharPrinter(char character, long waitTime) {
        this.character = character;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (true) {
                count++;
                System.out.print(character);
                if (count == 5) {
                    System.out.println();
                    count = 0;
                }
                Thread.sleep(waitTime);
            }
        } catch (InterruptedException ex) {
            System.out.println("\n" + character + "Interrupted");
        }
    }
}