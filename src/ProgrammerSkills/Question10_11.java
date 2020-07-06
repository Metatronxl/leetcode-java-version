package ProgrammerSkills;

import java.util.Arrays;

public class Question10_11 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 0 && nums[i] < nums[i - 1]) || (i % 2 != 0 && nums[i] > nums[i - 1])) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }


        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k] + ",");
        }
    }

    public static void main(String[] args) {
        Question10_11 question10_11 = new Question10_11();
        int[] nums = new int[]{5, 3, 1, 2, 3, 7};
        question10_11.wiggleSort(nums);
    }
}
