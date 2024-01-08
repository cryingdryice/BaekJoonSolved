import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int n = 0;
        long[] ways = new long[1000001];
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;

        for(int j = 0; j<T; j++){
            n = Integer.parseInt(br.readLine());
            for(int i =4; i<=n; i++){
                ways[i] = ((ways[i-1] + ways[i-2])%1000000009 + ways[i-3])%1000000009;
            }
            bw.write(ways[n]%1000000009+"\n");
            bw.flush();
        }

        bw.close();
    }
}