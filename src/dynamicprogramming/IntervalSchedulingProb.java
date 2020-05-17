package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lei.X
 * @date 2020/3/30
 */
public class IntervalSchedulingProb {


    public static int balloonProblem(int[][] balloons){

        if (balloons.length == 0) return 0;

        Arrays.sort(balloons, (o1, o2) -> o1[1]-o2[1]);
        int[] judge = new int[balloons.length];

        int end = balloons[0][1];
        int count =1;
        for (int i=1;i<balloons.length;i++){

            if (balloons[i][0] > end){
                end = balloons[i][1];
                count++;
            }
        }

        return count;

    }
}
