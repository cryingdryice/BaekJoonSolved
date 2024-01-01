import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long ways[][] = new long[101][5];

        ways[1][0] = 1; ways[1][1] = 2; ways[1][2] = 2; ways[1][3] = 2; ways[1][4] = 2;
        for(int i = 2; i<=100; i++){
            ways[i][0] = ways[i-1][1];
            ways[i][1] = (ways[i-1][0] + ways[i-1][2])%1000000000;
            ways[i][2] = (ways[i-1][1] + ways[i-1][3])%1000000000;
            ways[i][3] = (ways[i-1][2] + ways[i-1][4])%1000000000;
            ways[i][4] = (ways[i-1][3] + ways[i-1][4])%1000000000;
        }

        bw.write((ways[N][0]+ways[N][1]+ways[N][2]+ways[N][3]+ways[N][4])%1000000000+"\n");
        bw.flush();
        bw.close();
    }
}