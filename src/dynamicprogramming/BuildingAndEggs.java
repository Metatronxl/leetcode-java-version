package dynamicprogramming;

/**
 * @author lei.X
 * @date 2020/3/22
 */
public class BuildingAndEggs {

    public static int GetCells(int K,int N){

        int[][] dict = new int[K+1][N+1];
        for (int i=0;i<=K;i++){
            for (int j=0;j<=N;j++){
                dict[i][j] = -1;
            }
        }

        int res = helper(K,N,dict);
        return res;
    }


    private static int helper(int k ,int n, int[][] dict){

        if (dict[k][n] != -1){
            return dict[k][n];
        }

        if (k==1) return n;
        if (n==1) return 1;
        if (n<1 || k<1) return 0;

        int res = Integer.MAX_VALUE;
        for (int i=1;i<=n;i++){

            res = Math.min(res,Math.max(helper(k,n-i,dict),helper(k-1,i-1,dict))+1);
        }
        dict[k][n] = res;
        return res;
    }


    public static void main(String[] args) {

        int cells = GetCells(2, 100);
        System.out.println(cells);

    }
}
