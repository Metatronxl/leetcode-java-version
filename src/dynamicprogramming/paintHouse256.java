package dynamicprogramming;

/**
 * @author lei.X
 */
public class paintHouse256 {

    public int minCost(int[][] costs) {

        if (costs == null || costs.length == 0 || costs[0].length <3){
            return 0;
        }

        int[] minCurrentCost = new int[3];
        minCurrentCost[0] = costs[0][0];
        minCurrentCost[1] = costs[0][1];
        minCurrentCost[2] = costs[0][2];

        for(int i=1;i<costs.length;i++){
            int temp0 = minCurrentCost[0];
            int temp1 = minCurrentCost[1];
            int temp2 = minCurrentCost[2];

            minCurrentCost[0] = Math.min(temp1,temp2) +  costs[i][0];
            minCurrentCost[1] = Math.min(temp0,temp2) + costs[i][1];
            minCurrentCost[2] = Math.min(temp0,temp1) + costs[i][2];
        }

        return Math.min(Math.min(minCurrentCost[0],minCurrentCost[1]),minCurrentCost[2]);

    }

}
