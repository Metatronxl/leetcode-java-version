package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tree.TreeUtil.*;

/**
 * @author lei.X
 * @date 2019/9/5
 */
public class Tree102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<TreeNode> rootFloor = new ArrayList<>();
        if (root == null){
            return Collections.emptyList();
        }
        rootFloor.add(root);

        helper(res,rootFloor);

        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<TreeNode> subset) {

        if (subset.size() == 0){
            return;
        }
        ArrayList<TreeNode> nextFloorList = new ArrayList<>();
        ArrayList<Integer> currentFloorList = new ArrayList<>();
        for(int i=0;i<subset.size();i++){
            TreeNode treeNode = subset.get(i);
            if (treeNode.left != null) nextFloorList.add(treeNode.left);
            if (treeNode.right != null) nextFloorList.add(treeNode.right);
            currentFloorList.add(treeNode.val);
        }

        res.add(currentFloorList);
        helper(res,nextFloorList);
    }


    public static void main(String[] args) {

        TreeUtil treeUtil = new TreeUtil();
        List<Integer> array = new ArrayList<>();
        array.add(3);
        array.add(9);
        array.add(20);
        array.add(null);
        array.add(null);
        array.add(15);
        array.add(7);
        TreeNode root = treeUtil.buildBinaryTreeWithArray(array);

        Tree102 tree102 = new Tree102();
        System.out.println(tree102.levelOrder(root));
    }
}
