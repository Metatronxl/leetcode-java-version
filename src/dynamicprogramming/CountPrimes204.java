package dynamicprogramming;

import java.util.HashMap;

/**
 * @author lei.X
 * @date 2019/9/10
 */
public class CountPrimes204 {

    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++){
            if (!notPrimes[i]){
                count++;
                for (int j = 2; i * j < n; j++){
                    notPrimes[i * j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        CountPrimes204 test = new CountPrimes204();
        System.out.println(test.countPrimes(10));


    }


}
