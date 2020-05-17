package nowcoder.Alibaba;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author lei.X
 * @date 2020/4/23
 */
public class ali4132 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for (int i=0;i<n;i++){
            strings[i] = scanner.next();
        }


        Arrays.sort(strings, (o1, o2) -> {
            char first = o1.charAt(o1.length()-1);
            char second = o2.charAt(o2.length()-1);

            return (int)(first-second);
        });

        int[] dp = new int[27];

        for (int i=0;i<strings.length;i++){

            String str = strings[i];
            int sum=0;
            int left = str.charAt(0)-'a';
            int right = str.charAt(str.length()-1)-'a';

            for (int j=0;j<=left;j++){
                sum = Math.max(sum,dp[j]);
            }

            dp[right] = Math.max(dp[right],sum+str.length());
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);


        System.out.println("after sorting...");
        for (int i=0;i<n;i++){
            System.out.println(strings[i]);
        }
    }
}
