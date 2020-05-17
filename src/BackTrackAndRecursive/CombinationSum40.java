package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/9
 */
public class CombinationSum40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        candidates = resverseArray(candidates);

        int idx=0;
        int sum = 0;

        backTracking(res,candidates,new ArrayList<Integer>(),target,idx,sum);

        return res;

    }

    private void backTracking(List<List<Integer>> res,int[] candidates,List<Integer> subSet,int target, int idx,int sum){

        if (sum == target){
            res.add(new ArrayList<>(subSet));
            return;
        }

        if (sum > target){
            return;
        }

        int length = candidates.length;

        for(int i=idx;i<length;i++){
            int repeat = 1;
            while (i+repeat < length &&  candidates[i] == candidates[i+repeat]){
                repeat ++;
            }
            subSet.add(candidates[i]);
            sum += candidates[i];
            backTracking(res,candidates,subSet,target,i+1,sum);
            i += repeat-1;
            subSet.remove(subSet.size()-1);
            sum -= candidates[i];
        }

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


    public static void main(String[] args) {

        CombinationSum40 test = new CombinationSum40();
        int[] nums = new int[]{10,1,2,7,6,1,5};
        System.out.println(test.combinationSum2(nums, 8));

    }
}
