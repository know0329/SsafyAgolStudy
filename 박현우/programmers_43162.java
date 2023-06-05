import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] v = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!v[i]) {
                answer++;
                f(i,v,n, computers);
            }
        }
        return answer;
    }
    private static void f(int st, boolean[] vv,int nn, int[][] c) {
        if(vv[st]) return;
        vv[st] = true;
        for(int i=0;i<nn;i++) {
            if(i==st) continue;
            if(c[st][i] == 1 && !vv[i]) f(i, vv, nn, c);
        }
    }
}