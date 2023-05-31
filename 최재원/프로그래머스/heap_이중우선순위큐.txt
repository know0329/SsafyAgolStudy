import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();                              // 최대값 담을 큐
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());    // 최소값 담을 큐
        // 로직 구현
        for(int i=0; i<operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String tempOper = st.nextToken();
            int tempNum = Integer.parseInt(st.nextToken());
            // System.out.println(tempOper);
            // System.out.println(tempNum);
            
            // I일 때
            if(tempOper.equals("I")){
                // 큐에 삽입
                queue1.add(tempNum);
                queue2.add(tempNum);
            } else{
                // 큐 비어있으면 continue
                if(queue1.isEmpty()) continue;
                
                // D 1일 때, 최대값 삭제.
                if(tempNum == 1){
                    int tempMax = queue2.poll();
                    queue1.remove(tempMax);
                }
                // D -1일 때, 최소값 삭제.
                else{
                    int tempMin = queue1.poll();
                    queue2.remove(tempMin);
                }
            }
        }
        
        // System.out.println(queue.toString());
        // System.out.println(queue.peek());
        // System.out.println(queue.poll());
        // System.out.println(queue.toString());

        int[] answer = new int[2];
        if(queue1.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0] = queue2.poll();
            answer[1] = queue1.poll();
        }
        return answer;
    }
}