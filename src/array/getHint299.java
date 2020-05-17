package array;

/**
 * @author lei.X
 * @date 2019/12/4
 */
public class getHint299 {

    public String getHint(String secret, String guess) {

        int bull = 0;
        int cow = 0;
        int len = secret.length();
        int bucket[] = new int[10];

        for (int i=0;i<len;i++){
            if (secret.charAt(i)-'0' == guess.charAt(i)-'0'){
                bull +=1;
            }else{
                bucket[secret.charAt(i)-'0'] += 1;
                bucket[guess.charAt(i)-'0'] -= 1;
            }
        }

        int diff = 0;
        for(int i=0;i<len;i++){
            if (bucket[i] > 0){
                diff += bucket[i];
            }
        }

        cow = len-bull-diff;

        return bull+"A"+cow+"B";

    }
}
