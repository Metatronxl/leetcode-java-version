package BackTrackAndRecursive;

/**
 * @author lei.X
 * @date 2019/12/25
 *
 * 使用一个temp值来判断，指针指到当前数的时候获得的最大利润为subProfit，如果利润降低了，就表明
 * 应该在上一个数(subProfit值保存)时卖掉，不然就继续向后遍历
 *
 * 当数组执行到最后一个数的时候，直接将其获得的利润加上
 */
public class maxProfit122 {

    public int maxProfit(int[] prices) {

        int size = prices.length;
//        不合规数组判断
        if (size == 0) return 0;
        int profit = 0;
        int buy = prices[0];
        int subProfit = 0;
        for (int i = 1; i < size; i++) {
            int temp = prices[i] - buy;
            if (temp >= subProfit){
                subProfit = temp;
                if (i== size-1){  //当数组已经执行到最后一个数的时候，直接将其获得的利润加上
                    profit += subProfit;
                }
            }else{
                profit += subProfit;
                buy = prices[i];
                subProfit=0;
            }
        }

        return profit;
    }


    public static void main(String[] args) {

        int[] prices = new int[]{1,2,3,4,5};
        maxProfit122 test = new maxProfit122();
        System.out.println(test.maxProfit(prices));
    }

}
