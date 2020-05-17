package nowcoder.Alibaba;

import java.util.Scanner;

/**
 * @author lei.X
 * @date 2020/4/20
 * 蚂蚁森林n个小动物，1~n,小动物编号越小能力越强，现在筛选国王，每个小动物都会崇拜别的小动物或者自己，但只会崇拜比自己能力强的小动物。
 * 每个动物可以投票给自己、自己崇拜的动物、自己崇拜的动物所崇拜的动物
    问每个人最多可以获得多少票。
 */
public class antForest {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();  // 代表有n个数

        int[] nums = new int[n+1]; // n个数的数组
        for (int i=1;i<=n;i++){
            nums[i] = scanner.nextInt();
        }

        int[]  dp = new int[n+1]; // 每个人可能获得的票数
        dp[n] = 1; // 最后那个人只能获得自己的票
        dp[nums[n]] +=1;  // 最后的小动物支持的动物的一票

        for (int i=n-1;i>=1;i--){
            if (nums[i]!=0){
                dp[nums[i]] += dp[i];  // 所有崇拜i的人都会给i崇拜的人投上一票
                dp[nums[i]] +=1;  // 给i崇拜的人投上一票
            }
            dp[i] +=1;   // 自己给自己投一票
        }

        for (int i=1;i<=n;i++){
            System.out.println(dp[i]);
        }
    }
}
