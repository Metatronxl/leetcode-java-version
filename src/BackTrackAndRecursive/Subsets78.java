package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/5
 */
public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void backtrack(int[] nums, int idx, List<Integer> subset, List<List<Integer>> subsets) {
        // base case
        if (idx == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        /**
         * 思路： 对于每个元素，我们都用2种选择，是将其放进子set or  不放进，
         * 所有会有如下2个回溯解法
         */
        // include and recurse
        subset.add(nums[idx]);
        backtrack(nums, idx + 1, subset, subsets);
        // exclude and recurse
        subset.remove(subset.size() - 1);
        backtrack(nums, idx + 1, subset, subsets);
    }

    public static void main(String[] args) {

        Subsets78 test = new Subsets78();
        int[] nums = new int[]{1,2,3,};
        List<List<Integer>> resultSet = test.subsets(nums);

        for(int i=0;i<resultSet.size();i++){
            System.out.println(resultSet.get(i));
        }

//        System.out.println(resultSet);


    }

}
