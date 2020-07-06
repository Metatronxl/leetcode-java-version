package ProgrammerSkills;

import java.util.*;

public class Question16_20 {

    public List<String> getValidT9Words(String num, String[] words) {

        if (num==null || num.length() == 0 || words==null || words.length==0) return null;

        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        char[] numChar = num.toCharArray();
        int[] nums = new int[num.length()];
        for (int i=0;i<numChar.length;i++){
            nums[i] = numChar[i]-'0';
        }
        boolean[] trueWords = new boolean[words.length];
        for (int i=0;i<trueWords.length;i++){
            trueWords[i] = true;
        }
        for (int i=0;i<nums.length;i++){ // 遍历得到的输入数字

            String str = map.get(nums[i]);
            char[] strArr = str.toCharArray();

            for (int j=0;j<words.length;j++){
                char ch = words[j].charAt(i);  // 当前words中，对应的字母
                if (trueWords[j] &&  !containChar(strArr,ch)){
                    trueWords[j] = false;
                }
            }

        }
        List<String> res = new ArrayList<>();
        for (int i=0;i<words.length;i++){
            if (trueWords[i] == true){
                res.add(words[i]);
            }
        }
        String[] ans = new String[res.size()];
        for (int i=0;i<ans.length;i++){
            ans[i] = res.get(i);
        }

        return res;
    }


    private boolean containChar(char[] chars, char ch){
        for (int i=0;i<chars.length;i++){
            if (chars[i] == ch){
                return true;
            }
        }
        return false;
    }


    /**
     * 方法2：
     *     作者：lifengcai_fans
     *     链接：https://leetcode-cn.com/problems/t9-lcci/solution/qian-zhui-shu-de-ti-ji-hu-du-shi-tao-mo-ban-by-lif/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param num
     * @param words
     * @return
     */
    public List<String> getValidT9Words2(String num, String[] words) {
        int[] key = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
        HashMap<String, String> map = new HashMap<>();
        for (String s : words) {
            StringBuilder builder = new StringBuilder();
            char[] array = s.toCharArray();
            for (char c : array) {
                builder.append(key[c - 'a']);
            }
            map.put(s, builder.toString());
        }
        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key1 = entry.getKey();
            String value = entry.getValue();
            if (value.equals(num)) res.add(key1);
        }
        return res;
    }




    public static void main(String[] args) {
        Question16_20 question16_20 = new Question16_20();
        String num = "2";
        String[] words = new String[]{"a","b","c","d"};
        System.out.println(question16_20.getValidT9Words(num,words));
    }
}
