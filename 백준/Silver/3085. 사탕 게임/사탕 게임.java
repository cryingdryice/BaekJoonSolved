import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        char candy[][] = new char[T][T];
        String input[];

        for(int i = 0;i<T;i++){
            input = br.readLine().split("");
            for(int j = 0; j<T; j++){
                candy[i][j] = input[j].charAt(0);
            }
        }

        char temp;
        int max = 0;
        // 같은 행(가로)으로 바꿨을 때
        for(int i = 0; i<T; i++){
            for(int j = 0; j<T-1; j++){
                // swap
                temp = candy[i][j];
                candy[i][j] = candy[i][j+1];
                candy[i][j+1] = temp;
                
                max = max > findmaxrow(candy, T, i) ? max : findmaxrow(candy, T, i);
                max = max > findmaxcol(candy, T, j) ? max : findmaxcol(candy, T, j);
                max = max > findmaxcol(candy, T, j+1) ? max : findmaxcol(candy, T, j+1);

                // swap 원래대로
                temp = candy[i][j];
                candy[i][j] = candy[i][j+1];
                candy[i][j+1] = temp;
            }
        }

        // 같은 열(세로)으로 바꿨을 때
        for(int j = 0; j<T; j++){
            for(int i = 0; i<T-1; i++){
                // swap
                temp = candy[i][j];
                candy[i][j] = candy[i+1][j];
                candy[i+1][j] = temp;

                max = max > findmaxrow(candy, T, i) ? max : findmaxrow(candy, T, i);
                max = max > findmaxrow(candy, T, i+1) ? max : findmaxrow(candy, T, i+1);
                max = max > findmaxcol(candy, T, j) ? max : findmaxcol(candy, T, j);

                // swap 원래대로
                temp = candy[i][j];
                candy[i][j] = candy[i+1][j];
                candy[i+1][j] = temp;
            }
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }

    static int findmaxrow(char candy[][], int T, int r){
        int max = 0;
        // C P Z Y
        int count = 0;
        for(int j = 0; j<T; j++){
            for(int k = j; k<T; k++){
                if(candy[r][j] == candy[r][k]) count++;
                else break;
            }
            max = count > max ? count : max;
            count = 0;
        }

        return max;
    }

    static int findmaxcol(char candy[][], int T, int c){
        int max = 0;
        // C P Z Y
        int count = 0;
        for(int i = 0; i<T; i++){
            for(int k = i; k<T; k++){
                if(candy[i][c] == candy[k][c]) count++;
                else break;
            }
            max = count > max ? count : max;
            count = 0;
        }

        return max;
    }
}