package ProgrammerSkills;

import javax.swing.*;

/**
 * @author lei.X
 * @date 2020/5/6
 */
public class Question2_6 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;
        ListNode halfNode = findMidNode(head);
        ListNode fastNode = reverseNode(halfNode.next);

        ListNode curr1 = head;
        ListNode curr2 = fastNode;

        while (curr1 !=null && curr2!=null){

            if (curr1.val != curr2.val){
                return false;
            }

            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }

    private static ListNode reverseNode(ListNode head){

        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur !=null){
            ListNode temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }

        return dummy.next;

    }

    private static ListNode findMidNode(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Question2_6 question2_6 = new Question2_6();
        System.out.println(question2_6.isPalindrome(head));

    }
}
