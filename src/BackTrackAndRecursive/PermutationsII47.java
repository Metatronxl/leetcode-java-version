package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/27
 */
public class PermutationsII47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(res,new ArrayList<>(),nums,flags);

        return res;

    }

    private void backTracking(List<List<Integer>> res,List<Integer> subset,int[] nums,boolean[] flags){

        if (subset.size() == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if (flags[i] == true || (i>0 && flags[i-1]!=true && nums[i]== nums[i-1])){
                continue;
            }

            subset.add(nums[i]);
            flags[i] = true;
            backTracking(res,subset,nums,flags);
            flags[i] = false;
            subset.remove(subset.size()-1);

        }

    }



    public static void main(String[] args) {

        PermutationsII47 test = new PermutationsII47();
        int[] nums = new int[]{1,2,1,2};
        System.out.println(test.permuteUnique(nums));
    }

}
