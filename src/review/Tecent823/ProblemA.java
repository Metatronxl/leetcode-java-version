package review.Tecent823;

public class ProblemA {



    private static void  quickSort(int[] array){

        int len;
        if (array == null || (len= array.length)==0 || len==1){
            return;
        }

        helper(array,0,len-1);

    }

    private static void helper(int[] array,int left, int right){

        if (left > right){
            return;
        }

        int start=left,end=right;
        int base = array[left];

        while (start < end){

            while ( start<end &&  array[end] >= base)
                end--;
            while (start<end && array[start]<= base)
                start++;

            if (start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        array[left] = array[start];
        array[start] = base;


    }
}
