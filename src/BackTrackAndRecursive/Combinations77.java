package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/7
 */
public class Combinations77 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0){
            return Collections.emptyList();
        }
        int idx = 0;
        int count = 0;
        backTracking(n,k,idx,count,res,new ArrayList<Integer>());

        return res;
    }

    private void backTracking(int n,int k,int idx,int count,List<List<Integer>> res,List<Integer> combination){

        if (count == k){
            res.add(new ArrayList<>(combination));
            return;
        }

        for(int i=idx;i<n;i++){
            combination.add(i+1);
            backTracking(n,k,i+1,count+1,res,combination);
            combination.remove(combination.size()-1);
        }
    }


    public static void main(String[] args) {
        Combinations77 test = new Combinations77();

        System.out.println(test.combine(4,2));
    }
}
