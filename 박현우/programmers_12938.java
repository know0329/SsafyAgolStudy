class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int maximum = s/n;
        int left = s%n;
        
        if(maximum == 0) 
            return new int[]{-1};
        
        for(int i=0;i<n;i++) answer[i] = maximum;
        
        int i = n-1;
        while(left > 0) {
            answer[i--]++;
            left--;
            if(i<0) i = n-1;
        }            

        return answer;
    }
}