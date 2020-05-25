package ProgrammerSkills;

public class Question5_2 {

    public String printBin(double num) {

        StringBuilder res = new StringBuilder();
        res.append("0.");
        int idx = 30;
        while (num > 0 && idx > 0){
            num *=2;
            if(num >= 1){
                res.append(1);
                num -=1;
            }else {
                res.append(0);
            }
            idx--;
        }

        return num==0 ? res.toString() : "ERROR";
    }

    public static void main(String[] args) {

        Question5_2 question5_2 = new Question5_2();
        System.out.println(question5_2.printBin(0.1));
    }
}
