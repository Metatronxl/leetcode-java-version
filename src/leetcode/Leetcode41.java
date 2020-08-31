package leetcode;

/**
 * Title
 * 给定一个无序整型数组arr，找到数组中未出现的最小正整数。
 * 要求时间复杂度为O(N)空间复杂度为O(1)。
 */
public class Leetcode41 {

    public int getMinNum(int[] arr){

        int n = arr.length;
        for (int i=0;i<n;i++){
            while (arr[i] > 0 && arr[i]<= n && arr[arr[i]-1] != arr[i]){
                int temp = arr[arr[i]-1];
                arr[arr[i]-1 ] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i=0;i<n;i++){
            if (arr[i] != i+1){
                return i+1;
            }
        }

        return n+1;
    }
}
