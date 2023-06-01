import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,Integer.MAX_VALUE};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap();
        int insertNum = 0, deleteNum = 0;
        
        
        for(String op : operations) {
            String[] nxt = op.split(" ");
            if(nxt[0].equals("I")) {
                maxHeap.add(Integer.parseInt(nxt[1]));
                minHeap.add(Integer.parseInt(nxt[1]));
                insertNum++;
            } else {
                if(nxt[1].equals("1")) {
                    if(!maxHeap.isEmpty()) {
                        deleteNum++;
                        maxHeap.poll();
                    }
                }
                else{
                    if(!minHeap.isEmpty()) {
                        minHeap.poll();
                        deleteNum++;
                    }
                } 
            }
            // 삭제, 삽입 횟수가 같으면 빈 힙으로
            if(deleteNum == insertNum) {
                maxHeap.clear(); 
                minHeap.clear();
            }
        }
        
        while(!maxHeap.isEmpty()) {
            int cur = maxHeap.poll();
            map.put(cur,cur);
        }
        // 둘이 공통으로 들어와야 진짜로 삭제되지 않고 남아있는 값임
        while(!minHeap.isEmpty()) {
            int cur = minHeap.poll();
            if(map.get(cur) != null) {
                answer[0] = Math.max(answer[0],map.get(cur));
                answer[1] = Math.min(answer[1],map.get(cur));
            } 
        }
        
        if(answer[1] == Integer.MAX_VALUE) answer[1] = 0;
        
        return answer;
    }
}