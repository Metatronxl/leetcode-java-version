package dynamicprogramming;

/**
 * @author lei.X
 */
public class HouseRobber213 {

    public int rob(int[] nums) {

        int size = nums.length;
        if (size == 0) return 0;
        if (size == 1) return nums[0];
        if (size == 2 ) return Math.max(nums[0],nums[1]);

        int[] dp1 = new int[size];
        int[] dp2 = new int[size];

        //dp 1  第一个必选,结尾一定不选
        dp1[0] = nums[0];
        dp1[1] = dp1[0];

        for(int i=2;i<size-1;i++){
            dp1[i] = Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }

        dp1[size-1] = dp1[size-2];

        //dp2 第一个必不选
        dp2[0] = 0;
        dp2[1] = nums[1];

        for (int i=2;i<size;i++){
            dp2[i] = Math.max(dp2[i-2]+nums[i],dp2[i-1]);
        }

        return Math.max(dp1[size-1],dp2[size-1]);




    }



}
