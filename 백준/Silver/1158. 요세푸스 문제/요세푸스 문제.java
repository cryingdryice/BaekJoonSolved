import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        StringBuilder output = new StringBuilder();
        output.append("<");

        int N = Integer.parseInt(input.nextToken());
        int K = Integer.parseInt(input.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<N; i++){ // 큐에 1부터 N까지 채우기
            queue.offer(i+1);
        }

        while(queue.size() > 1){ //큐의 사이즈가 1일이기 전까지 반복(마지막 남은 한 숫자는 수행할 이유가 없기때문)
            for(int i =0; i<K-1;i++) { //k-1까지 숫자를 빼서 다시 넣기(큐의 맨 뒤로 순서대로 보내기)
                int num = queue.poll();
                queue.offer(num);
            }
            output.append(queue.poll()).append(", ");
        }
        output.append(queue.poll()).append(">");
        bw.write(output+"\n");
        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();
    }
}