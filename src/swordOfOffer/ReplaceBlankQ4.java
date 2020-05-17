package swordOfOffer;

/**
 * @author lei.X
 * @date 2020/2/18
 */
public class ReplaceBlankQ4 {

    public static String replaceBlack(String rawString){

        if (rawString == null) return null;

        StringBuffer stringBuffer = new StringBuffer();

        for (int i=0;i<rawString.length();i++){

            if (rawString.charAt(i) == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(rawString.charAt(i));
            }
        }

        return stringBuffer.toString();
    }

}
