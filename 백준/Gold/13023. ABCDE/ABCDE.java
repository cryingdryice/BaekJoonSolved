
import com.sun.source.tree.ArrayAccessTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i<m; i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        for (int i = 0; i<n; i++){
            boolean[] visited = new boolean[n];
            boolean[] check = new boolean[1];
            dfs(graph, i, visited, 0, check);
//            System.out.println(check);
            if(check[0]){
                System.out.println(1);
                return;
            }
//            System.out.println("---------------------------");

        }
        System.out.println(0);


    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int i, boolean[] visited, int d, boolean[] check){
        if(d >= 4){
            check[0] = true;
            return;
        }

        visited[i] = true;
//        System.out.println(i);

        for (int next : graph.get(i)){
            if(!visited[next]){
                dfs(graph, next, visited,d+1, check);
            }
        }
        visited[i] = false;
    }
}
