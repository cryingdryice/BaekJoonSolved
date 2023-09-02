import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        StringBuffer output = new StringBuffer();

        for(int i = 0; i<T; i++){
            String input = scanner.nextLine();
            int cnt = 0;
            boolean re = true;

            for(int j = 0; j<input.length(); j++){
                if(input.charAt(j) == '('){
                    cnt++;
                    re = true;
                }else if(cnt == 0){
                    output.append("NO").append("\n");
                    re = false;
                    break;
                }else{
                    re = true;
                    cnt--;
                }
            }

            if(re && cnt == 0){
                output.append("YES").append("\n");
            }else if(re){
                output.append("NO").append("\n");
            }
        }
        System.out.println(output);
    }
}