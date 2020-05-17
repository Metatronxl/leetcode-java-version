package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lei.X
 * @date 2019/12/11
 */
public class MajorityElement229 {

    public List<Integer> majorityElement(int[] nums) {

        int len = nums.length;
        int filter = len/3;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<len;i++){
            if (hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1); // add 1
                if (hashMap.get(nums[i]) > filter){
                }
            }else{
                hashMap.put(nums[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if (entry.getValue() > filter){
                result.add(entry.getKey());
            }
        }


        return result;
    }


    public static void main(String[] args) {

        MajorityElement229 test = new MajorityElement229();
        int[] num = new int[]{1,1,1,3,3,2,2,2};
        System.out.println(test.majorityElement(num));
    }
}
