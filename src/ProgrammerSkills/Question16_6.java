package ProgrammerSkills;

import java.util.Arrays;

/**
 *     作者：tago-tech
 *     链接：https://leetcode-cn.com/problems/smallest-difference-lcci/solution/shuang-zhi-zhen-jie-jue-absyi-chu-fang-fa-by-lcbir/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *     fun2是解决溢出的方案
 *
 */
public class Question16_6 {

    public int smallestDifference(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) return -1;
        Arrays.sort(a);
        Arrays.sort(b);
        int abs = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int temp = Math.abs(a[i] - b[j]);
            if (temp < abs) {
                abs = temp;
            }

            if (a[i] < b[j]){
                i++;
            }else {
                j++;
            }

        }
        return abs;
    }


    public static int smallestDifference2(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) return -1;
        int minDiff = Integer.MIN_VALUE , aIdx = 0 , bIdx = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (aIdx < a.length && bIdx < b.length) {
            //关键，解决溢出 ， 负数域 大于 正数域。
            minDiff = Math.max(minDiff,-Math.abs(a[aIdx] - b[bIdx]));

            if (a[aIdx] < b[bIdx]) {
                aIdx++;
            }
            else {
                bIdx++;
            }
        }
        //反置
        return Math.abs(minDiff);
    }



    public static void main(String[] args) {
        Question16_6 question16_6 = new Question16_6();
        int[] a = new int[]{1, 3, 15, 11, 2};
        int[] b = new int[]{23, 127, 235, 19, 8};
        System.out.println(question16_6.smallestDifference(a,b));
    }

}
