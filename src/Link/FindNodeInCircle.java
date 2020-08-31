package Link;




public class FindNodeInCircle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getNodeFromCircle(ListNode root){

        ListNode fast = root;
        ListNode slow = root;

        while (fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }

        ListNode start = root;
        while (start != slow){
            start = start.next;
            slow = slow.next;
        }

        return start;
    }
}
