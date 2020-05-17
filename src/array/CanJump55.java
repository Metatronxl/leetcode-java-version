package array;

import java.util.HashMap;

/**
 * @author lei.X
 * @date 2019/12/17
 */
public class CanJump55 {

    public boolean canJump(int[] nums) {

        int len = nums.length;
        if (len==1) return true;
        int distance = nums[0];
        boolean judge = false;
        for (int i=0;i<distance;i++){

            distance = Math.max(distance,i+nums[i]+1);
            if (distance >= len){
                judge = true;
                return judge;
            }
        }

        return judge;
    }

    public static void main(String[] args) {

        CanJump55 test = new CanJump55();
        int[] num = new int[]{1,2,3,1,5};
        System.out.println(test.canJump(num));
    }
}
