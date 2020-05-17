package swordOfOffer;

/**
 * @author lei.X
 * @date 2020/2/17
 */
public class Q4 {


    public boolean judge = false;


    public boolean findNumer(int[][] nums, int num){

        int height = nums.length;
        int width = nums[0].length;

        int idx = 0;

        // 是否已经遍历到
        boolean[][] flags = new boolean[height][width];
        recuriveFunc(nums,flags,num,0,0);

        return judge;

    }

    /**
     * 递归查询数字，并且用flag来进行减枝操作
     * @param nums
     * @param flags
     * @param num
     * @param i
     * @param j
     */
    private void recuriveFunc(int[][] nums, boolean[][] flags, int num,int i,int j){

        if (flags[i][j] == true) return;
        if (nums[i][j] == num){
            judge = true;
            return;
        }

        if (nums[i][j] > num){
            flags[i][j] = true;
            return;
        }

        if (nums[i][j] < num){
            flags[i][j] = true;
            recuriveFunc(nums,flags,num,i+1,j);
            recuriveFunc(nums,flags,num,i,j+1);
            return;
        }
    }


    /**
     * 方法2：
     *
     * 从右上角or左下角开始递归查找，如果数字比number大，则去除一列，如果比number小，则向下一行
     * 直到找到对应的数
     * @param nums
     * @param number
     * @return
     */
    public boolean findNum(int[][] nums, int number){

        int height = nums.length;
        int width = nums[0].length;

        int row = height-1;
        int col = width-1;
        int rowIdx = 0;
        int colIdx = col;

        while (rowIdx < row && colIdx >= 0 ){

            if (nums[rowIdx][colIdx] == number){
                return true;
            }else if (nums[rowIdx][colIdx] > number){
                colIdx --;
            }else {
                rowIdx ++;
            }
        }
        return false;
    }

}
