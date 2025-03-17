import java.io.*;
import java.util.*;

class Solution {
    //1. 좌표평면을 벗어나면 false를 리턴하는 함수 
    private static boolean isValid(int nx,int ny){
        return 0 <= nx && 0 <= ny && 11 > nx && 11 > ny;
    }
    
    //2. U,D,R,L의 디렉션을 가지고 있는 해시맵 선언 및 초기화
    private static final HashMap<Character, int[]> map = new HashMap<>();
    
    public static void initMap(){
        map.put('U',new int[] {0,1});
        map.put('D',new int[] {0,-1});
        map.put('R',new int[] {1,0});
        map.put('L',new int[] {-1,0});
    }
    
    //3. 솔루션
    public int solution(String dirs) {
        initMap();
        HashSet<String> result = new HashSet<>();
        int answer = 0;
        int x = 5;
        int y = 5;
        for(int i=0;i<dirs.length();i++){
            int nx = x + map.get(dirs.charAt(i))[0];
            int ny = y + map.get(dirs.charAt(i))[1];
            
            if(!isValid(nx,ny)){
                continue;
            }
            
            result.add(x+" "+y+" "+nx+" "+ny+" ");
            result.add(nx+" "+ny+" "+x+" "+y+" ");
            
            x = nx;
            y = ny;
        }
        
        return answer = result.size() / 2;
        
        
        //4. dirs를 하나씩 열어보면서 nx와 ny를 구하기 
        
        //5. 길 = 시작 -> 끝 이므로 x y -> nx ny를 저장하고 반대도 저장 
        
        //6. 저장된 set 타입은 중복이 없으므로 length/2가 정답이다. 
    }
}