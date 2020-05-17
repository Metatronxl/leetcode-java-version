package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/3
 */
public class Question1_5 {


    public boolean oneEditAway(String first, String second) {

        int len1  = first.length();
        int len2 = second.length();

        if (len2 > len1){
            return oneEditAway(second,first);
        }

        if (len1- len2 > 1) return false;

        for (int i=0;i<len1;i++){
            for (int j=0;j<len2;j++){

                if (first.charAt(i) != second.charAt(j)){

                    return first.substring(i+1).equals(len1 == len2 ? second.substring(i+1): second.substring(i));
                }

            }
        }

        return true;

    }

        public static void main(String[] args) {
        Question1_5 question1_5 = new Question1_5();
        System.out.println(question1_5.oneEditAway("ab","bc"));
    }
}
