package ProgrammerSkills;

public class Question8_1 {




    public int waysToStep(int n) {

        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] =1;
        dp[2] =2;
        dp[3] =4;
        for (int i=4;i<n+1;i++){
            dp[i] = ((dp[i-1]+dp[i-2]+dp[i-3])% 1000000007) % 1000000007;
        }
        return dp[n];

    }

    public static void main(String[] args) {

        Question8_1 question8_1 = new Question8_1();
        System.out.println(question8_1.waysToStep(1000000));

    }

}
