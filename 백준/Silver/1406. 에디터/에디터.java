import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());
        StringBuffer output = new StringBuffer(); // 결과담을 문자열

        Stack curL = new Stack<>(); // 커서 왼쪽부분의 문자열 스택
        Stack curR = new Stack<>(); // 커서 오른쪽부분의 문자열 스택

        for (int i = 0; i < input.length(); i++) { // 입력받은 문자열의 curL스택에 넣기
            curL.push(input.charAt(i));
        }

        for(int i = 0; i < M; i++) {
            String editkey = br.readLine();
            switch (editkey) {
                case "L":
                    if(!curL.empty()){ // 왼쪽스택이 비어있지 않으면 curL의 top을 curR로 pop
                        curR.push(curL.pop());
                    }
                    break;
                case "D":
                    if(!curR.empty()){ // 오른쪽스택이 비어있지 않으면 curR의 top을 curL로 pop
                        curL.push(curR.pop());
                    }
                    break;
                case "B": // 왼쪽스택이 비어있지 않으면 curL top제거(pop)
                    if(!curL.empty()){
                        curL.pop();
                    }
                    break;
                default:
                    String[] words = editkey.split(" ");
                    curL.push(words[1]);
                    break;
            }
        }
        while (!curL.empty()) { // 모든 왼쪽스택의 문자를 curR스택에 넣기(결과를 출력하기 위해 하나의 스택에 문자들을 다 넣기 위함)
            curR.push(curL.pop());
        }

        while (!curR.empty()) { // curR의 문자를 output에 연결
            output.append(curR.pop());
        }
        System.out.println(output);
    }
}