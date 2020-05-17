package ProgrammerSkills;

import java.util.ArrayList;
import java.util.Arrays;

import util.ConstuctTreeWithArray;
import util.TreeNode;

/**
 * @author lei.X
 * @date 2020/5/9
 */
public class Question4_3 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ArrayList<ListNode> listNodeArrayList = new ArrayList<>();
    public ArrayList<TreeNode> treeNodesStack1= new ArrayList<>();
    public ArrayList<TreeNode> treeNodesStack2 = new ArrayList<>();

    public ListNode[] listOfDepth(TreeNode tree) {


        if(tree == null) return null;

        treeNodesStack1.add(tree);

        while (!treeNodesStack1.isEmpty() || !treeNodesStack2.isEmpty()){
            ListNode start = new ListNode(0);
            ListNode dummy = start;
            if (!treeNodesStack1.isEmpty()){
                for (TreeNode treeNode : treeNodesStack1){
                    dummy.next = new ListNode(treeNode.val);
                    dummy = dummy.next;

                    if (treeNode.left !=null) treeNodesStack2.add(treeNode.left);
                    if (treeNode.right != null) treeNodesStack2.add(treeNode.right);
                }
                treeNodesStack1.clear();

            }else {
                for (TreeNode treeNode : treeNodesStack2){
                    dummy.next = new ListNode(treeNode.val);
                    dummy = dummy.next;
                    if (treeNode.left !=null) treeNodesStack1.add(treeNode.left);
                    if (treeNode.right != null) treeNodesStack1.add(treeNode.right);

                }
                treeNodesStack2.clear();
            }

            listNodeArrayList.add(start.next);
            System.out.println("test");
        }

        int size = listNodeArrayList.size();
        ListNode[] listNodes = new ListNode[size];
        for (int i=0;i<size;i++){
            listNodes[i] = listNodeArrayList.get(i);
        }

        return listNodes;
    }


    public static void main(String[] args) {

        Integer[] nums = {1,2,3,4,5,null,7,8};
        TreeNode treeNode = ConstuctTreeWithArray.buildBinaryTreeWithArray(Arrays.asList(nums));

        Question4_3 question4_3 = new Question4_3();
        question4_3.listOfDepth(treeNode);



    }


}
