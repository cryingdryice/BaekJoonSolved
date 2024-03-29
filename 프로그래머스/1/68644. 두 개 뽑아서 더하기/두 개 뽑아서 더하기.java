import java.util.HashSet;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> numsSet = new HashSet<Integer>();

        for(int i = 0; i<numbers.length - 1; i++){
            for(int j = i+1; j<numbers.length; j++){
                numsSet.add(numbers[i]+numbers[j]);
            }
        }

        int[] answer = new int[numsSet.size()];
        int k = 0;
        for (Integer i : numsSet) {
            answer[k++] = i;
        }

        int N = answer.length;
        int temp;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && answer[j]< answer[j-1]; j--) {
                temp = answer[j];
                answer[j] = answer[j-1];
                answer[j-1] = temp;
            }
        }
        
        return answer;
    }
}