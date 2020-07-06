package ProgrammerSkills;

import java.util.HashSet;
import java.util.Set;

/**
 * set为hash表，所以空间复杂度为O(n)，总时间复杂度度为O(n)
 */
public class Question16_21 {

    public int[] findSwapValues(int[] array1, int[] array2) {

        Set<Integer> set = new HashSet<>();
        int sum1=0,sum2=0;
        for (int num:array1){
            sum1+=num;
        }
        for (int num:array2){
            sum2+=num;
            set.add(num);
        }

        int diff = sum1-sum2;
        if (diff % 2 != 0) return new int[0];
        diff = diff/2;

        for (int i=0;i<array1.length;i++){
            if (set.contains(array1[i]-diff)){
                return new int[]{array1[i],array1[i]-diff};
            }
        }

        return new int[0];
    }


    public static void main(String[] args) {

        Question16_21 question16_21 = new Question16_21();
        int[] array1 = new int[]{4,1,2,1,1,2};
        int[] array2 = new int[]{3,6,3,3};
        System.out.println(question16_21.findSwapValues(array1,array2));
    }
}
