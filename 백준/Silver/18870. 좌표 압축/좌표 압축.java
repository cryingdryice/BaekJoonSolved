import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> numMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N]; // 원본배열
        HashSet<Integer> numsSet = new HashSet<Integer>(N);
        String input[] = br.readLine().split(" ");
        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(input[i]);
            numsSet.add(Integer.parseInt(input[i]));
        }

        // 정렬
        ArrayList<Integer> numList = new ArrayList<>(numsSet);
        Collections.sort(numList);

        for (int i = 0; i<numList.size(); i++){
            numMap.put(numList.get(i),i );
        }

        for(int i = 0; i<N; i++){
            bw.write(numMap.get(arr[i])+" ");
//            System.out.print(numMap.get(arr[i])+" ");
        }

//        bw.write("\n");
        bw.flush();
        bw.close();
    }
}