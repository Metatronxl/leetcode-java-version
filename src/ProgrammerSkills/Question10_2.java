package ProgrammerSkills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *   将变换位置后的字符串变为一个相同的key存入Hashmap中
 */
public class Question10_2 {
    public List<List<String>> groupAnagrams(String[] strs) {

        int len = strs.length;
        HashMap<String,List<String>> map = new HashMap<>(len);
        for (String str: strs){
            int[] count = new int[26];
            int str_len = str.length();
            for (int i=0;i<str_len;i++){
                count[str.charAt(i)-'a'] +=1;
            }
            StringBuilder sb = new StringBuilder();
            for (int num: count){
                sb.append(num+".");
            }

            map.computeIfAbsent(sb.toString(), unused -> new LinkedList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
