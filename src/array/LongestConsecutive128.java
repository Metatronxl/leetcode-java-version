package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lei.X
 * @date 2019/12/31
 */
public class LongestConsecutive128 {

    public int longestConsecutive(int[] nums) {

        Set<Integer> num_set = new HashSet<>();
        for (int num : nums){
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num: num_set){

            if(!num_set.contains(num-1)){  // 如果set中不包含num-1 ，说明num是一个子序列的开端

                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)){ // while循环在整个运行过程中只会被迭代N次
                    currentNum +=1;
                    currentStreak+=1;
                }

                longestStreak = Math.max(longestStreak,currentStreak);
            }


        }

        return longestStreak;
    }
}
