
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        boolean nums[] = new boolean[10];
        for(int i = 0; i<10; i++) nums[i] =true;
        if(T != 0){
            String input[] = br.readLine().split(" ");
            for (int i = 0; i<T; i++){
                nums[Integer.parseInt(input[i])] = false;
            }
        }

        int min;
        // 100부터 시작할때
        if(target >= 100) min = target-100;
        else min = 100-target;

        if(T == 10){
            bw.write(min+"\n");
            bw.flush();
            bw.close();

            return;
        }

        // target보다 작은 수 일 때
        int ch = target;
        while(true){
            if(ch == -1) break;
            if(check(ch, nums)) break;

            ch--;
        }
        if(ch == -1) {}
        else{
            if(ch == 0) min = target + 1 < min ? target + 1 : min;
            else min = (Math.log10(ch)+1+target-ch) < min ? (int) (Math.log10(ch) + 1 + target - ch) : min;
        }
        // target보다 큰 수 일 때
        ch = target;
//        if(only0(nums)){
//            bw.write(min+"\n");
//            bw.flush();
//            bw.close();
//            return;
//        }
        while(true){
            if(ch == 1000000) break;
            if(check(ch, nums)) break;

            ch++;
        }
        if(ch == 1000000){}
        else{
            if(ch == 0) min = target + 1 < min ? target + 1 : min;
            else min = (Math.log10(ch)+1+ch-target) < min ? (int) (Math.log10(ch) + 1 + ch-target) : min;
        }

        bw.write(min+"\n");
        bw.flush();
        bw.close();
    }

    static boolean check(int ch, boolean nums[]){
        while(true){
            if(!nums[ch%10]) return false;
            ch /= 10;
            if(ch == 0) break;
        }
        return true;
    }

//    static boolean only0(boolean nums[]){
//        if(!nums[0]) return false;
//        for(int i = 1; i<10; i++){
//            if(nums[i]) return false;
//        }
//        return true;
//    }
}
