package swordOfOffer;

import java.io.IOException;
import java.util.UnknownFormatConversionException;

/**
 * @author lei.X
 * @date 2020/3/2
 */
public class FindMinNumRotatoArray {


    private static int res = Integer.MIN_VALUE;

    public  static int findMinNumInRotatoArray(int[] array){

        // array invalid
        if (array == null || array.length == 0){
            return -1;
        }
        // no rotato
        if (array[0] < array[array.length-1] || array.length == 1){
            return array[0];
        }

        int left = 0;
        int right = array.length-1;

        while (left< right){

            int mid = (left+right)/2;
            if (array[mid]<array[mid+1]){
                return array[mid];
            }
            if (array[mid-1]<array[mid]){
                return array[mid-1];
            }

            if ( array[mid] > array[left]){
                left = mid+1;
            }else {
                right = mid-1;
            }

        }

        return -1;
    }


}
