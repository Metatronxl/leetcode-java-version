package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/11/6
 */
public class PermuteUnique47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        backTracking(res,new ArrayList<>(),nums,flags);

        return res;
    }


    private void backTracking(List<List<Integer>> res, List<Integer> subset, int[] nums, boolean[] flag) {

        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (flag[i] == true || (i>0 && !flag[i-1])  && nums[i] == nums[i - 1]) {
                continue;
            }

            flag[i] = true;
            subset.add(nums[i]);
            backTracking(res, subset, nums, flag);
            subset.remove(subset.size() - 1);
            flag[i] = false;

        }

        return;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,1,2};
        PermuteUnique47 test = new PermuteUnique47();
        System.out.println( test.permuteUnique(nums));
    }

}
