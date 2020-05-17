package dynamicprogramming;

import jdk.nashorn.internal.ir.IfNode;

import java.util.*;

/**
 * @author lei.X
 * @date 2020/3/13
 */
public class SolveCoinChange {


    public static void main(String[] args) {


        int[] coins = new int[]{2,3,5};

        int res = new SolveCoinChange().coinChange(coins,11);
        System.out.println(res);

    }


    // coins 中是可选硬币面值，amount 是目标金额
    // 使用数组进行递归,思想类似于一维背包问题
    int coinChange(int[] coins, int amount){

        if (coins== null || coins.length == 0 || amount <=0){
            return -1;
        }

        int[] record = new int[amount+1];
        for (int i=1;i<amount+1;i++){
            record[i] = amount+1;
        }
        for (int i=0;i<coins.length;i++){
            record[coins[i]]=1;
        }
        record[0] = 0;


        int res = helper(record,coins,amount);
        return res;
    }

    private int helper(int[] record,int[] coins, int amount){

        if (record[amount] != amount+1){
            return record[amount];
        }

        int res = amount+1;

        for (int i=0;i<coins.length;i++){
            if (amount-coins[i]>=0){
                res = Math.min(res,helper(record,coins,amount-coins[i]));
            }
        }

        if (res != amount+1){
            record[amount] = res;
        }
        return record[amount];

    }





}
