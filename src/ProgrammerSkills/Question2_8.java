package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/7
 */
public class Question2_8 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }



        ListNode slow = head;
        ListNode fast = head;

        while (fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.next== null){  // 没有交点
            return null;
        }

        /**
         * 找到交点后，start点从head开始，fast点从交点开始，相交处即为环的入口处
         */
        ListNode start= head;
        while (start != fast){
            start = start.next;
            fast = fast.next;
        }
        return start;
    }
}
