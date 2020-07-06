package ProgrammerSkills;

public class Question16_1 {

    public int[] swapNumbers(int[] numbers) {
            numbers[0] ^= numbers[1];
            numbers[1] ^= numbers[0];
            numbers[0] ^= numbers[1];
            return numbers;
    }

    public static void main(String[] args) {

        Question16_1 question16_1 = new Question16_1();
        int[] nums = new int[]{3,7};
        int[]  res = question16_1.swapNumbers(nums);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }
}
