package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/8/9
 */
public class CombinationSum216 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>>  res = new ArrayList<>();
        // 代表已经塞入了几个数
        int idx =0;
        int point = 1;

        backTracking(res,new ArrayList<Integer>(),n,0,idx,k,point);

        return  res;

    }


    private void  backTracking(List<List<Integer>> res,List<Integer> subset,int target,int sum,int idx,int k,int point){

        if (sum == target && idx == k){
            res.add(new ArrayList<>(subset));
            return;
        }

        // sum 超过了 或者数目超过k 则直接退出
        if (sum > target || idx > k){
            return;
        }

        for(int i=point;i<=9;i++){
            sum += i;
            subset.add(i);
            /**
             * 这里用i+1 确保每一次引入数组的值均为不同的数
             *
             * 如果改成point+1
             */
            backTracking(res,subset,target,sum,idx+1,k,i+1);
            sum -=i;
            subset.remove(subset.size()-1);
        }

    }


    public static void main(String[] args) {

        CombinationSum216 test = new CombinationSum216();
        System.out.println(test.combinationSum3(3,7));
    }

}
