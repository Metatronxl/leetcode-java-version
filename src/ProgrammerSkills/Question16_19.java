package ProgrammerSkills;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Question16_19 {


    public boolean[][] visited;

    public int[] pondSizes(int[][] land) {
        if (land == null || land.length ==0 || land[0].length == 0) return null;
        int row = land.length;
        int col = land[0].length;
        visited = new boolean[row][col];

        List<Integer> res = new LinkedList<>();
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                int temp = getPoolSize(land,i,j);
                if (temp !=0){
                    res.add(temp);
                }
            }
        }

        Collections.sort(res);
        int[] ans = new int[res.size()];
        for (int i=0;i<ans.length;i++){
            ans[i] = res.get(i);
        }

        return ans;
    }

    private int getPoolSize(int[][] land,int x,int y){

        if (x<0 || x > land.length-1 || y<0 || y > land[0].length-1){  // 越界
            return 0;
        }

        if (land[x][y] == 0 && visited[x][y] ==false){
            visited[x][y] = true;
            return 1+getPoolSize(land,x+1,y)
                    +getPoolSize(land,x-1,y)
                    +getPoolSize(land,x,y+1)
                    +getPoolSize(land,x,y-1)
                    +getPoolSize(land,x-1,y-1)
                    +getPoolSize(land,x-1,y+1)
                    +getPoolSize(land,x+1,y+1)
                    +getPoolSize(land,x+1,y-1);
        }

        return 0;
    }


    public static void main(String[] args) {

        Question16_19 question16_19 = new Question16_19();
        int[][] nums = new int[][]{
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        System.out.println(question16_19.pondSizes(nums));
    }
}
