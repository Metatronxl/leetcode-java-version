package swordOfOffer;

/**
 * @author lei.X
 * @date 2020/2/18
 */
//public class FindNextInOrderTreePoint {
//
//
//    public Common.TreeNode findNextInorderPoint(Common.TreeNode treeNode){
//
//        if (treeNode == null) return null;
//
//        // 如果这个点有右子节点的话，直接返回它的右子节点的最左节点
//        if (treeNode.right != null) return findLeftTreePoint(treeNode.right);
//        // 该点不存在右子节点，但自身为父节点的左节点
//        if (treeNode.parent.left == treeNode){
//            return treeNode.parent;
//        }
//        // 该点为父节点的右节点，则向上找到一个父节点为左节点的点
//
//    }
//
//
//    private Common.TreeNode findLeftTreePoint(Common.TreeNode treeNode){
//
//        if (treeNode != null){
//            treeNode = treeNode.left;
//        }
//
//        return treeNode;
//    }
//
//    private Common.TreeNode findParentTreePoint(Common.TreeNode treeNode){
//
//        if (treeNode.parent == null){
//            return null;
//        }
//
//        if (treeNode.parent.right == treeNode){
//            treeNode = treeNode.parent;
//        }
//
//        return treeNode.parent;
//    }
//}
