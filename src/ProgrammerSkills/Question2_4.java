package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/5
 */
public class Question2_4 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {

        if (head == null ) return null;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = head;  //循环节点(保证链表节点一直在往后递增)
        ListNode start = head.next; //当前节点，有可能会插到链表头

        while (start !=null){

            if (start.val < x){
                pre.next = start.next;
                start.next = dummyNode.next;
                dummyNode.next = start;
                start = pre.next;
            }else {
                pre = pre.next;
                start = start.next;
            }
        }


        head = dummyNode.next;
        while (head !=null){
            System.out.println(head.val);
            head = head.next;
        }

        return start;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(9);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        Question2_4 question2_4 = new Question2_4();
        question2_4.partition(head,5);
    }
}
