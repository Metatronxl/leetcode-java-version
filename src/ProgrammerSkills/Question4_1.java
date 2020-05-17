package ProgrammerSkills;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lei.X
 * @date 2020/5/7
 */
public class Question4_1 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

        if (n==0) return false;
        if (n==1) return true;

        List<Integer>[] arrayList = new ArrayList[n];
        for (int[] edge: graph){

            int from = edge[0];
            int to = edge[1];

            if (arrayList[from] == null){
                arrayList[from] = new ArrayList<>();
            }
            arrayList[from].add(to);
        }


        return hashPath(n,arrayList,start,target);
    }

    private boolean hashPath(int n,List<Integer>[] arrayList,int start,int target){

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){

            int temp = queue.poll();
            if (arrayList[temp] == null){
                continue;
            }

            for (Integer num: arrayList[temp]){

                if (num == target){
                    return true;
                }

                if (visited[num]){
                    continue;
                }else {

                    visited[num] = true;
                    queue.offer(num);
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Question4_1 question4_1 = new Question4_1();
        int n=3;
        int[][] graph = new int[][]{{0,1},{0,2},{1,2},{1,2}};

        System.out.println(question4_1.findWhetherExistsPath(n,graph,0,2));
    }
}
