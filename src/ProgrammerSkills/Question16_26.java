package ProgrammerSkills;

import java.util.Stack;

public class Question16_26 {

    public int calculate(String s) {

        if (s == null) return 0;
        s = s.replaceAll(" ","");
        char[] array = s.toCharArray();
        int len = s.length();
        Stack<Integer> st = new Stack<>();

        int idx=0,ans=0;
        while (idx < len){

            char tmp = array[idx];
            if(tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-'){
                idx++;
            }
            int num=0;
            while (idx<len && Character.isDigit(array[idx])){
                num = num*10 + array[idx]-'0';
                idx++;
            }
            switch (tmp){
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop()*num;
                    break;
                case '/':
                    num = st.pop()/num;
                    break;
                default:
                    break;
            }
            st.push(num);
        }
        while (!st.isEmpty()) ans += st.pop();
        return ans;

    }

    public static void main(String[] args) {
        Question16_26 question16_26 = new Question16_26();
        System.out.println(question16_26.calculate(" 3+ 2 *2  "));
    }
}
