package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/12
 */
public class CombinationSum377 {

    public int combinationSum4(int[] nums, int target) {

            int len = nums.length;
            int[] dp = new int[target+1];
            dp[0] =1;
            for(int i=1;i<=target;i++){
                for(int j=0;j<len;j++){
                    if (i >= nums[j]){
                        dp[i] += dp[i-nums[j]];
                    }
                }
            }
            return dp[target];
    }



    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};
        CombinationSum377 test = new CombinationSum377();
        System.out.println(test.combinationSum4(nums, 4));
    }

}
