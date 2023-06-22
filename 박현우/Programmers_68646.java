import java.util.*;
import java.io.*;

// 가운데 껴 있는 게 제일 크면 생존 불가능. (3개만 남았을 경우)
// -> 즉 가운데 원소 좌/우로 더 큰 원소가 1개이상 있어야함 (이 때 최소값을 찾았을때 더 커야함)
class Solution {
    public int solution(int[] a) {
        // 처음 시작 원소, 끝 원소는 무조건 살 수 있다.
        int loop = a.length;
        int answer = 2;
        
        int[] right = new int[loop];
        int[] left = new int[loop];
        
        left[0] = a[0];
        right[loop-1] = a[loop-1];
        
        // 나보다 왼쪽에 있는 원소 중 가장 작은 값
        for(int i=1;i<loop;i++) left[i] = Math.min(left[i-1], a[i-1]);
        
        // 나보다 오른쪽에 있는 원소 중 가장 작은 값
        for(int i=loop-2;i>=0;i--) right[i] = Math.min(right[i+1], a[i+1]);
        
        for(int i=1;i<loop-1;i++) {
            // 3개 원소 중 가장 큰 값이면 생존 불가
            if(a[i] > left[i] && a[i] > right[i]) continue;
            answer++;
        }
        if(loop == 1) return 1;
        if(loop == 2) return 2;
        return answer;
    }
}