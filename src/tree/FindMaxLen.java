package tree;
import tree.TreeUtil.*;

/**
 * 求二叉树中的最远距离
 *
 * 思路：使用递归找到当前节点的最长左叶子节点的距离和最长右叶子节点的距离
 * 此时局部最远距离为leftLen+rightLen
 *
 */
public class FindMaxLen {


    public int  getMaxDepth(TreeNode root){

        if (root == null) return -1;
        return FindMaxLenFunc(root,0);
    }

    public int FindMaxLenFunc(TreeNode root,int maxDistance){
        if (root == null){
            return -1;
        }

        int heightOfLeftTree = FindMaxLenFunc(root.left,maxDistance);
        int heightOfRightTree = FindMaxLenFunc(root.right,maxDistance);

        int tmpDepth = heightOfLeftTree+heightOfRightTree;
        maxDistance = Math.max(maxDistance, tmpDepth);
        return Math.max(heightOfLeftTree, heightOfRightTree);
    }

}
