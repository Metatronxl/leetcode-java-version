package dynamicprogramming;

/**
 * @author lei.X
 * @date 2019/12/27
 */
public class MaxArea11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int i=0;int j=len-1;
        int res=0;
        while (i<j){
            int higher = Math.min(height[i],height[j]);
            res = Math.max(res,higher*(j-i));
            if (height[i] > height[j]){
                j--;
            }else {
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxArea11  test = new MaxArea11();
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        test.maxArea(nums);
    }
}
