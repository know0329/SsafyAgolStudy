import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        
        long total_time = 0;
        
        // k 이후 남은 food 없을 때.
        for(int i=0; i<food_times.length; i++)
            total_time += food_times[i];
        if(total_time <= k)
            return -1;
        
        // 남은 음식들을 처리하기 위한 우선순위 큐 생성
        // fTimes 값에 따라 우선순위 결정
        PriorityQueue<Food> queue = new PriorityQueue<>((a, b) -> a.fTimes - b.fTimes);
        for (int i = 0; i < food_times.length; i++) {
            queue.add(new Food(i, food_times[i]));
        }
        
        // 현재 사이클에서 처리된 음식의 시간
        int cycle = 0;
        // 현재까지 소요된 시간
        long time = 0;
        
        // 가장 우선순위가 높은 음식을 큐에서 꺼내서 처리하고, 소요된 시간과 사이클을 갱신
        // while : (현재 사이클에서 모든 음식을 처리하는데 소요되는 시간) >= (남은 시간)
        while ((queue.peek().fTimes - cycle) * (long) queue.size() <= (k - time)) {
            int foodsCnt = queue.size();
            Food food = queue.poll();
            time += (food.fTimes - cycle) * (long) foodsCnt;
            cycle = food.fTimes;
        }
        
        // 남은 음식들을 리스트로 변환하여 정렬
        ArrayList<Food> list = new ArrayList<>(queue);
        list.sort((a, b) -> a.index - b.index);
        
        long remain = k - time; // 남은 시간
        int index = (int) (remain % list.size()); // 처리될 음식의 인덱스
 
        // 처리될 음식의 인덱스 반환
        return list.get(index).index + 1; 
    }
    
    class Food {
        int index;
        int fTimes;
 
        public Food(int index, int fTimes) {
            this.index = index;
            this.fTimes = fTimes;
        }
    }
}