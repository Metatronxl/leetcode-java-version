package ProgrammerSkills;

import java.util.*;

public class Question16_10 {

    /**
     * 使用dp来记录某一年的净出生率
     * @param birth
     * @param death
     * @return
     */
    public int maxAliveYear(int[] birth, int[] death){
        int[] lives = new int[102];

        // lives记录每一年的净出生率，即出生数-死亡数
        for (int birthYear:birth){
            lives[birthYear-1900]++;
        }
        for (int deathYear: death){
            lives[deathYear-1900+1]--;
        }
        int[] preSum = new int[102];
        preSum[0] = lives[0];
        for (int i=1;i<preSum.length;i++){
            preSum[i] = lives[i]+preSum[i-1];
        }
        int maxLives = -1;
        int minYear = 0;

        for (int i=0;i<preSum.length;i++){
            if (preSum[i] > maxLives){
                maxLives = preSum[i];
                minYear = i+1990;
            }
        }

        return minYear;

    }

    public int maxAliveYear2(int[] birth, int[] death) {

        HashMap<Integer,Integer> yearCount = new HashMap<>();
        int len = birth.length;
        for (int i=0;i<len;i++){
            int startYear = birth[i];
            int endYear = death[i];
            for (int j=startYear;j<=endYear;j++){
                Integer value = yearCount.get(j);
                if (value == null){
                    yearCount.put(j,1);
                }else {
                    value +=1;
                    yearCount.put(j,value);
                }
            }
        }

        int maxCount=0;
        int maxYear=2000;
        for (Map.Entry<Integer, Integer> map :
                yearCount.entrySet()) {
            if (map.getValue() > maxCount){
                maxCount = map.getValue();
                maxYear = map.getKey();
            }else if (map.getValue() == maxCount){
                maxYear = Math.min(maxYear,map.getKey());
            }
        }

        return maxYear;

    }

    public static void main(String[] args) {

        Question16_10 question16_10 = new Question16_10();
        int[] birth = new int[]{1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,1901};
        int[] death = new int[]{1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,1969};
        System.out.println(question16_10.maxAliveYear(birth,death));
    }
}
