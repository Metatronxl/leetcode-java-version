package ProgrammerSkills;

public class Question5_4 {

    public int[] findClosedNumbers(int num)
    {
        int[] a=new int[]{-1,-1};
        int b1=Integer.bitCount(num);
        if(num==Integer.MAX_VALUE)return a;
        for(int i=num+1;i<Integer.MAX_VALUE;i++)
        {

            if(Integer.bitCount(i)==b1){a[0]=i;break;}
        }
        for(int i=num-1;i>=1;i--)
        {
            if(Integer.bitCount(i)==b1){a[1]=i;break;}
        }

        return a;
    }
}
