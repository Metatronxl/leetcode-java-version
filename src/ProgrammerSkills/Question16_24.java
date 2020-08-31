package ProgrammerSkills;

import java.util.*;

public class Question16_24 {
    /**
     * 使用hash表可以实现O(N)的复杂度
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> pairSums(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int num : nums){
            Integer count = map.get(target-num);
            if (count != null){
                ans.add(Arrays.asList(num,target-num));
                if (count == 1){
                    map.remove(target-num);
                }else {
                    map.put(target-num,--count);
                }
            }else {
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }

        return ans;
    }
}
