package ProgrammerSkills;

public class Question5_6 {

    // func 1
    public int convertInteger(int A, int B) {

        return  Integer.bitCount(A ^ B);
    }

    //func 2
    public int converInteger2(int A , int B){

        int count=0;
        for (int n= A ^ B;n!=0; n &= n-1){
            count++;
        }
        return count;
    }
}
