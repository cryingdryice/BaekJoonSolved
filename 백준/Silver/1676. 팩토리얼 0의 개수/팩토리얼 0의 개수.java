import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // N!의 인수중 5인수의 개수가 0의 개수(어떤 수든 5보다 2의 인수개수가 많기 때문)
        // 0! = 1, 1! = 1 (0,1은 제외)
        int cnt = 0;
        int five;
        for (int i = N; i > 1; i--) {
            if (i % 5 == 0) { // 5로 한 번 나눔
                five = i / 5;
                cnt++;
                if (five % 5 == 0) { // 5로 두 번 나눔
                    five /= 5;
                    cnt++;
                    if (five % 5 == 0) { // 5로 세번 나눔 인수중 125가 최대
                        cnt++;
                    }
                }
            }
        }

        if (N == 0) cnt = 0;
        else if (N == 1) cnt = 0;

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}