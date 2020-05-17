package swordOfOffer;


/**
 * @author lei.X
 * @date 2020/3/8
 */
public class AllSort {

    public static void main(String[] args) {

        String abc = "abc";

        char[] abcArray = abc.toCharArray();


        permuate(abcArray,0,abcArray.length-1);


    }

    public static void permuate(char[] array, int start,int end){

        if (start == end){
            System.out.println(String.valueOf(array));
        }else {

            for (int i=start;i<=end;i++){

                array = swap(array,i,start);
                permuate(array,start+1,end);
                array = swap(array,i,start);
            }

        }
    }


    private static char[] swap(char[] chars,int a, int b){

        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;

        return chars;
    }





}
