package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/4
 */
public class Question2_2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int kthToLast(ListNode head, int k) {

       ListNode slow = head;
       ListNode fast = head;
       int count=1;
       while (count<k){
           count++;
           fast = fast.next;
       }
       while (fast.next !=null){
           fast = fast.next;
           slow  = slow.next;
       }

       return slow.val;

    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Question2_2 question2_2 = new Question2_2();
        System.out.println(question2_2.kthToLast(head,2));

    }
}
