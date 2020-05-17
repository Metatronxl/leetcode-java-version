package nowcoder.Alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lei.X
 * @date 2020/4/22
 * 勇士打怪兽，勇士有一个初始能力值，记为 a ,怪兽有 n 个，每个怪兽有自己的能力值，记为 i 。当 n>=i时，勇士可以打败怪兽，并获得一枚金币。且勇士在任意时刻都可以选择花费一枚金币提升自己1点能力值。
勇士打怪兽的顺序随意，勇士的初始金币为0.

问：
勇士最大可以获得多少金币，怪兽不一定要打完。
————————————————
版权声明：本文为CSDN博主「爱学习的lizi」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_43901370/article/details/105645252
 */
public class WarriorVsMonster {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a,n;
        a = scanner.nextInt();
        n = scanner.nextInt();

        int[] monsters = new int[n+1];

        for (int i=1;i<=n;i++){
            monsters[i] = scanner.nextInt();
        }
        // 能力排序
        Arrays.sort(monsters);

        int idx=1;
        int coin=0;
        int res=0;
        while (idx<=n){

            if (monsters[idx]<=a){
                coin++;
                idx++;
                res = Math.max(res,coin);
            }else {
                if (coin>0){
                    a+=1;
                    coin-=1;
                }else {
                    break;
                }
            }
        }

        System.out.println(res);



        return;
    }
}
