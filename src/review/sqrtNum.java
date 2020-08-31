package review;

/**
 * 写出一个开根号的算法，保留10位小数
 */
public class sqrtNum {


    public double mySqrt(int n){

        if (n==0 || n==1){
            return n;
        }
        double start=0.0;
        double end = n;
        double p = 1e-10; // 精度要求
        double mid = (start+end)/2.0;
        while (Math.abs(mid*mid-n) >p){
            if (mid*mid <n){
                start = mid;
            }else if (mid*mid > n){
                end = mid;
            }else {
                return mid;
            }
            mid = (start+end)/2.0;
        }
        return Math.round(mid*1000)/1000.0;  // 保留三位小数

    }

    /**
     * 牛顿迭代法
     * @param n
     * @return
     */

    private double mySqrt2(int n) {
        double x = 1.0;//设置初始值
        double p = 1e-5;
        while (Math.abs(x * x - n) > p) {
            x = (x + (n / x)) / 2.0;
        }
        return x;

    }

        public static void main(String[] args) {

        sqrtNum sqrtNum = new sqrtNum();
        System.out.println(sqrtNum.mySqrt(2));

    }
}
