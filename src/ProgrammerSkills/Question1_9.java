package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/3
 *
 * 同一字符串*2，会包含原来的字符串
 */
public class Question1_9 {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        if (s1.equals(s2)) return true;
        s1+=s1;
        return s1.contains(s2);
    }
}
