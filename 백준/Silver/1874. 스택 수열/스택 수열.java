import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuffer output = new StringBuffer();	// 출력 배열

        int N = scanner.nextInt();
        int[] stack = new int[N];

        int index = 0; // push나 pop할 스택의 인덱스
        int start = 0;
        boolean setOutput = true;

        for(int i = 0; i<N; i++){
            int num = scanner.nextInt();

            if(num > start){
                for(int j = start; j<num; j++){ // 입력값까지 push하기
                    stack[index] = j+1;
                    index++;
                    output.append("+").append("\n");
                }
                start = num;
            }else if(stack[index - 1] != num) { // top인덱스가 입력값과 다르면(pop할 수 없으면) 불가능
                System.out.println("NO");
                setOutput = false;
                break;
            }

            index--; // pop하기
            output.append("-").append("\n");
        }
        if(setOutput){System.out.println(output);}
    }
}