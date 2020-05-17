package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/2
 */
public class Question1_3 {

    public String replaceSpaces(String S, int length) {

       StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i<length;i++){

            if (S.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(S.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
