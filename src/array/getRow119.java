package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/12/5
 */
public class getRow119 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre = cur;
        }

        return cur;

    }
}

