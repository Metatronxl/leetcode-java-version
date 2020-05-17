package swordOfOffer;

import java.util.Stack;

/**
 * @author lei.X
 * @date 2020/2/19
 */
public class DoubleStack {


    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    private void push(int node){

        stack1.push(node);
    }


    private int pop(int node){

        int result;
        if (!stack2.isEmpty()){
            result =  stack2.pop();
        }else {
            stack2.addAll(stack1);
            result =  stack2.pop();
        }

        return result;
    }

}
