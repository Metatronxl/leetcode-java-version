package swordOfOffer.com.jvm.memory;

/**
 * @author lei.X
 * @date 2020/2/20
 */
public class MyTest3 {

    public static void main(String[] args) {


        Object lockA = new Object();
        Object lockB = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String  name = Thread.currentThread().getName();
                synchronized (lockA){

                    System.out.println(name + "got lockA,want lockB");

                        try {
                            Thread.sleep(100)
                            ;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    synchronized (lockB){
                        System.out.println(name + "got lockB");
                        System.out.println(name + "say hello!");
                    }
                }
            }
        },"Thread A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                synchronized (lockB){
                    System.out.println(name + "got lockB,want lockA");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (lockA){
                        System.out.println(name + "got lockA");
                        System.out.println(name + "say hello");
                    }

                }

            }
        },"Thread-B").start();

    }





}


class  A{

    public static synchronized void method(){

        System.out.println("detect dead loak A");
        A.method();
    }

}



class B{

    public static synchronized void method(){

        System.out.println("detect dead lock B");
        B.method();

    }

}