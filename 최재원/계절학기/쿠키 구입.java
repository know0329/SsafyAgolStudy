class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
//         for(int i=0; i<cookie.length-1; i++){
//             int son1 = i;
//             int son2 = i+1;
//             int sum1 = 0;
//             int sum2 = 0;
//             for(int j=0; j<=son1; j++){
//                 sum1 += cookie[j];
//             }
//             for(int j=son2; j<cookie.length; j++){
//                 sum2 += cookie[j];
//             }
//             System.out.println(son1 + " " + son2 + " ");
//             System.out.println(sum1 + " " + sum2);
            
//             if(sum1 == sum2){
//                 answer = Math.max(sum1, answer);
//             }
//         }
        
        for (int i = 0; i < cookie.length-1; i++) {
            int son1 = i;
            int sum1 = cookie[i];
            int son2 = i+1;
            int sum2 = cookie[i+1];
            while (true) {
                if(sum1 == sum2 && answer < sum1) answer = Math.max(answer, sum1);
                else if(sum1 <= sum2 && son1 != 0) sum1 += cookie[--son1];
                else if(sum1 > sum2 && son2 != cookie.length - 1) sum2 += cookie[++son2];
                else break;
            }
        }

        
        return answer;
    }
}