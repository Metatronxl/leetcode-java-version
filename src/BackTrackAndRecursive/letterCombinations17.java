package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/11/19
 */
public class letterCombinations17 {

    public List<String> letterCombinations(String digits) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        char[] inputCharArr = digits.toCharArray();
        if (inputCharArr.length == 0){
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();

        recursiveFunc(map, inputCharArr, 0, res, new ArrayList<>());

        return res;

    }


    private void recursiveFunc(HashMap<Integer, String> map, char[] charArr, int idx, List<String> res, List<String> pre) {

        if (idx == charArr.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pre.size(); i++) {
                sb.append(pre.get(i));
            }
            res.add(sb.toString());
            return;
        }

        int key = Integer.parseInt(String.valueOf(charArr[idx]));
        String subStr = map.get(key);
        char[] subStrArr = subStr.toCharArray();

        for (int i = 0; i < subStr.length(); i++) {
            pre.add(subStrArr[i] + "");
            recursiveFunc(map, charArr, idx + 1, res, pre);
            pre.remove(pre.size()-1);
        }

    }


    public static void main(String[] args) {

        letterCombinations17 test = new letterCombinations17();
        test.letterCombinations("23");

    }
}
