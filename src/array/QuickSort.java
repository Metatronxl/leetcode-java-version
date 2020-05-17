package array;

/**
 * @author lei.X
 * @date 2020/4/23
 */
public class QuickSort {


    public static void quickSort(int[] nums){

        if (nums == null) return;
        int len = nums.length;
        if (len == 0 || len ==1){
            return;
        }

        helper(nums,0,len-1);


    }

    private static void helper(int[] nums, int left, int right) {

        if (left > right){
            return;
        }
        int base = nums[left];
        int i=left,j=right;
        while (i<j){

            while (nums[j]>base && i<j){
                j--;
            }
            while (nums[i]<=base && i<j){
                i++;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        nums[left] = nums[i];
        nums[i] = base;

        helper(nums,left,i-1);
        helper(nums,i+1,right);


    }

}
