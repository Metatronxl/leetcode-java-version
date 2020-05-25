package ProgrammerSkills;

public class Question5_1 {

    public int insertBits(int N, int M, int i, int j) {
        // 保留低位的值
        int l = N & (1 << i)-1;
        // 保留高位的值
        int h = N >> j >> 1 << j <<1;
        // 获取中间的值
        int m = M << i;

        return l | h | m;

    }

    // func 2
    public int insertBits2(int N, int M, int i, int j) {
        // 将N的第i位到j位全部置为0
        for (int distance=i;distance<=j;distance++){
            N = N & Integer.rotateLeft(~1,distance);
        }
        M <<= i;

        return N | M;

    }

    public static void main(String[] args) {


    }

}
