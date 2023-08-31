import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(fact(N)+"");
        bw.flush();
        bw.close();
    }

    static int fact(int N){
        int factN = 1;
        for(int i = N; i>1; i--){
            factN *= i;
        }
        return factN;
    }
}