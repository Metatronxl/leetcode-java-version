package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/19
 */
public class FactorCombination254 {

    public List<List<Integer>> getFactors(int n) {

        if (n<2){
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();

        int idx=2;
        int num = n;
        backTracking(n,num,res,new ArrayList<>(),idx);

        return res;

    }

    private void backTracking(int n,int num,List<List<Integer>> res, List<Integer> subset,int idx){

        if (n==1){
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i=idx;i<num;i++){

            if (n % i == 0){
                subset.add(i);
                n /= i;
                backTracking(n,num,res,subset,i);
                subset.remove(subset.size()-1);
                n *= i;
            }
        }
    }


    public static void main(String[] args) {

        FactorCombination254 test = new FactorCombination254();
        System.out.println(test.getFactors(32));

    }
}
