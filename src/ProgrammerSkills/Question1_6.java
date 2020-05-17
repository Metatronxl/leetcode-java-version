package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/3
 */
public class Question1_6 {

    public String compressString(String S) {

        if (S.length() == 0){
            return S;
        }

        StringBuilder sb = new StringBuilder();
        int count=1;
        char curChar= S.charAt(0);
        sb.append(curChar);
        for (int i=1;i<S.length();i++){
            if (S.charAt(i) == curChar){
                count++;
            }else {
                sb.append(count);
                count=1;
                curChar=S.charAt(i);
                sb.append(curChar);
            }
        }
        sb.append(count);

        if (sb.length() > S.length()){
            return S;
        }else{

            return sb.toString();
        }


    }


    public static void main(String[] args) {

        Question1_6 question1_6 = new Question1_6();
        System.out.println(question1_6.compressString("abbccd"));

    }
}
