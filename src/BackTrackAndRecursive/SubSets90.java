package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/6
 */
public class SubSets90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        backTracking(nums, 0, res, new ArrayList<Integer>());
        return res;

    }

    void backTracking(int[] nums,int idx ,List<List<Integer>> res, List<Integer> subset){

        res.add(new ArrayList<>(subset));
        int len = nums.length;
        for(int i=idx;i<len;i++){

            subset.add(nums[i]);
            backTracking(nums,i+1,res,subset);
            subset.remove(subset.size()-1);
            while (i<len-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
    }

    public static void main(String[] args) {

        SubSets90 test = new SubSets90();
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> resultSet = test.subsetsWithDup(nums);

        for(int i=0;i<resultSet.size();i++){
            System.out.println(resultSet.get(i));
        }

//        System.out.println(resultSet);


    }


}
