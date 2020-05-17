package nowcoder.Alibaba;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author lei.X
 * @date 2020/4/21
 */
public class dijkstra {

        public static int[]  dijkstra(int point){

            Scanner scanner = new Scanner(System.in);

            int numOfVexs= scanner.nextInt();  // 顶点的个数

            int[] distance = new int[numOfVexs];  // 存放源点到其他点的距离
            boolean[] st = new boolean[numOfVexs]; // 判断是否已经访问
            int[][] edges = new int[numOfVexs][numOfVexs];

            int edgeCount = scanner.nextInt();  // 边的数量
            for (int i=0;i<edgeCount;i++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int value = scanner.nextInt();
                edges[start][end] = value;
            }

            for (int i=0;i<numOfVexs;i++){
                for (int j=0;j<numOfVexs;j++){
                    if (edges[i][j]==0){
                        edges[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for (int i=0;i<numOfVexs;i++){  // 记录初始情况
                distance[i] = edges[point][i];
            }
            st[point] = true;

            for (int i=0;i<numOfVexs;i++){

                int min = Integer.MAX_VALUE;
                int idx = -1;
                for (int j=0;j<numOfVexs;j++){  // 寻找当前最短点
                    if (st[j]==false){
                        if (distance[j] < min){
                            min = distance[j];
                            idx = j;
                        }
                    }
                }
                if (idx != -1){
                    st[idx] = true;
                }

                for (int j=0;j<numOfVexs;j++){ // 更新距离向量

                    if (edges[point][idx]+edges[idx][j] < distance[j]){
                        distance[j] = edges[point][idx]+edges[idx][j];
                    }
                }

            }

            return distance;

        }

}
