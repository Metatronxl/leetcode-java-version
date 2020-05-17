package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/4
 */
public class Question2_3 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
