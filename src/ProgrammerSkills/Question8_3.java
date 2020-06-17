package ProgrammerSkills;

public class Question8_3 {

    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        for(int i=0;i<len;i++){
            if (i == nums[i]){
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        Question8_3 question8_3 = new Question8_3();
        int[]  nums = new int[]{1,1,1,1};
        System.out.println(question8_3.findMagicIndex(nums));

    }
}
