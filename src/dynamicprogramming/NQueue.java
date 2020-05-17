package dynamicprogramming;

import java.util.Date;

/**
 * @author lei.X
 * @date 2020/3/14
 */
public class NQueue {


    private static final short  N =8;
    private static int count = 0;



    public static void main(String[] args) {

        Date begin = new Date();

        int[][] chessBoard = new int[N][N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                chessBoard[i][j] = 0;
            }
        }

        putQueenAtRow(chessBoard,0);
        Date end =new Date();
        System.out.println("解决 " +N+ " 皇后问题，用时：" +String.valueOf(end.getTime()-begin.getTime())+ "毫秒，计算结果："+count);

    }

    private static void putQueenAtRow(int[][] chessBoard,int row){

        if (row == N){

            count++;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(chessBoard[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }

        int[][] chessTemp = chessBoard.clone();
        for (int i=0;i<N;i++){

            for (int j=0;j<N;j++){
                chessTemp[row][j] = 0;
            }


            chessTemp[row][i] = 1;
            if (isSafety(chessTemp,row,i)){
                putQueenAtRow(chessTemp,row+1);
            }

        }


    }


    private static boolean isSafety(int[][] chessBoard, int row ,int col){
        int step=1;
        while (step <= row){

            if (chessBoard[row-step][col] == 1){
                return false;
            }

            if (col-step>=0 && chessBoard[row-step][col-step]==1){
                return false;
            }

            if (chessBoard[row-step][col+step]== 1 && col+step<N){
                return false;
            }
            step++;
        }

        return true;

    }
}
