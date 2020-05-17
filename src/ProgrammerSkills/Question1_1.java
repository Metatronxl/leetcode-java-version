package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/2
 */
public class Question1_1 {


    public boolean isUnique(String astr) {
        int len = astr.length();
        char[] achar = astr.toCharArray();
        if(len > 26){
            return false;
        }

        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){

                if (achar[j]-'a' < achar[i]-'a'){

                    char temp = achar[i];
                    achar[i] = achar[j];
                    achar[j] = temp;
                }else if (achar[j]-'a' == achar[i]-'a'){
                    return false;
                }
            }
        }

        return true;

    }
}
