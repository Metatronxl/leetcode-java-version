package array;

import java.util.HashMap;

/**
 * @author lei.X
 * @date 2019/12/11
 */
public class ContainDuplicate219 {

    /**
     * 使用hashMap存储每个坐标的值的大小
     * @param nums
     * @param k
     * Space:O(n)
     * Time:O(n)
     * @return
     */
    public boolean containDuplicate2(int[] nums, int k) {

        boolean judge = false;
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            // 如果已经存在num[i],则直接比较两个数之间的间隔是否<=k
            if (integerIntegerHashMap.containsKey(nums[i])){
                int temp = integerIntegerHashMap.get(nums[i]);
                if (i-temp<=k){
                    judge = true;
                }
            }else { // 如果HashMap中不存在num[i],则将这个数对应的坐标放到Hashmap中
                integerIntegerHashMap.put(nums[i],i);
            }
        }

        return judge;
    }

}
