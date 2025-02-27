import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int alpha = 0;
    static int[] words; // 앞4, 뒤 4글자를 뺀 단어들 모음
    static int N;
    static int K;
    static int max = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        alpha = stob("acint"); // 기본 단어 추가
        words = new int[N];

        String word;
        for(int i = 0; i<N; i++){ // 중간 단어만 추출해 저장
            word = br.readLine();
            words[i] = stob(word.substring(4, word.length()-4));
        }

        if(K<5){ // K<5 일 경우는 무조건 0
            System.out.println(0);
            return;
        }

        bt(0,0);

        System.out.println(max);
    }

    static void bt(int start, int depth){
        if(depth == K-5){
            int cnt = 0;
            // 현재 조합으로 읽을 수 있는 단어의 수
            for(int i = 0; i<N; i++){
                if((alpha | words[i]) == alpha) cnt++; // words[i]가 현재 alpha의 부분집합이라면(읽을 수 있는 단어라면)
            }
            max = Math.max(cnt, max);
            return;
        }

        for(int i = start; i<26; i++){ // 모든 조합
            if(i==0||i==2||i==8||i==13||i==19) continue;
            alpha = alpha | (1 << i); // i번째 알파벳 원소 추가
            bt(i +1, depth+1);
            alpha = alpha & ~(1 << i); // i번째 알파벳 원소 삭제
        }

    }

    static int stob(String word){ // 문자열을 비트로 바꿔줌
        int alpha = 0;
        for(int i = 0; i<word.length(); i++){
            alpha = alpha | (1 << word.charAt(i)-97);
        }

        return alpha;
    }

}