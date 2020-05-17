package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/3
 */
public class Question1_9 {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        int len = s1.length();
        if (s1.equals(s2)) return true;
        s1+=s2;
        return s1.contains(s2);
    }
}
