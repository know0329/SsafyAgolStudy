import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
    static ArrayList<Integer>[] org;
    static int[][] res;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        org = new ArrayList[n];
        res = new int[n][n];
        
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	org[i] = new ArrayList();
        	for(int j=0;j<n;j++) {
        		int temp = Integer.parseInt(st.nextToken());
        		if(temp == 1) org[i].add(j);
        	}
        }      
        
        for(int i=0;i<n;i++) f(i,i);

        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		System.out.print(res[i][j] + " ");
        	}
        	System.out.println();
        }
    }
    
    private static void f(int st, int cur) {
    	for(int e : org[cur]) {
        	if(res[st][e] == 1) continue;
        	res[st][e] = 1;
        	f(st, e);
    	}
    }
}