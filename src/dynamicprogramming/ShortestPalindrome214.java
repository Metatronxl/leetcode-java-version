package dynamicprogramming;

/**
 * @author lei.X
 */
public class ShortestPalindrome214 {

    public String shortestPalindrome(String s) {
        if(isPalindrome(s)) return s;
        StringBuilder sb_end = new StringBuilder();

        for (int i = s.length() -1; i >=1; i--){
            sb_end.append(s.charAt(i));
            if(isPalindrome(sb_end.toString()+s)) break;
        }
        return sb_end.append(s).toString();
    }

    public boolean isPalindrome(String s){
        for(int i = 0; i < s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }



}

