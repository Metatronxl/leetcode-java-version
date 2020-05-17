package ProgrammerSkills;

import util.TreeNode;

/**
 *  首先判断t1和t2 值的情况，如果均为空则返回true，一个为空说明不相同返回false
 *  其次判断当前t1和t2的值，如果相同，则接着比较他们的左右节点的情况(此处采用递归)
 *  如果t1和t2值不同，则将t1.left、t1.right来和t2接着比较(使用递归)
 */

public class Question4_10 {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return true;
        }else if (t1 == null || t2==null){
            return false;
        }

        if (t1.val == t2.val){  //当前值相同

            Boolean  leftBool = checkSubTree(t1.left,t2.left);
            Boolean rightBool = checkSubTree(t1.right,t2.right);
            if (leftBool && rightBool){
                return true;
            }else {
                return false;
            }
        }else {
            if (checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2)){
                return true;
            }else {
                return false;
            }
        }

    }

}
