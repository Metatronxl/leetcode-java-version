package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/5
 */
public class Question2_5 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

       ListNode p1 = l1,p2=l2,result = new ListNode(0);
       ListNode p = result;
       int carr=0;

       while (p1!=null || p2!=null || carr >0){

           int sum = carr;
           sum += p1 == null ? 0: p1.val;
           sum += p2 == null ? 0: p2.val;

           p.next = new ListNode(sum %10);
           p = p.next;

           carr = sum/10;

           if (p1 !=null){
               p1 = p1.next;
           }
           if (p2 !=null){
               p2 = p2.next;
           }
       }

       return result.next;
    }


    public static void main(String[] args) {

        Question2_5 question2_5 = new Question2_5();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        question2_5.addTwoNumbers(l1,l2);
    }
}
