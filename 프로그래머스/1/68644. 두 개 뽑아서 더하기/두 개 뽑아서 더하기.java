import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        
        //만들수 있는 모든수인 answer는 set으로 중복을 자동 제거 한다. 
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        //return set.stream().sorted().mapToInt(Integer::intValue).toArray();
        
        //return set.stream().sorted((o1,o2)->Integer.compare(o1,o2)).mapToInt(Integer::intValue).toArray();
        
        return set.stream().sorted((o1,o2) -> o1.compareTo(o2)).mapToInt(Integer::intValue).toArray();

    }
}