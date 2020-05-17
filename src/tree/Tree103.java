package tree;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tree.TreeUtil.*;

/**
 * @author lei.X
 * @date 2019/9/7
 */
public class Tree103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null){
            return Collections.emptyList();
        }

        List<TreeNode> currentFloor = new ArrayList<>();
        currentFloor.add(root);
        List<List<Integer>> res = new ArrayList<>();

        helper(currentFloor,res,false);

        return res;
    }


    private void helper(List<TreeNode> currentFloor, List<List<Integer>> res, boolean inverseFlag) {

        if (currentFloor.size() == 0) return;

        List<Integer> currentInt = new ArrayList<>();
        List<TreeNode> nextFloor = new ArrayList<>();

        if (inverseFlag){

            for(int i=currentFloor.size()-1;i>=0;i--){
                currentInt.add(currentFloor.get(i).val);
            }
        }else{
            for(int i=0;i<currentFloor.size();i++){
                currentInt.add(currentFloor.get(i).val);
            }
        }


        for(int i=0;i<currentFloor.size();i++){
            if (currentFloor.get(i).left != null) nextFloor.add(currentFloor.get(i).left);
            if (currentFloor.get(i).right != null) nextFloor.add(currentFloor.get(i).right);
        }

        res.add(currentInt);
        helper(nextFloor, res, !inverseFlag);
    }




    public static void main(String[] args) {

        TreeNode tree = TreeUtil.getTree();
        Tree103 test = new Tree103();

        List<List<Integer>> lists = test.zigzagLevelOrder(tree);
        System.out.println(lists);

    }
}
