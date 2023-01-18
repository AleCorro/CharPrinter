import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Runnable> list = new ArrayList<>();

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            long wait = 3000 + (long) (Math.random() * 3001);
          list.add(new CharPrinter(ch, wait));
        }
        launchThread(list);
    }

    public static void launchInterruotors(List<Thread> list) {
        for (Thread t : list) {
            long timeToInterrupt = (long) (Math.random() * 20001) + 10000;
            new Thread(new Interruptor(t, timeToInterrupt));
        }
    }

    public static void launchThread(List<Runnable> list) {
        List<Thread> listToInterrupt = new ArrayList<>();
        for (Runnable r : list) {
            Thread t = new Thread(r);
            t.start();
            listToInterrupt.add(t);
        }
        launchInterruotors(listToInterrupt);
    }
}
