import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int n = 0;
        long[] ways = new long[1001];
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;
        
        for(int j = 0; j<T; j++){
            n = Integer.parseInt(br.readLine());
            for(int i =4; i<=n; i++){
            // -1을 했을경우
            ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
            }
            bw.write(ways[n]+"\n");
            bw.flush();
        }
        
        bw.close();
    }
}