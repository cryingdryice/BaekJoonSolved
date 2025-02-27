import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] alpha; // a-z
    static String[] words; // 앞4, 뒤4글자를 뺀 단어들 모음
    static int N;
    static int K;
    static int max = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        alpha = new boolean[26];
        alpha[0] = true; alpha[2] = true; alpha[8] = true; alpha[13] = true; alpha[19] = true;
        words = new String[N];

        String word;
        for(int i = 0; i<N; i++){ // 중간 단어만 추출해 저장
            word = br.readLine();
            words[i] = word.substring(4, word.length()-4);
        }

        if(K<5){ // K<5 일 경우는 무조건 0
            System.out.println(0);
            return;
        }

        bt(0,0);

        System.out.println(max);
    }

    static void bt(int start, int depth){
//        System.out.println("depth: "+depth);
        if(depth == K-5){
//            for(int i = 0; i<26; i++){
//                if(alpha[i]) System.out.print(1);
//                else System.out.print(0);
//            }
//            System.out.println();
            int cnt = 0;
            // 현재 조합으로 읽을 수 있는 단어의 수
            for(int i = 0; i<N; i++){
                if(check(words[i])) cnt++;
            }
//            System.out.println(cnt);
            max = Math.max(cnt, max);
            return;
        }

        for(int i = start; i<26; i++){ // 모든 조합
            if(i==0||i==2||i==8||i==13||i==19) continue;
            alpha[i] = true;
            bt(i +1, depth+1);
            alpha[i] = false;
        }

    }

    static boolean check(String word){
        boolean flag = true;
        for(int i = 0; i<word.length(); i++){
            for(int a = 0; a<26; a++){
                if(!alpha[word.charAt(i)-97]) return false;
            }
        }

        return flag;
    }

}
