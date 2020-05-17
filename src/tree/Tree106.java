package tree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lei.X
 * @date 2020/4/7
 */
public class Tree106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    public TreeNode buildTree(int[] post, int[] in) {

        HashMap<Integer,Integer> InIdxHashMap = new HashMap<>();
        for (int i=0;i<in.length;i++){
            InIdxHashMap.put(in[i],i);
        }

        return helper(post,in,InIdxHashMap);

    }

    private  TreeNode helper(int[] post,int[] in, HashMap<Integer,Integer> inIdxHashMap){

        if (post.length == 0){
            return null;
        }


        int currNodeVal = post[post.length-1];
        int inIdx = inIdxHashMap.get(currNodeVal);
        TreeNode currNode = new TreeNode(currNodeVal);

        int[] leftInOrder = Arrays.copyOfRange(in,0,inIdx);
        int[] leftPostOrder = Arrays.copyOfRange(post,0,inIdx);
        currNode.left = helper(leftInOrder,leftPostOrder,inIdxHashMap);

        int[] rightInOrder = Arrays.copyOfRange(in,inIdx+1,in.length-1);
        int[] rightPostOrder = Arrays.copyOfRange(post,inIdx,post.length-1);
        currNode.right = helper(rightInOrder,rightPostOrder,inIdxHashMap);

        return currNode;

    }

}
