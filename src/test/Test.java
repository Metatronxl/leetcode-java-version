package test;

abstract class A{
    A(){
        init();
    }
    public abstract void init();
}

class C{
    public void method(){
        System.out.println("C");
    }
}

class B extends A{
    public static  C cc = new  C();

    @Override
    public void init(){
        cc.method();
    }
}

public class Test {

    public static void main(String[] args) {
        // write your code here
        new B();
    }
}
