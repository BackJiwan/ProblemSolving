/*
1. price의 길이가 10만이다. O(N^2) 으로는 초과된다. 
2. prices의 요소들 사이의 idx의 차이가 결국 -> 기간을 만들어낸다. 
    1. A가 가격이 하락했다 -> A앞의 B가 A의 하락을 만들었다. 
    2. A,B,C 중에서 A가 C에 의해서 하락했다면, 당연히 B도 C에 의해서 하락한다. 
    -> 직전의 요소가 트리거가 된다는 조건 = Stack을 사용 (pop)
    3. prices를 idx= 1 ~ n-1 까지 순회 
        1. 이번에 push 하려는 값이 peek() 보다 작다면 '하락 트리거'
            1. 하락 트리거 발동시 peek() 요소를 pop()하고 해당 idx에 기간을 명시 
        2. 그렇지 않다면 여전히 지속적인 '상승 유지중' 이기 떄문에 stack에 push 
    4. 반복문을 나왔으나 stack에 값이 여전히 '있다면' (!S.isEmpty())
        1. 지속적인 상승 흐름이므로 pop 하면서 해당 인덱스 자체로 정답에 기록해준다. 
- stack
*/


import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length; //원시형 배열이라 필드가 있다. 
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //prices의 가격은 최소 1이상이므로 1개의 idx를 미리 push 
        
        for(int i=1;i<n;i++){ //prices[i] 를 순회하기 위함이다. 
            //먄약 스택에 요소가 있는데 peek() 보다 현재값이 더 작으면 '하락트리거'
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                //하락트리거 순간에는 pop을 통해서 요소를 제거하고 해당 인덱스와 i를 통해 값을 기록
                int j = stack.pop(); 
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        //반복문을 나왔는데 아직 스택에 요소가 있다면 , 완전한 상승 요소이므로
        //단지 해당 인덱스를 마지막 요소의 인덱스 (n-1) 에서 빼주기만 하면된다.
        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = (n-1) - j;
        }
        
        return answer;
    }
}