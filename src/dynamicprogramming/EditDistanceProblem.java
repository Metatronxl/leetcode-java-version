package dynamicprogramming;


/**
 * @author lei.X
 * @date 2020/3/20
 */
public class EditDistanceProblem {


    public static int EditDistance(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        int[][] DpTable = new int[len1+1][len2+1];

        for (int i=1;i<len1;i++){
            DpTable[i][0] = i;
        }
        for (int j=1;j<len2;j++){
            DpTable[0][j] = j;
        }
        // 从字符串的开头开始求解
        for(int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    DpTable[i][j] = DpTable[i-1][j-1];
                }else {
                    DpTable[i][j] = Math.min(DpTable[i-1][j-1]+1,

                            Math.min(DpTable[i-1][j]+1,DpTable[i][j-1]+1)
                            );
                }
            }
        }
        // 储存着整个 s1 和 s2 的最⼩编辑距离
        return DpTable[len1][len2];


    }

    private static int helper(char[] s1Arr, char[] s2Arr, int len1, int len2, int[][] dict) {

        if (len1 == -1){
            return len2+1;
        }
        if (len2 == -1){
            return len1+1;
        }

        if (dict[len1][len2] !=-1){
            return dict[len1][len2];
        }


        if (s1Arr[len1] == s2Arr[len2]){

            dict[len1][len2] = helper(s1Arr,s2Arr,len1-1,len2-1,dict);
        }else {

            dict[len1][len2] = Math.min(

                    helper(s1Arr,s2Arr,len1,len2-1,dict)+1,
                    Math.min(

                            helper(s1Arr,s2Arr,len1-1,len2,dict)+1,
                            helper(s1Arr,s2Arr,len1-1,len2-1,dict)+1
                    )
            );
        }

        return dict[len1][len2];

    }


    public static void main(String[] args) {

        String s1 = "intention";
        String s2 = "execution";

        int distance = EditDistance(s1, s2);
        System.out.println(distance);
    }
}
