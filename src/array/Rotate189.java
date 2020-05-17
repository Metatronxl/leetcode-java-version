package array;

/**
 * @author lei.X
 * @date 2019/11/27
 */
public class Rotate189 {


    /**
     * 使用额外的数组，我们可以用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度
     * 的位置。然后把新的数组拷贝到原数组中。
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k){

        int[] a = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            a[(i+k) % nums.length] = nums[i];
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = a[i];
        }
    }

    /**
     * 环状替代法
     *
     * 直接将当前数放到它该放置的正确位置（即next = (current_point + k) % nums.length;），使用temp来保存要被替换的数
     * 这个过程需要被执行n次，这种方法可能会有个问题，如果 n%k==0，其中 k= k%nk （因为如果 k 大于 n ，移动 k 次
     * 实际上相当于移动 k%n次）。这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。此时，我们应该从下一个数字开始再重复相同的过程。
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k){

        k = k % nums.length;
        int count=0;
        for(int start=0;count<nums.length;start++){
            int current_num = nums[start];
            int current_point = start;
            do {
                int next = (current_point+k)%nums.length;
                int next_num = nums[next];

                nums[next] = current_num;
                current_point = next;
                current_num = next_num;
                count++;
            }while (start != current_point);
        }

    }




    public static void main(String[] args) {

        Rotate189 test = new Rotate189();
        int num[] = new int[]{-1};
        test.rotate(num,2);
    }
}
