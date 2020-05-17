package swordOfOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lei.X
 * @date 2020/2/18
 *
 */
public class RebuildBinaryTree {



    public Common.TreeNode  RebuildBinaaryTreeWithPreOrderAndInorder(int[] pre, int[] in){

        if (pre.length == 0|| in.length == 0){
            return null;
        }

        Common.TreeNode finalTree = new Common.TreeNode(pre[0]);

        for (int i=0;i<in.length;i++){

            if (pre[0] == in[i]){

                finalTree.left = RebuildBinaaryTreeWithPreOrderAndInorder(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                finalTree.right = RebuildBinaaryTreeWithPreOrderAndInorder(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }


        }

        return finalTree;
    }

}
