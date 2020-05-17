package dynamicprogramming;

/**
 * @author lei.X
 */
public class LongestPS5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }

        char[] array = s.toCharArray();
        int n = s.length();
        int start = 0;
        int maxLen = 1;

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
            if (i + 1 < n && array[i] == array[i+1]){
                dp[i][i+1] = 1;
                start = i;
                maxLen = 2;
            }
        }

        for(int i=n-1; i>=0; i--){
            for(int j=i+2; j<n; j++){
                if (dp[i+1][j-1] == 1 && array[i] == array[j]){
                    dp[i][j] = 1;
                    if (j-i >= maxLen){
                        start = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }

        String res = s.substring(start, start+maxLen);
        return res;
    }
}

