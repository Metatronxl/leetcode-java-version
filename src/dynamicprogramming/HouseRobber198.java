package dynamicprogramming;

/**
 * @author lei.X
 */
public class HouseRobber198 {


    public int rob(int[] nums) {
        int size = nums.length;
        if (size ==0) return 0;
        int[] dp = new int[size+1];
        dp[1] = nums[0];

        for(int i =2;i<=size;i++){
            dp[i] = Math.max(dp[i-1],nums[i-1]+ dp[i-2]);
        }

        return dp[size];
    }


    public int backUp(int[] nums){


        int size = nums.length;

        int[] dp = new int[size];

        for (int i=0;i<size;i++){
            if (i==0){
                dp[i] = nums[i];
            }else if (i==1){
                dp[i] = Math.max(nums[i],nums[i-1]);
            }else {
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
        }

        return dp[size-1];
    }

    /**
     * 房子是首位相连的
     * 所以选了第一个屋子就不能选最后一个屋子，翻转同理
     * @param nums
     * @return
     */
    public int backUp2(int[] nums){

        int size = nums.length;
        int[] dp = new int[size];

        // 第一个屋子被选的情况
        dp[0] = nums[0];
        dp[1] = dp[0];
        for (int i=2;i<size-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        // 第一个屋子没有被选
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i=2;i<size;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[size-1];
    }



}
