package dynamicprogramming;

import java.util.List;

/**
 * @author lei.X
 * @date 2019/6/29
 */
public class wordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict){

        int len = s.length();
        boolean[] memo = new boolean[len+1];
        memo[0] = true;

        for(int i =1;i<=len;i++){
            for(int j=0;j<i;j++){
                if (memo[j] && wordDict.contains(s.substring(j,i))){
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[len];
    }

}
