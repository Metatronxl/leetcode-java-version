package other.Threads;

import java.util.concurrent.Semaphore;

public class UseSemaphore {
    public static void main(String[] args) {
        PrintABCUsingSemaphore printABCUsingSemaphore = new PrintABCUsingSemaphore();
        new Thread(() -> printABCUsingSemaphore.printA()).start();
        new Thread(()-> printABCUsingSemaphore.printB()).start();
        new Thread(()-> printABCUsingSemaphore.printC()).start();
    }

}


class PrintABCUsingSemaphore{

    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public void printA(){
        print("A",semaphoreA,semaphoreB);
    }
    public void printB(){
        print("B",semaphoreB,semaphoreC);
    }
    public void printC(){
        print("C",semaphoreC,semaphoreA);
    }

    private void print(String name,Semaphore currentSemaphore,Semaphore nxtSemaphore){
        for (int i=0;i<10;){
            try {
                currentSemaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "print"+name);
                i++;
                nxtSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

