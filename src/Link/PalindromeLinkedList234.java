package Link;

/**
 * @author lei.X
 */
public class PalindromeLinkedList234 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode last = slow.next;
        ListNode pre = head;

        while (last.next != null){
            ListNode temp = last.next;
            last.next = temp.next;
            temp.next = slow.next;
            slow.next = temp;
        }

        while (slow.next != null){
            slow = slow.next;
            if (pre.val != slow.val) return false;
            pre = pre.next;
        }



        return true;


    }


}
