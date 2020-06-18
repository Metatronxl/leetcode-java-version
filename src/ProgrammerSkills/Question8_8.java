package ProgrammerSkills;

import java.util.ArrayList;
import java.util.List;

/**
 * 需要处理重复字符的排列组合
 *
 */
public class Question8_8 {

    public String[] permutation(String S) {

        List<String> res = new ArrayList<String>();
        int len = S.length();
        if (len == 0 ) return new String[0];
        boolean[] used = new boolean[len];
        char[] sChar = S.toCharArray();
        StringBuilder sb = new StringBuilder(len);

        return res.toArray(new String[0]);

    }

    private void helper(List<String> res,char[] sChar,boolean[] used,StringBuilder sb,int len,int depth){
        if (depth == len){
            res.add(sb.toString());
            return;
        }

        for (int i=0;i<len;i++){
            if (!used[i]){

                if (i>0 && sChar[i]==sChar[i-1] && !used[i-1]){
                    continue;
                }

                sb.append(sChar[i]);
                used[i] = true;
                helper(res,sChar,used,sb,len,depth+1);
                sb.deleteCharAt(depth);
                used[i] = false;
            }
        }
    }



    public static void main(String[] args) {

        Question8_8 question8_8 = new Question8_8();
        System.out.println(question8_8.permutation("OSS"));


    }
}
