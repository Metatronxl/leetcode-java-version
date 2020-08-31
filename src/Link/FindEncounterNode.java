package Link;

/**
 * 寻找两个交叉链表交叉的节点
 *
 * 思路1： 先得到两个链表的长度，长的一方先走abs(len1-len2)步，然后再找相交点
 * 思路2： 遍历到结尾的点后过渡到另一条的链表的开头
 */
public class FindEncounterNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getNode1(ListNode root1,ListNode root2) {

            if (root1 ==null || root2 == null) return null;
            ListNode p = root1;
            ListNode q = root2;

            while (p !=null && q !=null){
                p = p.next;
                q = q.next;
            }
            if (p == null) p = root2;
            else  q = root1;

            while (p!= null && q !=null){
                p = p.next;
                q = q.next;
            }
            if (p == null) p = root2;
            else  q = root1;

            while (p!=null && q != null){
                if (p==q) return p;
                p = p.next;
                q = q.next;
            }
            return null;
    }

}
