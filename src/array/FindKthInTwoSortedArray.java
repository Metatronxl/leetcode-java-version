package array;

import java.util.Arrays;

public class FindKthInTwoSortedArray {

    public int FindKthInTwoSortedArray(int[] array1, int[] array2,int k){

        int len1 = array1.length;
        int len2 = array2.length;

        return helper(array1,array2,len1,len2,k);
    }

    private int helper(int[] array1,int[] array2,int len1,int len2,int k){

        if (len1 > len2){
            return helper(array2,array1,len2,len1,k);
        }
        if (len1==0){
            return array2[k-1];
        }

        if( k == 1){
            return (Math.min(array1[0], array2[0]));
        }

        int num1 = Math.min(len1, k / 2);
        int num2 = k-num1;

        if (array1[num1-1] == array2[num2-1]){
            return array1[num1-1];
        }else if (array1[num1-1] > array2[num2-1]){
            int[] temp = Arrays.copyOfRange(array2, num2, array2.length);
            return helper(array1,temp,len1,len2-num2,k-num2);
        }else {
            int[] temp = Arrays.copyOfRange(array1,num1,array1.length);
            return helper(temp,array2,len1-num1,len2,k-num1);
        }


    }

    public static void main(String[] args) {
        int[] array1 = new int[]{0,1,2,3,4,5,6,7,8,9,17};
        int[] array2 = new int[]{3,4,5,6,7,8,9,10,11,12,29};

        FindKthInTwoSortedArray findKthInTwoSortedArray = new FindKthInTwoSortedArray();
        for (int i=1;i<=22;i++){
            int res = findKthInTwoSortedArray.FindKthInTwoSortedArray(array1, array2, i);
            System.out.println(res);
        }
    }

}
