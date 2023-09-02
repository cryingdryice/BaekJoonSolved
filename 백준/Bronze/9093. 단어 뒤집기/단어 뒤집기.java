import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        String[] output = new String[T]; // 출력담는 배열

        for (int i = 0; i < T; i++) {
            String input = scanner.nextLine(); // 한 문장 받기
            String[] wordArray = input.split(" "); // 한 문장을 단어 단위로 쪼갠뒤 wordAraay에 담기
            StringBuffer sentence = new StringBuffer(); // 뒤집은 단어들을 저장할 문장
            for(int j = 0; j < wordArray.length; j++){ // 각 단어들 뒤집고 sentence에 붙이기
                StringBuffer tmp = new StringBuffer(wordArray[j]);
                tmp.reverse();
                sentence.append(tmp).append(" ");
            }
            output[i] = sentence.toString(); // output에 문장 저장
        }

        for (int i = 0; i<output.length; i++) {
            System.out.println(output[i]);

        }
    }
}