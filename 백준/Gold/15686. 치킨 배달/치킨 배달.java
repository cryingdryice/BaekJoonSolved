import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static ArrayList<ArrayList<Integer>> homes = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> chickens = new ArrayList<>();
    static ArrayList<Integer> sums = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int temp;

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                temp = Integer.parseInt(input[j]);
                ArrayList<Integer> al = new ArrayList<>(Arrays.asList(i, j));
                if (temp == 1) {
                    homes.add(al);
                }
                if (temp == 2) {
                    chickens.add(al);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[chickens.size()];
        bt(0, visited, M);
        
        for (int sum : sums) {
            min = Math.min(min, sum);
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    static void bt(int start, boolean[] visited, int M) {
        if (M == 0) {
            ArrayList<ArrayList<Integer>> choices = new ArrayList<>();
            for (int i = 0; i < chickens.size(); i++) {
                if (visited[i]) {
                    choices.add(chickens.get(i));
                }
            }

            int sum = 0;
            for (ArrayList<Integer> home : homes) {
                int min = distance(choices.get(0), home);
                for (int j = 1; j < choices.size(); j++) {
                    min = Math.min(min, distance(choices.get(j), home));
                }
                sum += min;
            }

            sums.add(sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            bt(i + 1, visited, M - 1);
            visited[i] = false;
        }
    }

    static int distance(ArrayList<Integer> choice, ArrayList<Integer> home) {
        return Math.abs(home.get(0) - choice.get(0)) + Math.abs(home.get(1) - choice.get(1));
    }
}
