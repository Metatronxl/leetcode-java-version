package nowcoder.Alibaba;

import java.util.Scanner;

/**
 * @author lei.X
 * @date 2020/4/21
 * 在ShortestRoad的基础上输出最长的最短路径的路线
 */
public class ShorestRoadPlus {

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
        int[][] preTable = new int[n+1][n+1];
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
            preTable[x][y] = y; // x-y 必须经过y
        }

        for (int i=1;i<=n;i++){  // 得到任意两点的最短路径
            for (int j=1;j<=n;j++){
                for (int k=1;k<=n;k++){
                    if (dist[i][k] != INF && dist[k][j]!= INF && dist[i][j]>(dist[i][k]+dist[k][j])){
                        dist[i][j] = dist[i][k]+dist[k][j];
                        preTable[i][j] = preTable[i][k]; // 更新必须经过的节点
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

        for (int i=1;i<=n;i++){
            int distance = dist[i][l]+dist[l][i];
            if (distance == maxRes){

                printRoad(preTable,i,l);

            }
        }



        System.out.println("Result:"+maxRes);

    }

    private static void printRoad(int[][] preRoad, int i, int l) {

        System.out.print(i);
        int k = preRoad[i][l];
        while (k !=l){
            System.out.print("->"+k);
            k = preRoad[k][l];
        }
        System.out.print("->"+l);
        int t = preRoad[l][i];
        while (t != i){
            System.out.print("->"+t);
            t = preRoad[t][i];
        }
        System.out.println("->"+i);

    }
}
