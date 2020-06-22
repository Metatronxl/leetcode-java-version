package ProgrammerSkills;

public class Question8_11 {

    int count;
    public int waysToChange(int n) {

        int[] coins = new int[]{25,10,5,1};

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=0;i<4;i++){
            for (int j=coins[i];j<=n;j++){
                dp[j] = (dp[j-coins[i]] + dp[j]) % 1000000007;
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {

        Question8_11 question8_11 = new Question8_11();
        System.out.println(question8_11.waysToChange(5));
    }
}
