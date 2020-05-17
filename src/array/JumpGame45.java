package array;

/**
 * @author lei.X
 * @date 2019/12/17
 */
public class JumpGame45 {

    /**
     * [2,       3,1,       1,2,2,1]
     [2,3,       1,1,2,       2,1]
     [2,3,1,1,2,       2,1        ]

     将数组分成三段，最左边，已经到达的位置。中间，此次可以到达的位置。右边，本次不能到达的位置。
     对于数组[2,       3,1,       1,2,2,1]。第一步可以到达index=1或者index=2.但是如果调到index=1的话显然下次可以跳的更远。因此第一步跳到index=1的位置。
     变成[2,3,       1,1,2,       2,1]。第二次可以到达index=2，3，4。显然跳到index=4的话，下次可以跳的更远。
     此时变成[2,3,1,1,2,       2,1       ]。此时一次跳2步到达最右端。
     总结一下规律，我们在跳的时候会考虑到下一步。根据下一步能跳的最远的贪心策略，来进行每一步的选择

     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        int cnt =0;
        int right = 0;
        int maxPos = 0;

        for (int i=0;i<nums.length-1;i++){
            maxPos = (nums[i]+i) > maxPos ? (nums[i]+i) : maxPos;
            if (right == i){
                right = maxPos;
                cnt++;
            }
        }

        return cnt;

    }


    public static void main(String[] args) {

        JumpGame45 jumpGame45 = new JumpGame45();
        int[] test = new int[]{2,3,1,1,4};
        System.out.println(jumpGame45.jump(test));
    }
}
