package array;

/**
 * @author lei.X
 * @date 2019/12/4
 * 使用贪心策略
 */
public class CanCompleteCircuit134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int idx = -1;
        int result = 0;
        int sum = 0;

        for (int i=0;i<gas.length;i++){
            result += gas[i] - cost[i];
            if (sum > 0){
                sum += gas[i] - cost[i];
            }else {
                sum = gas[i] - cost[i];
                idx = i;
            }
        }

        return result>=0 ? idx : -1;
    }
}
