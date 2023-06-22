class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int loop = cookie.length;
        
        for(int i=0;i<loop-1;i++) {
            int left = i;
            int right = i+1;
            
            int lSum = cookie[left];
            int rSum = cookie[right];
            
            while(left >= 0 && right < loop) {
                try {
                    if (lSum == rSum) {
                        answer = Math.max(answer, lSum);
                        lSum += cookie[--left];
                        rSum += cookie[++right];
                    } 
                    else if (lSum < rSum) lSum += cookie[--left];
                    else rSum += cookie[++right];                    
                } catch (ArrayIndexOutOfBoundsException e) {break;}
            }
        }        
        return answer;
    }
}

//  효율성 실패
//         int answer = 0;
//         int loop = cookie.length;
//         int[] acc = new int[loop+2];
        
//         acc[0] = 0;
        
//         // 누적합
//         for(int i=1;i<=loop;i++) acc[i] = acc[i-1] + cookie[i-1];
        
//         acc[loop+1] = acc[loop];
        
//         for(int l=1;l<loop;l++) {
//             for(int r=l+1;r<=loop;r++) {
//                 for(int m=l;m<r;m++) {
//                     if(acc[m] - acc[l-1] == acc[r] - acc[m]) 
//                         answer = Math.max(acc[m] - acc[l-1],answer);
//                 }
//             }
//         }