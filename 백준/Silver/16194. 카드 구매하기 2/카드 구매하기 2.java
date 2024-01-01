import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] pi = new int[T+1]; //pi저장배열
        int[] ways = new int[T+1]; // 개수마다 최대비용
        
        String[] input = br.readLine().split(" ");
        for(int i = 0; i<T; i++){ // 입력배열 정수로 초기화
            pi[i+1] = Integer.parseInt(input[i]);
            ways[i+1] = pi[i+1];
        }

        for(int n = 1; n <= T; n++){
            for(int k = 1; k < n; k++){
                //if(ways[k] + pi[n-k] >= ways[n]) ways[n] = ways[k] + pi[n-k];
                if(ways[k] + pi[n-k] <= ways[n]) ways[n] = ways[k] + pi[n-k];
            }
        }
        
        
        bw.write(ways[T]+"");
        bw.flush();
        bw.close();
        
    }
    
}