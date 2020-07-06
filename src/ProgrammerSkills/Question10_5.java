package ProgrammerSkills;

public class Question10_5 {

    public int findString(String[] words, String s) {
        for(int i=0; i<words.length; i++){
            if(words[i].length() == 0 || words[i].charAt(0) < s.charAt(0)){
                continue;
            }
            if(words[i].charAt(0) > s.charAt(0)){
                break;
            }
            if(words[i].equals(s)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Question10_5 question10_5 = new Question10_5();
        String[] words = new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
        System.out.println(question10_5.findString(words,"ball"));
    }
}
