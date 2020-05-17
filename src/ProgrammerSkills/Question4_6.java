package ProgrammerSkills;

import util.TreeNode;

import java.util.Stack;

/**
 * @author lei.X
 * @date 2020/5/12
 * 思路：分为向下找和 向上找
 *
 * 向下找就是找右节点的最小的数
 *
 * 向上找就是p是否为某一节点左节点
 *
 * cankao : https://leetcode-cn.com/problems/successor-lcci/solution/olognji-bie-er-cha-sou-suo-shu-hou-ji-cha-zhao-fei/
 */
public class Question4_6 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode tmp = p.right;
        if (p.right!=null){
            while (tmp !=null && tmp.left !=null ){
                tmp = tmp.left;
            }
            return tmp;
        }
        
        Stack<TreeNode>  stack = new Stack<>();
        tmp = root;
        while (tmp!= p){
            stack.push(tmp);
            if (tmp.val < p.val){
                tmp = tmp.right;
            }else {
                tmp = tmp.left;
            }
        }

        while (!stack.empty() && stack.peek().left != tmp){
            tmp = stack.pop();
        }

        if (!stack.empty()){
            return stack.peek();
        }else {
            return null;
        }

    }


}
