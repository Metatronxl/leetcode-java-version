package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lei.X
 * @date 2019/12/6
 */
public class MajorityElement169 {

    /**
     * hash 计数法
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        // 使用Map.Entry 来遍历map
        Map.Entry<Integer, Integer> temp = null;
        for (Map.Entry<Integer, Integer> major : hashMap.entrySet()) {
            if (temp == null || temp.getValue() < major.getValue()) {
                temp = major;
            }
        }

        return temp.getKey();
    }

    /**
     * 排序法
     * Time Complexity: O(nlgn)
     * 因为我们要找的数是存在至少n/2 次的，所以排序完直接返回中间的数一定会是我们要找的数
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}