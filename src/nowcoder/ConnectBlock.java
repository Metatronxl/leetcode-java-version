package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.X
 * @date 2020/4/19
 *
 * 有n个房间，房间之间有通道相连，一共有n-1个通道，每两个房间之间都可以通过通道互相到达。
    第i个房间有x_i个金币。
    现在牛牛想通过封闭一些通道来把n个房间划分成k个互相不连通的区域，他希望这k个区域内部的金币数目和都大于等于m，你需要告诉他这是否可行。

    https://www.nowcoder.com/practice/5b2ed1c316fc42a0b974ff2b264fa922?tpId=110&tqId=33493&tPage=1&rp=1&ru=/ta/job-code&qru=/ta/job-code/question-ranking
 *
 */
class Node{

    int nodes;
    int sum;

    public Node(int nodes,int sum){
        this.nodes= nodes;
        this.sum = sum;
    }
}



public class ConnectBlock {



    static ArrayList<Integer>[] a;
    /**
     *
     * @param n  房间数量
     * @param k  需要切割多少块
     * @param m  分割区域的金币数量
     * @param u
     * @param v
     * @param x  每个房间的金币数
     * @return
     */
    static boolean solve(int n,int k,int m,int[] u,int[] v,int[] x){

        a = new ArrayList[n+1];
        for (int i=1;i<=n;i++){
            a[i] = new ArrayList<>();
        }

        for (int i=0;i<u.length;i++){
            a[u[i]].add(v[i]);
            a[v[i]].add(u[i]);
        }

        Node node = dfs(1,0,m,x);

        if (node.nodes >= k){
            return true;
        }

        return false;

    }

    static   Node dfs(int cur, int pre, int m, int[] x) {

        Node now = new Node(0,x[cur-1]);

        for (int next:a[cur]){

            if (next!=pre){  // 防止重复迭代
                Node nex = dfs(next,cur,m,x);
                now.nodes += nex.nodes;   // 当前node 添加所有子node可能拥有的独立分割的数量
                now.sum += nex.sum;   // 当前node 添加所有子node的大小
            }
        }

        if (now.sum >= m){  // 如果当前node和子node的值已经大于m，则node+1，但sum清为0，用于继续递归
            now.nodes++;
            now.sum=0;
        }

        return now;
    }

}
