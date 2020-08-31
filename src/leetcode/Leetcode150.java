package leetcode;

import java.util.Stack;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {

        Stack<Character> op = new Stack<>();
        Stack<Integer>  nums = new Stack<>();

        int len = tokens.length;
        for ( int i=0;i<len;i++){

            if (isOperator(tokens[i])){
                int num1 = nums.pop();
                int num2 = nums.pop();
                int temp=0;
                switch (tokens[i]){
                    case "+":
                        temp = num1+num2;
                        break;
                    case "-":
                        temp = num2-num1;
                        break;
                    case "*":
                        temp = num1*num2;
                        break;
                    case "/":
                        temp = num2/num1;
                        break;
                    default:
                        break;
                }
                nums.push(temp);
            }else {
                nums.push(Integer.parseInt(tokens[i]));
            }
        }

        return nums.peek();

    }

    private boolean isOperator(String ch){

        if (ch.equals("+") || ch.equals("-") || ch.equals("*")|| ch.equals("/")){
            return true;
        }
        else {
            return false;
        }
    }


    public static void main(String[] args) {

        Leetcode150 leetcode150 = new Leetcode150();
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(leetcode150.evalRPN(tokens));
    }
}
