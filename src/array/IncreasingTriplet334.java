package array;

/**
 * @author lei.X
 * @date 2019/12/31
 */
public class IncreasingTriplet334 {

    public boolean increasingTriplet(int[] nums) {


        int a = Integer.MAX_VALUE; // 数组中最小的数
        int b = Integer.MAX_VALUE; // 数组中第二大的数


        for (int i=0;i<nums.length;i++){
            int temp = nums[i];
            if (temp < a){
                a = temp;
            }else if (temp <= b){
                b = temp;
            }else {
                return true;
            }
        }

        return false;
    }
}
