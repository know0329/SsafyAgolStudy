package study_0302;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_2628 {
	
	static List<Integer> garo = new ArrayList<Integer>();
	static List<Integer> sero = new ArrayList<Integer>();
	static List<Integer> array = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();
		int S = sc.nextInt();
		
		garo.add(0);
		sero.add(0);
		
		int N = sc.nextInt();
		for(int n=0; n<N; n++) {
			int g = sc.nextInt();
			int s = sc.nextInt();
			
			if(g == 0) garo.add(s);
			if(g == 1) sero.add(s);
		}
		
		garo.add(S);
		sero.add(G);
		
		Collections.sort(garo);
		Collections.sort(sero);
		
		for(int i=1; i<garo.size(); i++) {
			int now_garo = garo.get(i) - garo.get(i-1);
			
			for(int j=1; j<sero.size(); j++) {
				int now_sero = sero.get(j) - sero.get(j-1);
				int result = now_garo * now_sero;
				array.add(result);
			}
		}
		
		Collections.sort(array);
		System.out.println(array.get(array.size()-1));
		
		sc.close();
	}
}
