package ProgrammerSkills;

/**
 * @author lei.X
 * @date 2020/5/3
 */
public class Question1_7 {

    public void rotate(int[][] matrix) {

        int len = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 再对每一行以中点进行翻转
        for (int i=0;i<len;i++){
            for (int j=0;j<len/2;j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = temp;

            }
        }
    }
}
