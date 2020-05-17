package dynamicprogramming;

/**
 * @author lei.X
 * @date 2019/9/10
 */
public class UglyNumber263 {

    /**
     *  题干要求uglyNumber 只能有2，3，5这三种质数，其实就是uglyNumber只能由这三种数字组成
     *  除此之外，只需要处理uglyNumber 为1 和2 的特殊情况
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;

        int[] primeNum = new int[]{2, 3, 5};
        for (int i=0; i<3; i++){
            while (num % primeNum[i] == 0){
                num /= primeNum[i];
            }
        }
        if(num == 1) {
            return true;
        }else {
            return false;
        }
    }

}


