package ProgrammerSkills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question8_2 {

    int width=0;
    int height=0;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {

        LinkedList<List<Integer>> res = new LinkedList<>();
        width = obstacleGrid.length;
        height = obstacleGrid[0].length;
        boolean[][] visited = new boolean[width][height];

        helper(obstacleGrid, res, 0, 0,visited);
        return res;
    }

    private boolean helper(int[][] obstacleGrid, LinkedList<List<Integer>> res, int x, int y, boolean[][] visited) {

        if (x >= width || y >= height || obstacleGrid[x][y] == 1 || visited[x][y]) {  // 不合法
            return false;
        }

        if (x == width - 1 && y == height - 1 && obstacleGrid[x][y]==0 && !visited[x][y]) {
            res.add(Arrays.asList(x,y));
            return true;
        }

        if (x+1< width-1 && y < height && obstacleGrid[x+1][y] == 0 && !visited[x+1][y]){
            visited[x+1][y] = true;
            res.add(Arrays.asList(x,y));
            if (helper(obstacleGrid,res,x+1,y,visited)){
                return true;
            }
            res.removeLast();
        }

        if (x<width-1 && y+1<height && obstacleGrid[x][y+1]==0 && !visited[x][y+1]){
            visited[x][y+1] = true;
            res.add(Arrays.asList(x,y));
            if (helper(obstacleGrid,res,x,y+1,visited)){
                return true;
            }
            res.removeLast();
        }


        return false;
    }


    public static void main(String[] args) {

        Question8_2 question8_2 = new Question8_2();
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        question8_2.pathWithObstacles(obstacleGrid);
    }
}
