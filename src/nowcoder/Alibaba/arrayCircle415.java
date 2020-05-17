package nowcoder.Alibaba;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author lei.X
 * @date 2020/4/22
1. 考虑整数a和数组b，这里a代表数组长度，b的元素皆是整数。想象这a个元素坐成圆桌，如何安排入座顺序，使得相邻差的绝对值的和最大？
我自己理解是，考虑[1,2,4,5]，相邻差的绝对值的和是 |1 - 2| + |2 - 4| + |4 - 5| + |5 - 1|，最后一项是因为圆桌上第0个元素 1 和最后一个元素 5 相邻。
输出第一行：所求的最大值  ；      第二行：对应的排列顺序
输入：
3
1 2 3
输出
4
1 2 3
 *
 *
 */
public class arrayCircle415 {


    public static int  res = Integer.MIN_VALUE;
    public static int[] location;
    public static int[] finalLocation;

    /**
     *
     * @param array  数组
     * @param judge  元素是否已经被使用
     * @param count  数组的长度
     * @param idx    已经使用了几个数字
     * @param maxValue   目前得到的最大值
     * @param lastNum   前一轮递归使用的数字
     */
    private static void helper(int[] array, boolean[] judge,int[] location,int count,int idx,int maxValue,int lastNum){

        if (count == idx ){   // 递归到了最后一步
            maxValue += Math.abs(lastNum-array[1]);
            if (res < maxValue){
                res = maxValue;
                // 复制排列
                for (int i=1;i<=count;i++){
                    finalLocation[i] = location[i];
                }

                return;

            }
        }

        for (int i=2;i<array.length;i++){

            if (judge[i] == false){  // 还没有使用

                int curNum = array[i];
                int preNum = array[location[idx]];  // 前一个数的大小
                int absNum = Math.abs(curNum-preNum);
                maxValue += absNum;
                judge[i] = true;

                location[idx+1] = i;
                helper(array,judge,location,count,idx+1,maxValue,curNum);
                judge[i] = false;
                maxValue-=absNum;
            }
        }

    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] array = new int[a+1];
        for (int i=1;i<=a;i++){
            array[i] = scanner.nextInt();
        }

        boolean[] judge = new boolean[a+1];
        location = new int[a+1];
        finalLocation = new int[a+1];
        location[1] = 1;
        judge[1] = true;

        helper(array,judge,location,array.length-1,1,0,array[1]);

        System.out.println(res);
        for (int i=1;i<=a;i++){
            System.out.print(array[finalLocation[i]]+" ");

        }

        System.out.println();
    }
}
