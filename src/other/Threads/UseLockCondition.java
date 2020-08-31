package other.Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class UseLockCondition {

    public static void main(String[] args) {

        PrintABC printABC = new PrintABC();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printB();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printC();
            }
        }).start();


    }

}


class PrintABC{

        public PrintABC(){}

        private final Lock lock = new ReentrantLock();
        private Condition lockA = lock.newCondition();
        private Condition lockB = lock.newCondition();
        private Condition lockC = lock.newCondition();
        int flag = 0;

        public void  printA(){
            lock.lock();
            try {
                while (true){
                    while (flag !=0){
                        lockA.await();
                    }
                    System.out.println("A");
                    flag = 1;
                    lockA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void printB() {

            lock.lock();
            try {
                while (true) {
                    while (flag != 1){
                        lockB.await();
                    }
                    System.out.println("B");
                    flag = 2;
                    lockB.signal();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void printC(){
            lock.lock();
            try {
                while (true){
                    while (flag !=0){
                        lockC.await();
                    }
                    System.out.println("C");
                    flag = 0;
                    lockC.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }

