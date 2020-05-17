package ProgrammerSkills;

import util.TreeNode;

/**
 * @author lei.X
 * @date 2020/5/11
 * 作者：xiao-lu-27
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/solution/dai-qu-jian-de-di-gui-jian-dan-yi-dong-shuang-bai-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Question4_5 {


    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        return helper(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }


    public boolean helper(TreeNode root, long min, long max) {

        if (root == null) return true;

        if (min >= root.val || max <= root.val) {
            return false;
        }

        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);
        return left && right;

    }


}
