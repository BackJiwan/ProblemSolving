/*
1. 100개 있으니까 그냥 전부다 i랑 j로 순회하면서 ^2 으로 봐도됨
2. 다만 중복을 허용하지 않도록 Set에 담아서 관리하면 될듯
*/
import java.util.HashSet;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int n = numbers.length;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n-1;i++){//왼쪽
            for(int j=i+1;j<n;j++){//오른쪽 
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        
        //set을 오름차순으로 정렬하고 다시 int[] 로 만들어야 한다. 
        
        // HashSet<Integer> -> 스트림을 만들까...?
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();

    }
}