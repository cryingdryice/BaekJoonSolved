import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean tag = false; // tag안에 있는 문자인지 판별

        String input = br.readLine();

        for(int i = 0; i<input.length(); i++){ // input의 글자 하나하나를 검사
            if(input.charAt(i) == '<') {
                tag = true; // '<'가 시작되면 태그 안이므로 true
                while (!stack.isEmpty()) { // 이전까지의 단어를 뒤집어서 출력
                    output.append(stack.pop());
                }
                output.append(input.charAt(i)); // '<'은 그대로 출력
            }else if(input.charAt(i)=='>'){
                tag = false; // tag가 끝났다는 뜻
                output.append(input.charAt(i)); // '>'은 그대로 출력
            }else if(tag){
                output.append(input.charAt(i)); // tag안이면 그대로 문자출력
            }else if(!tag){
                if(input.charAt(i) == ' '){ // tag밖이면서 ' '이면 스택모두 pop
                    while(!stack.isEmpty()){
                        output.append(stack.pop());
                    }
                    output.append(input.charAt(i));
                }else{ // ''이 아니면 스택에 넣기(단어 뒤집기 위함)
                    stack.push(input.charAt(i));
                }
            }
        }
        while(!stack.isEmpty()) {
            output.append(stack.pop());
        }
        bw.write(output+"");
        bw.flush();
        bw.close();
    }
}