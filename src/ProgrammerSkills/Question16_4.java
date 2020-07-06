package ProgrammerSkills;

import java.util.Arrays;

public class Question16_4 {

    public String tictactoe(String[] board) {

        int len  = board.length;
        boolean emptyFlag = false;
        StringBuilder x = new StringBuilder();
        for (int i=0;i<len;i++){
            x.append("X");
        }
        String xStr = x.toString();
        StringBuilder y = new StringBuilder();
        for (int i=0;i<len;i++){
            y.append("O");
        }
        String yStr = y.toString();

        char[][] chessBoard = new char[len][len];
        for (int i=0;i<len;i++){
            chessBoard[i] = board[i].toCharArray();
        }

        for (int i=0;i<len;i++){
            String row = arrayToString(chessBoard[i]);
            if (row.equals(xStr)){
                return "X";
            }else if (row.equals(yStr)){
                return "O";
            }

            StringBuilder sb = new StringBuilder();
            for (int j=0;j<len;j++){
                sb.append(chessBoard[j][i]);
                if (chessBoard[j][i] == ' '){
                    emptyFlag = true;
                }
            }
            String col = sb.toString();
            if (col.equals(xStr)){
                return "X";
            }else if (col.equals(yStr)){
                return "O";
            }



        }

        // 计算对角
        StringBuilder unique = new StringBuilder();
        for (int i=0;i<len;i++){
            unique.append(chessBoard[i][i]);
        }
        String uniqueSb = unique.toString();
        if (uniqueSb.equals(xStr)){
            return "X";
        }else if (uniqueSb.equals(yStr)){
            return "O";
        }

        unique = new StringBuilder();
        for (int i=0;i<len;i++){
            unique.append(chessBoard[len-i-1][i]);
        }
        uniqueSb = unique.toString();
        if (uniqueSb.equals(xStr)){
            return "X";
        }else if (uniqueSb.equals(yStr)){
            return "O";
        }

        if (emptyFlag == true){
            return "Pending";
        }else {
            return "Draw";
        }
    }

    private String arrayToString(char[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Question16_4 question16_4 = new Question16_4();
        String[] board = new String[]{"XO "," XO","X O"};
        System.out.println(question16_4.tictactoe(board));
    }
}
