package study_0501;

import java.util.*;
import java.io.*;

public class Main_2015 {
	
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		long result = 0;
		long cnt = 0;
		
		for(int i=1; i<N+1; i++) {
			if(arr[i] == K) result++;
			
			if(map.containsKey(arr[i]-K)) 
				cnt = map.get(arr[i]-K);
			else 
				cnt = 0;
			
			result += cnt;
			
			if(map.containsKey(arr[i])) 
				map.put(arr[i], map.get(arr[i]) + 1);
			else 
				map.put(arr[i], 1);
		}
		
		System.out.println(result);
	}
}
