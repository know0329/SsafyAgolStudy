package study_0302;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_2559 {
	
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		input = new int[N];
		
		for(int i=0; i<N; i++) input[i] = sc.nextInt();
		
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<=N-K; i++) {
			int sum = 0;
			for(int j=i; j<K+i; j++) {
				sum += input[j];
			}
			result.add(sum);
		}
		Collections.sort(result);
		System.out.println(result.get(result.size()-1));
	}
}
