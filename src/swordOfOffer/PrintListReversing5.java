package swordOfOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author lei.X
 * @date 2020/2/18
 */
public class PrintListReversing5 {


    public ArrayList<Integer> reverLinkList(Common.ListNode listNode){

        if (listNode == null){
            return new ArrayList<>(Collections.emptyList());
        }


        ArrayList<Integer> integers = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            integers.add(stack.pop());
        }


        return integers;
    }

}
