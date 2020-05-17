package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/8
 */
public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        candidates = resverseArray(candidates);
        List<Integer> subSet = new ArrayList<>();
        int idx = 0;
        int sum = 0;
        backTracking(candidates,target,res,subSet,idx,sum);

        return res;
    }

    private int[] resverseArray(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return array;
    }


    private void backTracking(int[] candidates, int target, List<List<Integer>> res, List<Integer> subSet, int idx, int sum) {

        if (sum == target) {
            res.add(new ArrayList<>(subSet));
            return;
        }

        if (sum > target){
            return;
        }

        int length = candidates.length;

        for(int i=idx;i<length;i++){
                subSet.add(candidates[i]);
                sum += candidates[i];
                backTracking(candidates,target,res,subSet,i,sum);
                subSet.remove(subSet.size()-1);
                sum -= candidates[i];
        }


    }

    public static void main(String[] args) {

        CombinationSum39 test = new CombinationSum39();
        int[] nums = new int[]{2, 3, 6, 7};
        System.out.println(test.combinationSum(nums, 7));

    }
}
