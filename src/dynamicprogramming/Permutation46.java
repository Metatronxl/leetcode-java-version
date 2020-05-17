package dynamicprogramming;

import BackTrackAndRecursive.Permutations46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lei.X
 * @date 2019/11/6
 */
public class Permutation46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,res);
        System.out.println(res);
        return res;
    }


    public void helper(int[] nums,int start,List<List<Integer>> res){

        if (start == nums.length-1){
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(collect);
        }

        for (int i=start;i<nums.length;i++){

            if (i != start && nums[i]==nums[start]){
                continue;
            }

            swap(nums,start,i);
            helper(nums,start+1,res);
            swap(nums,start,i);
        }


    }

    public void swap(int[] nums,int left ,int right){

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }



    public static void main(String[] args) {

        int[] nums = new int[]{1,1,2,3};
        Permutations46 test = new Permutations46();
        System.out.println( test.permute(nums));
    }
}
