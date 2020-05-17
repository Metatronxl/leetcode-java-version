package nowcoder.Alibaba;

import java.util.*;

/**
 * @author lei.X
 * @date 2020/4/23
作者：Llittlefu
链接：https://www.nowcoder.com/discuss/409029
来源：牛客网

第二题
n个员工，每个员工都有个推理能力值Ai和阅读能力值Bi。要选两个员工i和j去竞赛，他们的平均推理能力是x=(Ai+Aj)/2, 平均推理能力是y=(Bi+Bj)/2。目标是从n个员工中选择两个人，使得min(x,y)尽可能大。请问最大值是多少。
输入：
第一行：正整数n
后面n行对应第i位员工的Ai和Bi。
输出：
一行一个一位小数表示最大值
 */
public class ali4152 {


    static class employer{
        int a;
        int b;
        int idx;


        public employer(int a, int b, int idx){
            this.a = a;
            this.b = b;
            this.idx = idx;
        }

        public employer() {

        }
    }


    private static employer[] copyArray(employer[] array){
        int len = array.length;
        employer[] temp = new employer[len];
        for (int i=0;i<len;i++){
            temp[i] = array[i];
        }

        return temp;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr_a = new int[n];
        int[] arr_b = new int[n];

        employer[] employerList = new employer[n];

        for (int i=0;i<n;i++){
            employer temp = new employer();
            temp.a = scanner.nextInt();
            temp.b = scanner.nextInt();
            temp.idx = i;
            employerList[i] = temp;
        }

        Arrays.sort(employerList, new Comparator<employer>() {
            @Override
            public int compare(employer o1, employer o2) {
               return (int)(o1.a-o2.a);
            }
        });

        employer[] sortByA = copyArray(employerList);

        Arrays.sort(employerList, new Comparator<employer>() {
            @Override
            public int compare(employer o1, employer o2) {
                return (int)(o1.b-o2.b);
            }
        });

        employer[] sortByB = copyArray(employerList);

        int idx_a = 0;
        int idx_b = 0;
        int res = Integer.MAX_VALUE;

        while (idx_a<n && idx_b < n){

            employer a = sortByA[idx_a];
            employer b = sortByB[idx_b];

            if (a.idx == b.idx){  // 取到了同一个数
                idx_a++;
                continue;
            }

            int part1 = a.a+b.a;
            int part2 = a.b + b.b;
            int subMin = Math.min(part1,part2);
            res = Math.max(subMin,res);

            if (part1 > part2){
                idx_b++;
            }else {
                idx_a++;
            }
        }

        System.out.println(res);




//        for (int i=0;i<n;i++){
//            System.out.println(sortByA[i].a+" "+sortByA[i].b+" "+sortByA[i].idx);
//        }
//        for (int i=0;i<n;i++){
//            System.out.println(sortByB[i].a+" "+sortByB[i].b+" "+sortByB[i].idx);
//        }
    }

}
