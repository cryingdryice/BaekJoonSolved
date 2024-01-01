import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int n = 0;
        long[][] ways = new long[100001][4];
        
        ways[1][0] = 1; ways[1][1] = 1; ways[1][2] = 0; ways[1][3] = 0;
        ways[2][0] = 1; ways[2][1] = 0; ways[2][2] = 1; ways[2][3] = 0;
        ways[3][0] = 3; ways[3][1] = 1; ways[3][2] = 1; ways[3][3] = 1;
        for(int i = 4;i<=100000;i++){
            //ways[i][0] = ways[i-1][0] + ways[i-2][0] + ways[i-3][0] - ways[i-1][1] - ways[i-2][2] - ways[i-3][3];
            ways[i][1] = (ways[i-1][2] + ways[i-1][3])%1000000009;
            ways[i][2] = (ways[i-2][1] + ways[i-2][3])%1000000009;
            ways[i][3] = (ways[i-3][1] + ways[i-3][2])%1000000009;
            ways[i][0] = ((ways[i][1] + ways[i][2])%1000000009 + ways[i][3])%1000000009;
        }
        
        for(int j = 0; j<T; j++){
            n = Integer.parseInt(br.readLine());
            
            bw.write(ways[n][0]+"\n");
            bw.flush();
        }
        
        bw.close();
    }
}