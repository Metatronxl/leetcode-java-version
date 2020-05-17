package BackTrackAndRecursive;

/**
 * @author lei.X
 * @date 2019/11/12
 */
public class NextPermutation31 {


    public void nextPermutation(int[] nums) {

        int start = nums.length - 2;
        while (start >= 0 && nums[start] >= nums[start + 1]) {
            start--;
        }
        if (start >= 0) {
            int end = nums.length - 1;
            while (end >= 0 && nums[start] >= nums[end]) {
                end--;
            }
            swapNum(nums, start, end);
        }

        inorderSort(nums, start + 1);

        printNum(nums);
    }

    private int[] inorderSort(int[] nums, int start) {

        int len = nums.length;
        for (int i = start; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    swapNum(nums, i, j);
                }
            }
        }

        return nums;

    }


    private void swapNum(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 5, 1};
        NextPermutation31 test = new NextPermutation31();
        test.nextPermutation(nums);

    }


    private void printNum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
    }

}
