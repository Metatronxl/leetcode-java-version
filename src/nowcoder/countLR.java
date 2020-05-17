package nowcoder;

/**
 * @author lei.X
 * @date 2020/4/19
 */
public class countLR {




    public int countLR (int[] a, int[] b) {
        // write code here
        int count = 0;
        int len = a.length;
        for(int i = 0;i<len;i++){
            if(a[i] == 2*b[i]) count++;
        }
        for(int low = 0;low < len-1;low++){
            int x = a[low];
            for(int fast=low+1;fast<len;fast++){
                int y = b[low] + b[fast];
                x += a[fast];
                if(x == y) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        countLR countLR = new countLR();
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[]{2,1,4,5};

        int countLR1 = countLR.countLR(a, b);
        System.out.println(countLR1);

    }
}
