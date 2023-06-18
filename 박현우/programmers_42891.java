import java.util.*;
import java.awt.*;
import java.io.*;

// k만큼 돌지 말고 k갯수에서 전체 사이즈 만큼 빼고 한 사이클 전부를 -1하기
// n개의 음식이 담긴 접수 갯수를 카운팅 해야할 듯? 0이된 거를 일일이 찾으니 오래걸림
class Solution {
    public int solution(int[] food_times, long k) {
        long left = k;
        int loop = food_times.length;
        HashMap<Integer,Integer> foods = new HashMap<>();
        
        // 음식 갯수 별로 몇개의 접시가 있는지 저장 
        for(int i=0;i<loop;i++) {
            int curFood = food_times[i];
            if (foods.containsKey(curFood)) foods.put(curFood, foods.get(curFood) + 1);
            else foods.put(curFood, 1);
        }
        
        // 현재 사이클 횟수(음식 제거 수)
        int cycle = 0;
        long maximum = (long) loop;
        while(left >= maximum && maximum > 0){
            // 사이클
            cycle++;
            
            // 접시 수 만큼 제거
            left -= maximum;
            
            // 음식이 cycle 만큼 담긴 접시 제거
            if (foods.containsKey(cycle)) maximum -= foods.get(cycle);
        }
        // 크기가 cycle보다 큰 접시들만 고른다. 
        ArrayList<Integer> answers = new ArrayList<>();
        for(int i=0;i<loop;i++) {
            if(food_times[i] > cycle) answers.add(i);
        }
        
        // cycle 보다 큰 접시들 중 시작지점에서 left 만큼 떨어진 접시에서 방송이 멈춤
        if(answers.size() == 0) return -1;
        if(answers.size() == 1) return answers.get(0)+1;
        int answer = answers.get((int)left%answers.size())+1; // 실제 위치는 index+1임
        
        return answer;
    }
}