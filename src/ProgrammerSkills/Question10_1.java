package ProgrammerSkills;

/**
 * 从后往前插入数据
 */
public class Question10_1 {

    public void merge(int[] A, int m, int[] B, int n) {

        int i = m-1,j=n-1;
        while (i>=0 && j>=0){
            if (B[j] >= A[i]){
                A[i+j+1] = B[j--];
            }else {
                A[i+j+1] = A[i--];
            }
        }
        while (j>=0){
            A[j] = B[j--];
        }
    }
}
