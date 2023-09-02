import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Main {
    static int front;
    static int back;
    static int size = 0;
    static int[] deque;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        front = N;
        back = N;
        deque = new int[2*N+1];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            switch(input[0]) {
                case "push_front" : {
                    push_front(Integer.parseInt(input[1]));
                    break;
                }
                case "push_back" : {
                    push_back(Integer.parseInt(input[1]));
                    break;
                }
                case "pop_front" : {
                    output.append(pop_front()).append('\n');
                    break;
                }
                case "pop_back" : {
                    output.append(pop_back()).append('\n');
                    break;
                }
                case "size" : {
                    output.append(size()).append('\n');
                    break;
                }
                case "empty" : {
                    output.append(empty()).append('\n');
                    break;
                }
                case "front" : {
                    output.append(front()).append('\n');
                    break;
                }
                case "back" : {
                    output.append(back()).append('\n');
                    break;
                }
            }
        }
        bw.write(output+"\n");
        bw.flush();
        bw.close();
    }
    static void push_front(int num) {
        deque[front] = num;
        front--;
        size++;
    }
    static void push_back(int num) {
        back++;
        size++;
        deque[back] = num;
    }
    static int pop_front() {
        if (size == 0) {
            return -1;
        }
        int ret = deque[front + 1];
        front++;
        size--;
        return ret;
    }
    static int pop_back() {
        if (size == 0) {
            return -1;
        }
        int ret = deque[back];
        back--;
        size--;
        return ret;
    }
    static int size() {
        return size;
    }
    static int empty() {
        if(size == 0) {
            return 1;
        }
        return 0;
    }
    static int front() {
        if(size == 0) {
            return -1;
        }
        return deque[front + 1];
    }
    static int back() {
        if(size == 0) {
            return -1;
        }
        return deque[back];
    }
}