package other;

/**
 * @author lei.X
 * @date 2020/4/28
 */
public class TheNthNumber {

    public int findNthDigit(int n) {

        long num = n;
        long size=1;
        long max=9;

        while (n > 0){

            if (num-max*size>0){

                num -= max*size;
                size++;
                max = max*10;
            }else {

                long  count = num/size;  // 跨过多少个数
                long left = num % size; // 是数字的第几位
                if(left == 0){

                    return (int)((Math.pow(10,size-1)+count-1 )%10);

                }else {
                    return (int)((Math.pow(10,size-1)+count)/Math.pow(10,size-left)%10);
                }


            }

        }

        return 0;
    }

}
