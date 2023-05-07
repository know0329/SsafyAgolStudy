package study_0501;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 2548번 대표 자연수
public class Main_2548 {
	static int N, result, resultNum;
	static int[] arr;
	static HashSet<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = Integer.MAX_VALUE;
		resultNum = 0;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		set = new HashSet<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		
//		for (int a : arr) set.add(a);
//		for (int num : set) {
//			int sum = 0;
//			for(int i=0; i<N; i++) 
//				sum += Math.abs(arr[i] - num);
//			if(sum < result) {
//				result = sum;
//				resultNum = num;
//			}
//		}
		
		if(arr.length == 1) resultNum = arr[0];
		else if(arr.length%2 == 0) resultNum = arr[arr.length/2 - 1];
		else resultNum = arr[arr.length/2 + 1];
		
		System.out.println(resultNum);
	}
}
