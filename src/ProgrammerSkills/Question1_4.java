package ProgrammerSkills;

import java.util.HashMap;

/**
 * @author lei.X
 * @date 2020/5/3
 */
public class Question1_4 {

    public boolean canPermutePalindrome(String s) {

        HashMap<Integer,Integer> alphaHashMap = new HashMap<>();
        for (int i=0;i<s.length();i++){

            int key = s.charAt(i)-'a';
            if (alphaHashMap.containsKey(key)){
                alphaHashMap.put(key,alphaHashMap.get(key)+1);
            }else {
                alphaHashMap.put(key,1);
            }
        }

        int count=0;
        for (Integer key:alphaHashMap.keySet()){

            if ( alphaHashMap.get(key) % 2 !=0){
                count++;
                if (count >1){
                    return false;
                }
            }
        }

        return true;

    }
}
