package ProgrammerSkills;

public class Question5_3 {

    public int reverseBits(int num) {

        int max =0;
        int cur = 0;
        int preCur = 0;

        while (num>0){
            int judge = num & 1;
            if (judge == 1){
                cur++;
            }else {
                if (cur+preCur +1 > max){
                    max = cur + preCur+1;
                }
                preCur = cur;
                cur = 0;

            }
            num >>= 1;
        }

        if (cur +preCur +1 > max) max = cur + preCur +1;

        return max;
    }

    public static void main(String[] args) {

        Question5_3 question5_3 = new Question5_3();
        System.out.println( question5_3.reverseBits(1775));
    }
}
