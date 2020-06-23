package ProgrammerSkills;

import java.util.Arrays;

public class Question8_13 {

    public int pileBox(int[][] box) {
        int len = box.length;
        Arrays.sort(box,(a,b)-> a[2]-b[2]); // 只需要对一个维度上的数据进行排序即可
        int[] dp = new int[len];
        int ans = 0;

        for (int i=0;i<len;i++){
            int max = box[0][2];
            for (int j=0;j<i;j++){
                // 设置判断条件
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1]
                     && box[i][2] > box[j][2]){
                    max = Math.max(dp[j]+box[i][2],max); // 获取在i上能够达到的最大值
                }
            }
            dp[i] = max;
            ans = Math.max(dp[i],ans);
        }

        return ans;
    }
}
