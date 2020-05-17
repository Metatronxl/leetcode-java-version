package nowcoder;

/**
 * @author lei.X
 * @date 2020/4/19
 */
public class cakeNumber {




    int cakeNumber(int n)
    {
        // write code here
        int[] dp=new int[n+1];

        dp[n]=1;
        for(int i=n-1;i>=1;i--)
        {
            dp[i]=(dp[i+1]+1)*3/2;
        }

        return dp[1];
    }

    public static void main(String[] args) {

        cakeNumber cakeNumber = new cakeNumber();
        System.out.println(cakeNumber.cakeNumber(4));


    }
}
