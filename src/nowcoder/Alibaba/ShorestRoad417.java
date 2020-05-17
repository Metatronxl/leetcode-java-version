package nowcoder.Alibaba;

import java.util.Scanner;

/**
 * @author lei.X
 * @date 2020/4/2
 */
public class ShorestRoad417 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cityLevel = new int[n+1];
        for (int i=1;i<=n;i++){
            cityLevel[i] = scanner.nextInt();
        }

        int[][] roads = new int[n+1][n+1];


        int INF = Integer.MAX_VALUE;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (i==j){
                    roads[i][j]=0;
                }else {
                    roads[i][j] = INF;
                }
            }
        }

        for (int i=0;i<n-1;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            roads[x][y]=1;
            roads[y][x]=1;
        }

        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                for (int k=1;k<=n;k++){

                    if (roads[i][k]!=INF && roads[k][j] != INF &&
                            roads[i][k]+roads[k][j] < roads[i][j]
                            ){
                        roads[i][j] = roads[i][k]+roads[k][j];
                    }
                }
            }
        }

        int MinDis= Integer.MAX_VALUE;

        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){

                if (cityLevel[i] == cityLevel[j]){

                    int curDistance = roads[i][j];
                    if (MinDis>curDistance){
                        MinDis =  curDistance;
                    }
                }
            }
        }

        System.out.println(MinDis);



    }
}
