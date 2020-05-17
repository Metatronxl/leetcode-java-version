package array;

import java.util.TreeSet;

/**
 * @author lei.X
 * @date 2019/12/13
 * 使用 TreeSet（结合 Map 和 BST）加滑动窗口实现
 */
public class containDuplicate220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();
        for (int i=0;i<nums.length;i++){

            // 找到这样一个num[i]，让它ceiling之间的值是小于t的
            Long ceiling = set.ceiling((long)nums[i] - t);
            if (ceiling != null && ceiling <= (long)nums[i]+t){
                return true;
            }

            // 当set的size 大于 k时，说明set集中元素多于k个，这时候就不能保证符合大小要求的元素距离在k之间了
            set.add((long) nums[i]);
            if (set.size() > k){
                set.remove((long)nums[i-k]);
            }
        }

        return false;

    }

    public static void main(String[] args) {
//        containDuplicate220 test = new containDuplicate220();
//        int[] num = new int[]{-1,2147483647};
//        test.containsNearbyAlmostDuplicate(num,1,2147483647);
        System.out.println(Math.abs(-1-2147483647));
    }
}
