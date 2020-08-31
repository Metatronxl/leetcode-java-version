package other.Threads;

public class UseSynchronized {

    public static void main(String[] args) {
        PrintABCTest printABCTest = new PrintABCTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printABCTest.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printABCTest.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printABCTest.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

class PrintABCTest{

    final  Object monitor = new Object();
    String flag = "A";
    public void printA() throws InterruptedException {
        for (int i=0;i<10;i++){
            synchronized (monitor){
                while (!flag.equals("A")){
                    monitor.wait();
                }
                System.out.println("A");
                flag = "B";
                monitor.notifyAll();
            }
        }
    }

    public void printB() throws InterruptedException {
        for (int i=0;i<10;i++){
            synchronized (monitor){
                while (!flag.equals("B")){
                    monitor.wait();
                }
                System.out.println("B");
                flag = "C";
                monitor.notifyAll();
            }
        }
    }

    public void printC() throws InterruptedException {
        for (int i=0;i<10;i++){
            synchronized (monitor){
                while (!flag.equals("C")){
                    monitor.wait();
                }
                System.out.println("C");
                flag = "A";
                monitor.notifyAll();
            }
        }
    }
}
