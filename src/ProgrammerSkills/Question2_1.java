package ProgrammerSkills;

import java.util.List;

/**
 * @author lei.X
 * @date 2020/5/4
 */
public class Question2_1 {

      public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
      }

    public ListNode removeDuplicateNodes(ListNode head) {

          if (head == null) return head;
          ListNode first= head;
          while (first !=null){

              ListNode p = first.next;
              while (p !=null){

                  if (p.val == first.val) {
                      p.next = p.next.next;
                  }else {
                      p = p.next;
                  }
              }
              first = first.next;

          }

          return head;
    }
}
