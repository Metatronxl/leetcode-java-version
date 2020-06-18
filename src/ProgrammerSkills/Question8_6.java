package ProgrammerSkills;

import java.util.List;

/**
 * 汉诺塔？ 果然大一的时候不会的东西现在也还是不会 :(
 */
public class Question8_6 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        helper(A.size(),A,B,C);
    }

    private void helper(int n,List<Integer> A,List<Integer> B,List<Integer> C){

        if (n==1){
            C.add(A.remove(A.size()-1));
        }
        helper(n-1,A,C,B);
        C.add(A.remove(A.size()-1));
        helper(n-1,B,A,C);

    }
}
