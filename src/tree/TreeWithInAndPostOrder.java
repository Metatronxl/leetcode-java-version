package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lei.X
 * @date 2019/9/3
 */
public class TreeWithInAndPostOrder {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] post, int[] in) {

        Map<Integer, Integer> valueToIdx = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueToIdx.put(in[i], i);
        }

        return helper(post,new int[]{post.length-1},0,in.length-1,valueToIdx);
    }


    private TreeNode helper(int[] post,int[] postPoint,int inStart,int inEnd,Map<Integer,Integer> valueToIdx){

        if (inStart > inEnd){
            return null;
        }

        int currNode = post[postPoint[0]--];
        int currNodeIdx = valueToIdx.get(currNode);
        TreeNode currTreeNode = new TreeNode(currNode);

        if (inStart == inEnd){
            return currTreeNode;
        }

        currTreeNode.right = helper(post,postPoint,currNodeIdx+1,inEnd,valueToIdx);
        currTreeNode.left = helper(post,postPoint,inStart,currNodeIdx-1,valueToIdx);

        return currTreeNode;
    }

    public static void main(String[] args) {

        TreeWithInAndPostOrder test = new TreeWithInAndPostOrder();
        int[] post = new int[]{9, 15,7, 20, 3};
        int[] in = new int[]{9, 3, 15, 20, 7};

        TreeNode tree = test.buildTree(post, in);
        System.out.println(tree);
    }
}
