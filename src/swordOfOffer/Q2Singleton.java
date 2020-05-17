package swordOfOffer;

/**
 * @author lei.X
 * @date 2020/2/11
 *
 * 实现一个单例模式
 *
 * 一共有三种，第一种是双重机制
 *           第二种是采用内部静态类
 *           第三种是枚举法
 */
//public class Q2Singleton {
//
//
//    private volatile  static  Q2Singleton q2Singleton; // 注意添加volatile关键字来避免JVM指令重排序
//    private Q2Singleton(){}
//
//    /**
//     * 使用双重验证机制来实现，避免多线程下创建多个实例
//     * @return
//     */
//    public static Q2Singleton getInstance(){
//        if (q2Singleton == null){
//            synchronized ((Q2Singleton.class)){
//                if (q2Singleton == null){
//                    q2Singleton = new Q2Singleton();
//                }
//            }
//        }
//
//        return q2Singleton;
//    }
//
//}

/**
 * 静态内部类
 */
public class Q2Singleton{

    private static class SingletonHolder{
        private static final Q2Singleton INSTANCE = new Q2Singleton();
    }

    private Q2Singleton(){}

    public static final Q2Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }


}

/**
 * 枚举类
 * 我们可以通过EasySingleton.INSTANCE来访问实例，这比调用getInstance()方法简单多了。
 * 创建枚举默认就是线程安全的，所以不需要担心double checked locking，而且还能防止反序列
 * 化导致重新创建新的对象。但是还是很少看到有人这样写，可能是因为不太熟悉吧。

 */
//public enum EasySingleton{
//
//    INSTANCE;
//}



