package ProgrammerSkills;

public class Question10_9 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int row = matrix.length;
        if (row == 0 ) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        for (int i=0;i<row;i++){
            if (matrix[i][col-1]<target){
                continue;
            }else {
                for (int j=0;j<col;j++){
                    if (matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 由题得到，从左下角或者右上角，对角线上的数都是中位数，所以我们可以从左下角或者右上角走
     * 我以左下角为例，matrix[x][y]
     * 如果大于target，就y++；
     * 如果小于target，就x--;
     * 如果等于返回true;
     * 以上方法在循环中执行，而边界就是，如果找不到target，你最终一定会走出矩阵的边界，那么这个条件就是循环判断的边界
     * 注：y++和x--之后都要跟continue来避免后面不必要执行的代码影响结果
     *
     * 作者：wo-yao-bian-hao-kan
     * 链接：https://leetcode-cn.com/problems/sorted-matrix-search-lcci/solution/lei-si-er-fen-cha-zhao-bi-jiao-xiang-zou-lu-mei-ge/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     * @param target
     * @return
     */
        public boolean searchMatrix2(int[][] matrix, int target) {
            int x = matrix.length-1;
            int y = 0;
            while(x>=0 && x<=matrix.length-1 && y>=0 && y<=matrix[0].length-1){
                if(target > matrix[x][y]){
                    y++;
                    continue;
                }
                if(target < matrix[x][y]){
                    x--;
                    continue;
                }
                if(target == matrix[x][y]){
                    return true;
                }
            }
            return false;
        }



    public static void main(String[] args) {

        Question10_9 question10_9 = new Question10_9();
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(question10_9.searchMatrix(matrix,24));
    }
}
