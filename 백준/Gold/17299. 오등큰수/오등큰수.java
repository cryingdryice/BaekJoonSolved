import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> outputNum = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] numArray = new int[N]; // 정수 배열 생성
        int index = 0;
        while (st.hasMoreTokens()) { // 배열 초기화
            numArray[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        int[] FArray = new int[1000001];
        int indexF = 0;
        for(int i = 0; i<N; i++){ // FArray[]의 i위치에는 NumArray의 원소가 i인 i의 개수가 들어감
            FArray[numArray[i]] +=1;
        }
        for(int i = N-1; i >= 0; i--){ // i는 현재 인덱스 (숫자배열 거꾸로 탐색)
            if(stack.isEmpty()){ // 스택이 비어있으면 -1
                outputNum.push(-1);
            }else{
                while(FArray[stack.peek()] <= FArray[numArray[i]]){
                    stack.pop(); // 스택에 현재값보다 작은애들은 다 빼기
                    if(stack.isEmpty()){ // 만약 다 빼서 스택이 비어버렸다면 -1
                        outputNum.push(-1);
                        break;
                    }
                }
                if(!stack.isEmpty()){outputNum.push(stack.peek());} // 스택에서 뺀 후 남아있는 탑 원소가 가장 왼쪽에 있으면서 큰 수
            }
            stack.push(numArray[i]);
        }
        for(int i = 0; i<N; i++){
            output.append(outputNum.pop()+" ");
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}