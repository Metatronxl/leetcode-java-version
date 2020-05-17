package dynamicprogramming;

/**
 * @author lei.X
 * @date 2020/3/16
 */
public class LCS {

    public static String LcsFunc(char[] A, char[] B){

            int lenA = A.length;
            int lenB = B.length;

            int[][] dp = new int[lenA+1][lenB+1];
            boolean boolFlag = true;
            String content = "";
            for (int i=0;i<lenA;i++){
                for (int j=0;j<lenB;j++){

                    if (A[i] == B[j]){
                        dp[i+1][j+1] = dp[i][j]+1;
                        if (boolFlag == true){
                            content += String.valueOf(A[i]);
                            boolFlag = false;
                        }
                    }else {
                        dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                    }
                }

                boolFlag = true;
            }


            return content;

    }



    public static void main(String[] args) {

        char[] A = "admadcf".toCharArray();
        char[] B = "adtrtac".toCharArray();

        String i = LcsFunc(A, B);
        System.out.println(i);
    }
}
