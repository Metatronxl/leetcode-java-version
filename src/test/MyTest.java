package test;

/**
 * @author lei.X
 * @date 2020/2/3
 */
public class MyTest {


    public static void main(String[] args) {

//        int[] arr = new int[]{16,7,3,20,17,8};
//        heapSort(arr);

        method(null);

    }


    public static void method(String param) {

        switch (param) { // 肯定不是进入这里

         case "sth":

            System.out.println("it's sth");
            break; // 也不是进入这里
         case "null":
             System.out.println("it's null");
             break; // 也不是进入这里
         default:
             System.out.println("default");

        }

    }

    private static void heapSort(int[] arr) {

        for (int i=(arr.length-1)/2;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }

        for (int i=arr.length-1;i>0;i--){

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            adjustHeap(arr,0,i);
        }

    }

    private static void adjustHeap(int[] arr, int parent, int length) {

        int temp = arr[parent];
        int lchild = 2*parent+1;

        while (lchild < length){
            int rchild = lchild+1;
            if (rchild< length &&  arr[lchild] < arr[rchild]){
                lchild++;
            }

            if (temp > arr[lchild]){
                break;
            }
            arr[parent] = arr[lchild];

            parent = lchild;
            lchild = 2*lchild+1;
        }
        arr[parent] = temp;

    }



}

