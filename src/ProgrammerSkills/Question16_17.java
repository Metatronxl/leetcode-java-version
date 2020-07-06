package ProgrammerSkills;

public class Question16_17 {

    public int maxSubArray(int[] nums) {

        if (nums== null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i=1;i<len;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }

        return max;

    }

    public static void main(String[] args) {
        Question16_17 question16_17 = new Question16_17();
        int[] nums = new int[]{-1,-2};
        System.out.println(question16_17.maxSubArray(nums));
    }
}
