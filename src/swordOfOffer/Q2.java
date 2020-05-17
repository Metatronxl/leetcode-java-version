package swordOfOffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lei.X
 * @date 2020/2/13
 */
public class Q2 {

    /**
     * 通过使用Hash来判断数字是否为重复的
     * Time Complexity: O(n)
     * Space Complexity:O(n)
     * @param nums
     * @return
     */
    public int findDuplicateNum(int[] nums){

        HashMap<Integer,Integer> hash = new HashMap<>();
        int len  = nums.length;

        for (int i=0;i<len;i++){

            int num = nums[i];
            if (hash.containsKey(num)){
                return num;
            }else {
                hash.put(num,1);
            }
        }
        return -1;
    }



}
