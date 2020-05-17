package dynamicprogramming;

/**
 * @author lei.X
 * @date 2020/3/14
 */
public class MaxSubList {

    /**
     * 时间复杂度为O(nLogN)
     * @param arr
     * @return
     */
    public static int getMaxSubList(int[] arr){

        int len = arr.length;
        // 记录到i的时候的最大递增长度
        int[] record = new int[len];
        record[0] = arr[0];
        int count=1;
        for(int i=1;i<len;i++){

            if (arr[i] > record[count-1]){
                record[count]=arr[i];
                count++;
            }else {  // 找到record中第一个比arr[i]大的数，并替换

                replaceNum(record,count-1,arr[i]);
            }
        }

        return count;

    }
    // 替换第一个比num大的数
    private static void replaceNum(int[] arr ,int right,int num){

        int left=0,mid;
        while (left <=right){

            mid = (left+right)/2;
            if (arr[mid]<=num){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        arr[left] = num;
    }



    public static void main(String[] args) {

        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        int maxSubList = getMaxSubList(arr);
        System.out.println(maxSubList);
    }
}
