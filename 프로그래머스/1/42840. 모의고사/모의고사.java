import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        //1,2,3번의 패턴을 배열에 저장해두기
        //answers에서 하나씩 빼서 정답을 체크해서 정답을 1,2,3번 배열에 저장하기
        int[][] pattern = new int[][] {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        
        int[] cnt = new int[pattern.length];
        
        for(int i=0;i<pattern.length;i++){
            for(int j=0;j<answers.length;j++){
                if(pattern[i][j%pattern[i].length]==answers[j]){
                    cnt[i]++;
                }
            }
        }
        
        int max = Arrays.stream(cnt).max().getAsInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i =0;i<cnt.length;i++){
            if(cnt[i]==max){
                list.add(i+1);
            }
        }
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}