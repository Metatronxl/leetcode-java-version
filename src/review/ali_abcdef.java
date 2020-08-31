package review;

import java.util.ArrayList;
import java.util.List;

public class ali_abcdef {


    public int getMaxSequence(String str){

        char[] arrs = str.toCharArray();
        int len = str.length();

        int res=0;
        List<Integer> roundA = new ArrayList<>();
        List<Integer> roundB = new ArrayList<>();

        for (int i=0;i<len;i++){
            char temp = arrs[i];
            if (temp=='a' || temp=='c' || temp=='e'){
                roundA.add(temp-'a');
            }else if (temp=='b' || temp=='d' || temp=='f'){
                roundB.add(temp-'a');
            }else {

                res+=1;
            }
        }
        int sizeA = roundA.size();
        if (sizeA > 0){
            int[] dpA = new int[sizeA];
            dpA[0] = 1;
            for(int i=1;i<roundA.size();i++)
            {
                dpA[i]=1;
                for(int j=0;j<i;j++)
                {
                    if(roundA.get(i)>=roundA.get(j))
                    {
                        dpA[i]=Math.max(dpA[i],dpA[j]+1);
                    }
                }
            }

            res += dpA[sizeA-1];
        }

        int sizeB = roundB.size();
        if (sizeB > 0){
            int[] dpB = new int[sizeB];
            dpB[0] = 1;
            for(int i=1;i<roundB.size();i++)
            {
                dpB[i]=1;
                for(int j=0;j<i;j++)
                {
                    if(roundB.get(i)>=roundB.get(j))
                    {
                        dpB[i]=Math.max(dpB[i],dpB[j]+1);
                    }
                }
            }

            res += dpB[sizeB-1];
        }

        return res;

    }

    public static void main(String[] args) {

        ali_abcdef ali_abcdef = new ali_abcdef();
        System.out.println(ali_abcdef.getMaxSequence("bbeeae"));
    }


}
