package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/20
 */
public class Permutations46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        backTracking(res,nums,0);
        return res;


    }


    private void backTracking(List<List<Integer>> res, int[] nums, int idx){

        if (idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }

            res.add(temp);
        }else {
            for(int i=idx;i<nums.length;i++){
                swap(nums,idx,i);
                backTracking(res,nums,idx+1);
                swap(nums,idx,i);
            }
        }

    }




    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void main(String[] args) {

        Permutations46 test = new Permutations46();
        int[] nums = new int[]{1,2,3};
        System.out.println(test.permute(nums));

    }


}
