package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lei.X
 * @date 2019/12/11
 */
public class containDuplicate217 {

    /**
     * 使用排序法solve
     * 时间O(nlogN),
     * Space : O(1)
     * @param nums
     * @return
     */
    public boolean containDuplicate(int[] nums){

        Arrays.sort(nums);
        boolean judge = false;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i] == nums[i+1]){
                judge =  true;
            }
        }

        return judge;
    }

    /**
     * 使用map
     * Time: O(N)
     * Space: O(N)
     * @param nums
     * @return
     */
    public boolean containDuplicate2(int[] nums){

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        boolean judge = false;
        for (int i=0;i<nums.length;i++){

            if (hashMap.containsKey(nums[i])){
                judge = true;
            }else {
                hashMap.put(nums[i],1);
            }

        }

        return judge;
    }
}
