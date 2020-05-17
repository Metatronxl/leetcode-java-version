package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lei.X
 * @date 2019/9/2
 */
public class tree105 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] pre, int[] in) {

        Map<Integer,Integer> valueToIdx = new HashMap<>();
        for (int i=0;i<in.length;i++){
            valueToIdx.put(in[i],i);
        }

        return buildTree(pre,new int[]{0},0,in.length-1,valueToIdx);
    }

    private TreeNode buildTree(int[] pre, int[] prePointer, int inStart, int inEnd,Map<Integer,Integer> valueToIdx){

        if (inStart > inEnd){
            return null;
        }

        int currentNodeVal = pre[prePointer[0]++];
        TreeNode currNode = new TreeNode(currentNodeVal);
        if (inStart == inEnd){
            return currNode;
        }

        int inIdxCurrNode = valueToIdx.get(currentNodeVal);
        currNode.left = buildTree(pre,prePointer,inStart,inIdxCurrNode-1,valueToIdx);
        currNode.right = buildTree(pre,prePointer,inIdxCurrNode+1,inEnd,valueToIdx);
        return currNode;
    }




    public static void main(String[] args) {

        tree105 test = new tree105();
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};

        TreeNode tree = test.buildTree(pre, in);
        System.out.println(tree);
    }
}
