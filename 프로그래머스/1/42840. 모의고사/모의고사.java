import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        //수포자들의 패턴을 이차원 배열에 최소단위로 저장
        int[][] pattern = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] scores = new int[3];
        
        //수포자의 수만큼 정답배열과 비교하며 각 수포자의 점수를 증가시켜 저장 
        
        for(int i=0;i<answers.length;i++){
            for(int j=0;j<pattern.length;j++){
                if(answers[i]==pattern[j][i%pattern[j].length]){
                    scores[j]++;
                }
            }
        }
        
        //수포자 점수 배열에서 최대 값을 찾아서 max 변수에 저장 
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        //수포자 점수 배열에서 max와 같은 인덱스들을 ArrayList에 add 하기 
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<scores.length;i++){
            if(scores[i]==maxScore){
                result.add(i+1);
            }
        }
        
        //ArrayList를 int[] 로 만들어서 리턴하기 
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}