package Link;

/**
 * @author lei.X
 */
public class ReverseLinkedLIst206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode pre = new ListNode(0);
        pre.next = head;

        while (head.next != null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return pre.next;
    }


}

