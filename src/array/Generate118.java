package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/12/4
 */
public class Generate118 {

    public List<List<Integer>> generate(int numRows) {

        if (numRows == 0){
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        dfs(res,first,numRows,1);

        return res;

    }


    private void dfs(List<List<Integer>> res, List<Integer> subset,int numRows,int idx){
        if (idx == numRows){
            return;
        }

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        for(int i=0;i<subset.size()-1;i++){
            integers.add(subset.get(i)+subset.get(i+1));
        }
        integers.add(1);

        res.add(new ArrayList<>(integers));

        dfs(res,integers,numRows,idx+1);

    }


    public static void main(String[] args) {
        Generate118 test = new Generate118();
        test.generate(5);
    }
}
