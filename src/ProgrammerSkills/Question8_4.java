package ProgrammerSkills;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Question8_4 {

    int len =0;
    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0){
            return Collections.emptyList();
        }
        len = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> sub =  new LinkedList<>();
        helper(nums,resList,sub,0);

        return resList;
    }

    private void helper(int[] nums,List<List<Integer>> resList,List<Integer> sub ,int idx){
        resList.add(new ArrayList<>(sub));
        for (int i=idx;i<len;i++){
            sub.add(nums[i]);
            helper(nums,resList,sub,i+1);
            sub.remove(sub.size()-1);
        }
    }


    public static void main(String[] args) {
        Question8_4 question8_4 = new Question8_4();
        int[] nums = new int[]{1,2,3};
        question8_4.subsets(nums);
    }
}
