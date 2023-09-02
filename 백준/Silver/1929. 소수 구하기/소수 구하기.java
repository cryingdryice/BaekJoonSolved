import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();

        boolean[] isnotprime = new boolean[1000001]; // 모든 요소가 false
        for(int i = 2; i<1000000; i++){ // 소수라면 isnotprime은 false
            if(isnotprime[i]==true) continue; // 이미 소수가 아닌걸로 판명났으면 continue
            for(int j=i*2;j<=1000000; j+=i) { // 판명난 수가 아니면, 그 배수(*2)부터 출발하여, 소수아닌 것 판별하기( 4, 6, 8... 6, 9, 12... 10 20 30...)
                isnotprime[j] = true;
            }
        }
        isnotprime[1] = true; // 1은 소수가 아님

        int[] nums = new int[2];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i<2; i++){ // 입력배열 정수로 초기화
            nums[i] = Integer.parseInt(input[i]);
        }
        for(int i =nums[0]; i<=nums[1]; i++){
            if(!isnotprime[i]) output.append(i+"\n");
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}