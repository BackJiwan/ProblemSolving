import java.io.*;
import java.util.*;

class Solution {
    //1. 좌표범위  TF 판단
    private static boolean isValid(int nx,int ny){
        return nx>=0 && ny>=0 && nx <11 && ny <11;
    }
    
    //2. 좌표 동작을 미리 저장해두는 direction <K,V>
    private static final HashMap<Character,int[]> direction = new HashMap<>();
    //3. 좌표를 미리 넣는 메서드 
    private static void initDirection(){
        direction.put('U',new int[] {0,1});
        direction.put('D', new int[] {0,-1});
        direction.put('R',new int[] {1,0});
        direction.put('L', new int[] {-1,0});
    }
    
    public int solution(String dirs) {
        initDirection(); //direction에 좌표 넣기 
        // x,y 좌표 5,5로 변경 
        int x = 5;
        int y = 5; 
        //중복되지 않도록 set의 형태로 이동 경로 저장
        HashSet<String> result = new HashSet<>();
        //4. 반복문을 통해서 dirs의 char을 하나씩 꺼내서 nx, ny를 계산
        for(int i=0;i<dirs.length();i++){
            //계산된 이동 경로를 왕복으로 result에 추가하기
            //이때 중복방지를 위해서 HashSet으로 관리 
            //음수 좌표를 제거하기 위해서 0,0 -> 5,5로 이동 
            
            
            int[] offset = direction.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            if(!isValid(nx,ny)){
                continue;
            }
            
            result.add(x+" "+y+" "+nx+" "+ny);
            result.add(nx+" "+ny+" "+x+" "+y);
            
            x = nx;
            y = ny;
        }
        return result.size() / 2;
        
        
    }
}