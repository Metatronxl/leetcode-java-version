package array;

import java.util.Arrays;

/**
 * @author lei.X
 * @date 2019/12/11
 */
public class Hindex275 {

    public int hIndex(int[] citations) {

        int len = citations.length;
        int factor=0;
        for (int i=len-1;i>=0;i--){

            if (citations[i]>factor){
                factor++;
            }
        }

        return factor;
    }
}
