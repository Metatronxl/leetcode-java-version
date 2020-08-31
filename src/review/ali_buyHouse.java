package review;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 购房者钱最少的最先买
 * 房子按照舒适度最高来排序
 *
 */
public class ali_buyHouse {

    public int maxProfit(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] money = new int[n];
        for (int i=0;i<n;i++){
            money[i] = scanner.nextInt();
        }
        int[][] house = new int[m][2];
        for (int i=0;i<m;i++){
            house[i][0] = scanner.nextInt();
            house[i][0] = scanner.nextInt();
        }

        Arrays.sort(money);
        Arrays.sort(house, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]- o1[0];
            }
        });
        int idx=0;
        int res =0;
        for (int i=0;i<m;i++){
            while (idx < n ){
                if (money[idx] >= house[i][1]){
                    res += house[i][0];
                    break;
                }
                idx++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int[][] houses = new int[m][2];
        for (int i = 0; i < m; i++) {
            houses[i][0] = sc.nextInt();
            houses[i][1] = sc.nextInt();
        }
        Arrays.sort(coins, (o1, o2) -> o2 - o1);
        Arrays.sort(houses, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });
        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && coins[i] < houses[j][1]){
                j++;
            }
            if (j == m){
                break;
            }else {
                ans += houses[j][0];
                j++;
            }
        }
        System.out.println(ans);
    }
}
