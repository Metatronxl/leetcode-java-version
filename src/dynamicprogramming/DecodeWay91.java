package dynamicprogramming;

/**
 * @author lei.X
 */
public class DecodeWay91 {

    public int numDecodings(String s) {

        int len = s.length();
        if (len == 0 || s.charAt(0) == '0'){
            return 0;
        }

        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=len;i++){
            int cur = s.charAt(i-1)-'0';
            int prev = s.charAt(i-2)-'0';

            if (cur==0){
                if (prev == 1 || prev ==2){
                    dp[i] = dp[i-2];
                }else{
                    return 0;
                }
            }else{
                if (prev == 1 || (prev==2 && cur<=6)){
                    dp[i] = dp[i-1] + dp[i-2];
                }else {
                    dp[i] = dp[i-1];
                }
            }
        }

        return dp[len];
    }

}
