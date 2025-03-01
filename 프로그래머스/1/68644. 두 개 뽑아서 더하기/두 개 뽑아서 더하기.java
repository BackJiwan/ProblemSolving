/*
1. numbers의 길이는 최대 100
2. 2중 반복문을 통해서 두개의 수를 골라서 set에 저장 
3. sorted를 이용해서 정렬하는데에 NLog(N)의 복잡도가 소요 
4. 여기에서 N은 전체 데이터의 개수인데 N < 100^2 이므로
5. 복잡도는 100^2*log(100^2)이하이다. 
*/

/*
1. 2중 반복문을 통해서 numbers의 왼쪽,오른쪽 쌍을 통해서 가능한 모든 쌍을 고른다.
2. 골랐을 때마다 HashSet에 넣어서 중복없이 모든 합을 저장한다. 
3. 저장 이후 정렬을 하고 int[] 의 형태로 리턴.
*/

import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}