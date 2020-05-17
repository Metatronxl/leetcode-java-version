package nowcoder.Alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lei.X
 * @date 2020/4/23
作者：Llittlefu
链接：https://www.nowcoder.com/discuss/409029
来源：牛客网

n个人，每个人有一个特征值a，给n个人安排座位，最大化邻座两个人之间的特征值差异程度之和。
输入：
第一行一个正整数n，带表总人数
第二行包含n个正整数，第i个正整数ai表示第i个人的特征值
注意:邻座的定义是第i人(1<i<n)的邻座是i-1,i+1; 第1人的邻座是2,n; 第n人的邻座是1,n-1。邻座i,j差异值是|ai-aj|,取绝对值。每对邻座差异值只算一次。
输出
第一行：最大差异值
第二行：输出用空格隔开的n个数，满足差异值最大化，重新排列过的特征值。（如果有多组，输出一组即可）
 */
public class ali4151 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int[] resArr = new int[n];

        Arrays.sort(arr);
        long res=0;
        int left=0;
        int right=n-1;
        int idx=0;
        while (left<right){
            res += arr[right]-arr[left];
            resArr[idx]=arr[left];
            idx++;
            resArr[idx]=arr[right];
            idx++;

            left+=1;
            right-=1;
        }
        if (left==right){
            res+= arr[left]-arr[0];
            resArr[idx]=arr[left];
        }

        System.out.println(res);
        for (int i=0;i<resArr.length;i++){
            System.out.print(resArr[i]);
        }



    }
}
