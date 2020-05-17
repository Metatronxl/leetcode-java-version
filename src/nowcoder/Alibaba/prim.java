package nowcoder.Alibaba;

/**
 * @author lei.X
 * @date 2020/4/21
 */
public class prim {


    public void primSolve(int num,int[][] weight){

        boolean[] judge= new boolean[num+1];
        judge[1] = true;   // 第一个节点已经被访问

        int[] shortRoad = new int[num+1];   // 每个节点被访问到时的最短长度
        int[] shortPoint = new int[num+1];  // 节点依附在哪个点上来得到最短长度


        for (int i=1;i<=num;i++){  // init
            shortRoad[i] = weight[1][i];
            shortPoint[i] = 1;
        }

        for (int i=2;i<=num;i++){

            int min = Integer.MAX_VALUE;
            int j=1;
            for (int k=2;k<=num;k++){   //找到一个未在集合里的到已知集合的最短路径，并加入这个节点

                if (shortRoad[k] < min && judge[k]==false){
                    min = shortRoad[k];
                    j=k;
                }
            }

            judge[j] = true;
            for (int k=2;k<=num;k++){

                if (judge[k]==false && weight[j][k]<shortRoad[k]){   // 修改未加入节点到已加入节点的距离，
                    shortRoad[k] = weight[j][k];
                    shortPoint[k] = j;  // 更新离他最近的节点
                }
            }

        }



    }
}
