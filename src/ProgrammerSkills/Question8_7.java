package ProgrammerSkills;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用数组交换来实现全排列 ！！！非常重要
 */
public class Question8_7 {

    public String[] permutation(String S) {

        List<String> res = new ArrayList<>();
        res.add(S);
        int len = S.length();

        for (int i=0;i<len-1;i++){
            int listLen = res.size();
            for (int j=i+1;j<len;j++){
                for (int k=0;k<listLen;k++){
                    res.add(swap(res.get(k),i,j));
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }

    private String swap(String s, int i, int j) {

        char[] arr = s.toCharArray();
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];

        return new String(arr);

    }

    public static void main(String[] args) {

        Question8_7 question8_7 = new Question8_7();
        System.out.println(question8_7.permutation("abc"));


    }

}
