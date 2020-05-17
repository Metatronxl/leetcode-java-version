package nowcoder.Alibaba;

import java.util.Scanner;

/**
 * @author lei.X
 * @date 2020/4/20
 *

    n个城市n个人，每个城市一个人，选择一个城市x，所有人去那聚会，聚合结束所有人返回各自城市。
    有m条单向路径，保证每个人可以到达城市x，一个人所消耗时间为往返距离和，且每个人都会选择最短路径，问最长的距离是多少。
    第一行 输入 n,m,l 对应城市、路径、聚会城市
    接下来m行，x,y,z从城市x到城市y的距离为z
    输出
    输出最长距离
 *
 */
public class ShortestRoad {


    class EData{

        int start;
        int end;
        int value;

        public EData(int start,int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }


    public static void main(String[] args) {

        int n,m,l;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        l = scanner.nextInt();

        int INF = Integer.MAX_VALUE;
        int[][] dist = new int[n+1][n+1];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                dist[i][j] = INF;
            }
        }


        for (int i=0;i<m;i++){

                int x,y,z;
                x = scanner.nextInt();
                y = scanner.nextInt();
                z = scanner.nextInt();
                dist[x][y] = z;   // 构建初始距离
        }

        for (int i=1;i<=n;i++){  // 得到任意两点的最短路径
            for (int j=1;j<=n;j++){
                for (int k=1;k<=n;k++){
                    if (dist[i][k] != INF && dist[k][j]!= INF && dist[i][j]>(dist[i][k]+dist[k][j])){
                        dist[i][j] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }


        int maxRes = Integer.MIN_VALUE;
        for (int i=1;i<=n;i++) {
            int distance = dist[i][l]+dist[l][i];
            if (distance > maxRes){
                maxRes = distance;
            }
        }

        System.out.println(maxRes);

    }
}
