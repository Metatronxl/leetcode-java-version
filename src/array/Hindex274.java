package array;

import java.util.Arrays;

/**
 * @author lei.X
 * @date 2019/12/11
 */
public class Hindex274 {

    public int hIndex(int[] citations) {


        Arrays.sort(citations);
        int len = citations.length;
        int factor=0;
        for (int i=len-1;i>=0;i--){

            if (citations[i]>factor){
                factor++;
            }
        }

        return factor;
    }


    public static void main(String[] args) {
        int[] citations = new int[]{3,0,6,1,5};
        Hindex274 test = new Hindex274();
        System.out.println(test.hIndex(citations));
    }
}
