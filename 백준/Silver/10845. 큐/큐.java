import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static int[] queue = new int[10001];
    static int front = 0; // 가장 먼저 들어왔던 데이터 인덱스(pop할 위치 인덱스)
    static int back = 0; // 나중에 들어올 데이터 인덱스(psuh할 위치 인덱스)

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuffer output = new StringBuffer(); // 결과담을 문자열
//        queue = new int[10001];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            switch (input) {
                case "pop":
                    output.append(pop()).append('\n');
                    break;
                case "size":
                    output.append(size()).append('\n');
                    break;
                case "empty":
                    output.append(empty()).append('\n');
                    break;
                case "front":
                    output.append(front()).append('\n');
                    break;
                case "back":
                    output.append(back()).append('\n');
                    break;
                default:
                    String[] words = input.split(" ");
                    push(Integer.parseInt(words[1]));
                    break;
            }
        }
        bw.write(output+"\n");
        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();
    }

    public static void push(int num) {
        queue[back] = num;
        back++;
    }
    public static int pop() {
        if(back-front == 0) {return -1;}
        else {
            return queue[front++];
        }
    }
    public static int size() {return back-front;}
    public static int empty() { // back과 front가 같으면 큐가 비어있다는 뜻이므로 size는0
        if(back-front == 0) {return 1;}
        else {return 0;}
    }
    public static int front() {
        if(back-front == 0) {return -1;}
        else {return queue[front];}
    }
    public static int back() {
        if(back-front == 0) {return -1;}
        else {return queue[back-1];} // 들어올 배열에서 한 칸 앞 배열이 가장 나중에 들어온 데이터위치
    }
}