package util;


public class Test {


            private int[] getReverArray(String num){

                int len = num.length();
                int[] arr = new int[len+1];
                for (int i=len-1;i>=0;i--){
                    arr[len-i-1] = num.charAt(i)-'0';
                }

                return arr;
            }


            private String mergetArray(int[] numArr,int[] num2Arr){

                int len = numArr.length;
                int len2 = num2Arr.length;

                int resLen = Math.max(len,len2);
                int[] resArr = new int[resLen+1];
                int judge=0;

                int i=0,j=0;
                int idx=0;
                while (i<len && j<len2){

                    int num = (numArr[i]+num2Arr[j]+judge) % 10;
                    judge = (numArr[i]+num2Arr[j]+judge) /10;
                    resArr[idx] = num;
                    i++;
                    j++;
                    idx++;
                }

                if (i==len){

                    while (j<len2){
                        int num = (num2Arr[j]+judge)%10;
                        judge = (num2Arr[j]+judge) /10;
                        resArr[idx] = num;
                        j++;
                        idx++;

                    }
                }

                if (j==len2){
                    while (i<len){
                        int num = (numArr[i]+judge)%10;
                        judge = (numArr[i]+judge) /10;
                        resArr[idx] = num;
                        i++;
                        idx++;

                    }
                }

                StringBuilder sb = new StringBuilder();
                if (judge ==1){
                    sb.append(1);
                }
                for (int k=0;k<resLen;k++){

                    sb.append(resArr[resLen-k-1]);
                }

                return sb.toString();
            }


            public String addString(String num1, String num2){

                int[] numArr = getReverArray(num1);
                int[] num2Arr = getReverArray(num2);
                String res  = mergetArray(numArr,num2Arr);

                return res;

            }






    public static void main(String[] args) {


        Test test = new Test();
        System.out.println(test.addString("931431413439999","9994314314341"));

    }


}
