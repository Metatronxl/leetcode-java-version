package ProgrammerSkills;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Question16_11 {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {//当0块时，就没有数据
            return new int[0];
        }
        if (shorter == longer) {//当最长和最短相等时，就只有一种
            int result[] = new int[1];
            result[0] = shorter * k;
            return result;
        }
        int result[] = new int[k + 1];
        //循环把可能的结果往数组里面塞
        for (int i = 0; i <= k; i++) {
            result[i] = (k - i) * shorter + i * longer;
        }

        return result;
    }



    public static void main(String[] args) {

        Question16_11 question16_11 = new Question16_11();
        int shorter = 1;
        int longer = 2;

        System.out.println(question16_11.divingBoard(1,1,3000));
    }
}
