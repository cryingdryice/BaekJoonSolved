import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] ways = new long[1001];
        ways[1] = 1;
        ways[2] = 3;
        
        for(int i =3; i<=n; i++){
            // -1을 했을경우
            ways[i] = (ways[i-1] + 2*ways[i-2])%10007;
        }
        
        bw.write(ways[n]+"");
        bw.flush();
        bw.close();
    }
}