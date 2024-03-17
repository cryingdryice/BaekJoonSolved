import java.util.HashSet;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> numsSet = new HashSet<Integer>();

//      모든 조합 구하기
        for(int i = 0; i<numbers.length - 1; i++){
            for(int j = i+1; j<numbers.length; j++){
                numsSet.add(numbers[i]+numbers[j]);
            }
        }

//      answer배열에 조합 복사
        int[] answer = new int[numsSet.size()];
        int k = 0;
        for (Integer i : numsSet) {
            answer[k++] = i;
        }

//      삽입정렬(데이터가 적은경우에 효과적)
        insertionSort(answer);

        return answer;
    }
    public void insertionSort(int[] arr) {
        int N = arr.length;
        int temp;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && arr[j]< arr[j-1]; j--) {
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
}