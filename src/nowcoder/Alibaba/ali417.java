package nowcoder.Alibaba;

/**
 * @author lei.X
 * @date 2020/4/22
 *
 *
 *构造一个长度为n的排列，使得对于任意的1<=i<j<k<=n，不存在ai+ak=2*aj。
 */
public class ali417 {



    public static void solve(int l, int r,int mark,int[] array){

        if (l==r){
            if (mark==1) array[l]=1;
            else array[l]=2;
            return;
        }

        int mid = (l+r)>>1;
        solve(l,mid,1,array);
        solve(mid+1,r,0,array);

        for (int i=l;i<=r;i++){
            array[i] = array[i]*2-mark;
        }

        return;
    }



    public static void main(String[] args) {

        int N=12;
        int[] array = new int[N+1];
        solve(1,N,0,array);

        for (int i=1;i<=N;i++){
            System.out.println(array[i]/2);
        }

        return;
    }
}
