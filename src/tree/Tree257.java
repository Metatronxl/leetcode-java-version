package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tree.TreeUtil.*;

/**
 * @author lei.X
 * @date 2019/9/16
 */
public class Tree257 {


    public List<String> binaryTreePaths(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();


        if (root == null){
            return Collections.emptyList();
        }


        helper(res,new ArrayList<>(),root);

        List<String> result = new ArrayList<>();

        for(int i=0;i<res.size();i++){
            StringBuilder sb = new StringBuilder();
            List<Integer> stringList = res.get(i);
            sb.append(stringList.get(0));
            String arrow = "->";
            for(int j=1;j<stringList.size();j++){
                sb.append(arrow);
                sb.append(stringList.get(j));
            }
            result.add(sb.toString());
        }


        return result;

    }

    private void helper(List<List<Integer>> res, List<Integer> temp,TreeNode root){

        if (root.left == null && root.right == null){
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        if (root.left != null){
            temp.add(root.val);
            helper(res,temp,root.left);
            temp.remove(temp.size()-1);
        }

        if (root.right != null){
            temp.add(root.val);
            helper(res,temp,root.right);
            temp.remove(temp.size()-1);
        }




    }


    public static void main(String[] args) {

        Tree257 test = new Tree257();

        TreeNode root = TreeUtil.getTree();
        System.out.println(test.binaryTreePaths(root));

    }




}
