// 코딩테스트 템플릿

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        ArrayList<ArrayList<Integer>> homes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> chickens = new ArrayList<>();
        int temp;

        for(int i = 0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j<N; j++){
                temp = Integer.parseInt(input[j]);
                ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(i, j));
                if(temp == 1){
                    homes.add(al);
                }
                if(temp == 2){
                    chickens.add(al);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        boolean[] visisted = new boolean[chickens.size()];
        ArrayList<Integer> sums = new ArrayList<Integer>();
        bt(chickens, homes,0, visisted, M, sums);
        for(int sum : sums){
            min = Math.min(min, sum);
        }


        bw.write(min+"\n");

        bw.flush();
        bw.close();
    }
    static void bt(ArrayList<ArrayList<Integer>> chickens, ArrayList<ArrayList<Integer>> homes, int start, boolean[] visited, int M, ArrayList<Integer> sums){
        if(M == 0){
            // 치킨집 조합
            ArrayList<ArrayList<Integer>> choices = new ArrayList<>();
            for(int i = 0; i<chickens.size(); i++){
                if(visited[i]){
                    choices.add(chickens.get(i));
                }
            }

            int sum = 0; // 선택된 치킨집에 대한 도시의 치킨 거리
            for(int i = 0; i<homes.size(); i++){ // 집 순회하며 가장 작은 치킨집 고르기
                // i번째 집의 최소 치킨 거리
                int min = distance(choices.get(0), homes.get(i));
                for(int j = 1; j<choices.size(); j++){
                    min = Math.min(min, distance(choices.get(j), homes.get(i)));
                }
                sum += min;
            }

            sums.add(sum);
//            System.out.println(sum);
            return;
        }

        for(int i = start; i<chickens.size(); i++){
            visited[i] = true;
            bt(chickens, homes,i+1, visited, M-1, sums);
            visited[i] = false;
        }

        return;
    }

    static int distance(ArrayList<Integer> choice,ArrayList<Integer> home){
        int r1 = home.get(0);
        int c1 = home.get(1);
        int r2 = choice.get(0);
        int c2 = choice.get(1);

        return Math.abs(r1-r2)+Math.abs(c1-c2);
    }
}
