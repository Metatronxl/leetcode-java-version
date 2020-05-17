package swordOfOffer;

/**
 * @author lei.X
 * @date 2020/3/2
 */
public class QuickSort {

    public static void quickSort(int[] nums,int left, int right){

        if (left > right){
            return;
        }

        int i=left;
        int j=right;
        int key = nums[left];

        while (i<j){
            while (i<j && nums[j] > key){
                j--;
            }
            nums[i]=nums[j];
            while (i<j && nums[i]<key){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;

        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }


    public static void merge(int[] nums,int start,int mid,int end){

        int[] tmp = new int[nums.length];
        int p1=start,p2=mid+1,k=start;
        while (p1<=mid && p2<=end){
            if (nums[p1]<nums[p2]){
                tmp[k++] = nums[p1];
            }else {
                tmp[k++] = nums[p2];
            }
        }

        while (p1<=mid) tmp[k++] = nums[p1++];
        while (p2<=end) tmp[k++] = nums[p2++];

        for (int i=0;i<nums.length;i++){
            nums[i] = tmp[i];
        }
    }


    public static void mergeSort(int[] nums, int start, int end){
        if (start<end){

            int mid = (start+end)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);

        }
    }








}
