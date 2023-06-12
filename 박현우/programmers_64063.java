import java.util.*;
import java.io.*;

class Solution {
    HashMap<Long,Long> room = new HashMap();
    long[] answer;
    public long[] solution(long k, long[] room_number) {
        int loop = room_number.length;
        
        answer = new long[loop];
        
        for(int i=0;i<loop;i++) {
            Long cRoom = room_number[i];
            Long cur = room.get(cRoom);
            // 처음 선택한 방이면 바로 해당 방을 배정
            if(cur == null) {
                room.put(cRoom,cRoom + 1l);
                answer[i] = cRoom;
            }
            // 이미 선택된 방이면 부모 방을 배정해야한다.
            else {
                // 부모 방을 확인
                Long nRoom = cur;
                Long n_cur = room.get(nRoom);
                
                // 부모 방도 차있으면
                while(n_cur != null) {
                    // 자식 방의 다음 방을 부모 방의 부모 방으로 변경
                    room.put(cRoom, n_cur);
                    cRoom = nRoom;
                    nRoom = n_cur;
                    n_cur = room.get(nRoom);
                }         
                
                // 부모 방이 비어 있으면
                room.put(nRoom,nRoom + 1l);
                
                answer[i] = nRoom;
            }
        }
        return answer;
    }
}