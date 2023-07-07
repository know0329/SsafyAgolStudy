package algo;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> map = new HashMap<>();
		int line = Integer.parseInt(br.readLine());
		int[] arr1 = new int[line];
		int answer = 0;
		
		for(int i=0; i<line; i++) {
			map.put(br.readLine(), i);
		}
		for(int i=0; i<line; i++) {
			arr1[i] = map.get(br.readLine());
		}
		
		for(int i=0; i<line-1; i++) {
			for(int j=i+1; j<line; j++) {
				if(arr1[i] > arr1[j]) {
					answer ++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
