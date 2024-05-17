import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Double[] nums = new Double[N];
        for (int i = 0; i<N; i++) {
            nums[i] = Double.parseDouble(input[i]);
        }

        Double max = nums[0];
        for (int i = 1; i<N; i++){
            max = max < nums[i] ? nums[i] : max;
        }

        double sum = 0;
        for (int i = 0; i<N; i++){
            nums[i] = nums[i]/max*100;
            sum += nums[i];
        }

        System.out.println(sum/N);
    }
}