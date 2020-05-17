package dynamicprogramming;

import java.util.* ;


/**
 * @author lei.X
 * @date 2019/9/10
 */
public class UglyNumber264 {
    /**
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int i = n;
        Queue pq = new PriorityQueue();
        Map<Long, Boolean> m = new HashMap<>();
        int ans = 1;
        pq.add(1L);
        while (!pq.isEmpty() && i > 0){
            long element = (long) pq.poll();
            long e1 = (element * 2);
            long e2 = (element * 3);
            long e3 = (element * 5);
            if (m.getOrDefault(e1,false) == false){
                m.put(e1, true);
                pq.add(e1);
            }
            if (m.getOrDefault(e2,false) == false){
                m.put(e2, true);
                pq.add(e2);
            }
            if (m.getOrDefault(e3,false) == false){
                m.put(e3, true);
                pq.add(e3);
            }
            i--;
            if (i == 0){
                ans = (int)element;
                break;
            }

        }
        return ans;
    }

}

