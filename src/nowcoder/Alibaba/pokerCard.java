package nowcoder.Alibaba;

/**
 * @author lei.X
 * @date 2020/4/20
 * 今天小强从一副扑克牌里拿出来一叠,其中包括A,2,3,…,10各四张,其中A代表1.他从这一叠中抽出一些牌给小明,并告诉小明每次可以按照下列方式打出一些牌:

    单牌:一张牌,例如3
    对子:数字相同的两张牌,例如77
    顺子:数字连续的五张牌,例如A2345
    三对:连续三个对子:例如334455
    现在小强想知道最少打出多少次牌可以打光手中的牌.

 */
public class pokerCard {


    public static boolean check(int[] nums){

        boolean flag = false;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                flag = true;
                return flag;
            }
        }

        return false;

    }

    public static int min = Integer.MAX_VALUE;

    public static void dfs(int[] nums, int count){

        if (count > min){ // 减枝
            return;
        }

        if (check(nums)){

            int i=0;
            while (nums[i]==0){  // 已经置为0的不用管
                i++;
            }

            //打单牌
            if (nums[i]>0){

                nums[i] -=1;
                dfs(nums,count+1);
                nums[i] +=1;
            }

            // 打对子
            if (nums[i]>1){
                nums[i] -=2;
                dfs(nums,count+1);
                nums[i] +=2;
            }

            // 打同花
            if (i+5<=nums.length && nums[i]>0 && nums[i+1]>0 && nums[i+2]>0 && nums[i+3]>0 && nums[i+4]>0){

                for (int j=0;j<5;j++){
                    nums[i+j] -=1;
                }

                dfs(nums,count+1);
                for (int j=0;j<5;j++){
                    nums[i+j]+=1;
                }
            }

            // 三双
            if (i+3<=nums.length && nums[i]>1 && nums[i+1]>1 && nums[i+2]>1){

                for (int j=0;j<3;j++){
                    nums[i+j]-=2;
                }
                dfs(nums,count+1);
                for (int j=0;j<3;j++){
                    nums[i+j]+=2;
                }
            }

        }else {
            if (min > count){
                min = count;
            }
        }

    }



    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1,2,2,2,2,2,1,1};
        dfs(nums,0);
        System.out.println(min);
    }
}
