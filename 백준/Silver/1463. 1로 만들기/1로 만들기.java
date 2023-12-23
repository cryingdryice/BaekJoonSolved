import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] MinWay = new int[1000001];
        MinWay[1] = 0;
        MinWay[2] = 1;
        MinWay[3] = 1;
        
        for(int i =4; i<=n; i++){
            // -1을 했을경우
            MinWay[i] = 1 + MinWay[i-1];
            // 2로 나누어떨어질 경우
            if(i%2 == 0 && MinWay[i/2]+1 < MinWay[i]){
                MinWay[i] = MinWay[i/2]+1;
            }
            // 3으로 나누어떨어질 경우
            if(i%3 == 0 && MinWay[i/3]+1 < MinWay[i]){
                MinWay[i] = MinWay[i/3]+1;
            }
        }
        
        bw.write(MinWay[n]+"");
        bw.flush();
        bw.close();
        
    }
    
}