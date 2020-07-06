package ProgrammerSkills;

public class Question16_16 {

    public int[] subSort(int[] array) {

        if (array == null || array.length == 0) return new int[]{-1,-1};
        int len = array.length;
        int first=-1,last=-1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i=0;i<len;i++){

            if (array[i] < max){  // 只要array[i]不属于数组前半段的递增区间，那它一定是中间的混乱部分
                last=i;
            }else {
                max = Math.max(max,array[i]);
            }

            if (array[len-i-1] > min){  // array[len-i-1]不属于后半段的递增区间，即它一定是中间的混乱部分
                first = len-i-1;
            }else {
                min  = Math.min(min,array[len-i-1]);
            }

        }
        return new int[]{first,last};
    }

    /**
     * 思路2
     * 从左往右遍历，遇到“右边的数”比“左边的数”小的时候，则停止，这样，就找到了左起有序数中最大的数，，位置记为m;
     * 同理，从右往左再遍历，遇到“左边的数”比“右边的数”大，则停止，这样的话，就找到右起有序数中最小的数，位置记为n;
     *
     * 将【m...n】看作一个【窗口】，接下来我们需要调整这个窗口的大小，调整策略如下：
     *
     * 如果窗口中，出现比m前一个数字小的数字，需要把窗口的左边界往左扩大
     * 如果窗口中，出现比n后一个数字大的数字，需要把窗口的右边界往右扩大
     * 循环往复，最后即为最小窗口。
     *
     * 作者：yinyinnie
     * 链接：https://leetcode-cn.com/problems/sub-sort-lcci/solution/hao-li-jie-de-jie-fa-zi-ji-si-ke-chu-lai-de-shi-ji/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param arr
     * @return
     */
    public int[] subSort2(int[] arr) {
            if (arr == null || arr.length < 2) return new int[] {-1, -1};
            int len = arr.length;

            int i = 0; // find the max from left.
            while (i < len - 1 && arr[i] <= arr[i+1]){
                ++i;
            }

            int j = len - 1; // find the min from right
            while (j > 0 && arr[j] >= arr[j-1]) {
                j--;
            }

            if (j < i) return new int[] {-1, -1};

            int m = i;
            int n = j;

            // ajust the m and n
            for (int k = i; k <= j; ++k) {
                while (m > 0 && arr[k] < arr[m - 1]) {
                    m--;
                }

                while (n < len - 1 && arr[k] > arr[n + 1]) {
                    n++;
                }
            }
            return new int[] {m, n};
        }

}
