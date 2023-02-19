package algorithm;

import java.util.*;
import java.io.*;

class Pos {
	int y;
	int x;
	
	Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	public String toString() {
		return y + " " + x;
	}
}

public class Princess
{
    static Pos[] combo;
    static char[][] princess; 
    static boolean[][] v;
    static boolean[][] vv;
    static int res, m;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		m = s.length();
        
        princess = new char[m][m];
        v = new boolean[m][m];
        combo = new Pos[m*m];
	    
		for(int i=0;i<m;i++) {
		    for(int j=0;j<m;j++) {
		    	combo[m*i+j] = new Pos(i,j);
                princess[i][j] = s.charAt(j);
		    }
            if(i != m-1) s = br.readLine();
		}
		
        dfs(0,0,0); 
 
        System.out.println(res);
	}
	
	static int cy,cx;
	
	public static void dfs(int start, int cnt,int S) {
	    if(cnt == 7) {
	    	if(S >= 4) {
	            vv = new boolean[m][m];
	    		adj(cy,cx);
	    	}
	    	return;
	    }
	  
	    for(int i=start;i<m*m;i++) {
	    	v[combo[i].y][combo[i].x] = true;
	    	
	    	if(cnt == 6) {
	    		cy = combo[i].y;
	    		cx = combo[i].x;
	    	} 
	    	if(princess[combo[i].y][combo[i].x] == 'S') dfs(i+1,cnt+1,S+1);
	    	else dfs(i+1,cnt+1,S);
	    	
	    	v[combo[i].y][combo[i].x] = false;
	    }
	 
	    return;
	}
	
	static int adjCnt=0;
	static final int[] dy = {1,-1,0,0};
	static final int[] dx = {0,0,1,-1};

	public static void adj(int y,int x) {
		adjCnt++; 
		if(adjCnt == 7) res++;
		
		vv[y][x] = true;    
		for(int i=0;i<4;i++) {
		        int ny = y + dy[i];
		        int nx = x + dx[i];
		            
		        if(ny < 0 || nx < 0 || ny >= m || nx >=m || !v[ny][nx] || vv[ny][nx]) continue;
		        adj(ny,nx);
		}
		
		if(cy == y && cx == x) adjCnt = 0;
		return;
	}		

}
