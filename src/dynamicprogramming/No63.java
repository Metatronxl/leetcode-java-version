package dynamicprogramming;

/**
 * @author lei.X
 * @date 2019/6/25
 */
public class No63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        int[][] pathArray  = new int[height][width];

        if (obstacleGrid[0][0] == 1){
            pathArray[0][0] = 0;
        }else{
            pathArray[0][0] = 1;
        }

        for (int i=1;i<height;i++){
            if (pathArray[i-1][0] != 0 && obstacleGrid[i][0] !=1){
                pathArray[i][0] = 1;
            }else {
                pathArray[i][0] = 0;
            }
        }


        for(int j=1;j<width;j++){
            if (pathArray[0][j-1] !=0 && obstacleGrid[0][j] != 1){
                pathArray[0][j] = 1;
            }else {
                pathArray[0][j] = 0;
            }
        }

        for(int i=1;i<height;i++){
            for(int j=1;j<width;j++){
                if (obstacleGrid[i][j] ==1){
                    pathArray[i][j] = 0;
                }else {
                    pathArray[i][j] = pathArray[i-1][j] + pathArray[i][j-1];
                }
            }
        }

        return pathArray[height-1][width-1];
    }
    

}



