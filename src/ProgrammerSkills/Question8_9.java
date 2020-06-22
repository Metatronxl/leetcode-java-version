package ProgrammerSkills;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question8_9 {

    public List<String> generateParenthesis(int n) {

        if (n==0) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n,res,sb,0,0);

        return res;

    }

    private void helper(int n, List<String> res, StringBuilder sb, int left, int right) {

        if (left + right == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (left < n){
            sb.append("(");
            helper(n,res,sb,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }

        if (right < n && left > right){
            sb.append(")");
            helper(n,res,sb,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public static void main(String[] args) {
        Question8_9 question8_9 = new Question8_9();
        question8_9.generateParenthesis(3);
    }
}
