class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //int[][] answer = {};
        
        //행렬 정보 저장
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        
        //곱셈 결과 크기는 int[r1][c2];
        //결과 행렬 정의 
        int[][] answer = new int[r1][c2];
        
        //r1, c2 이중 반복문 돌기 
        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                for(int k=0;k<r2;k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        //반복 경우마다 1~ (c1=r2) 횟수만큼 arr1 * arr2 를 누적합 
        
        return answer;
    }
}