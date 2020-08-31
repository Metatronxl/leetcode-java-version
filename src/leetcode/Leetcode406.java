package leetcode;

import java.util.*;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 */
public class Leetcode406 {


    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]== o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for (int[]p : people){
            output.add(p[1],p);
        }
        int len = people.length;
        return output.toArray(new int[len][2]);
    }

    public static void main(String[] args) {
        Leetcode406 leetcode406 = new Leetcode406();
        int[][] peopen = new int[][]{
                {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };

        leetcode406.reconstructQueue(peopen);
    }
}
