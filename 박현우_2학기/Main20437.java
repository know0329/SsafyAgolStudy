import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer>[] alpha = new ArrayList[26];
	public static void main(String[] args) throws IOException {
		int loop = Integer.parseInt(br.readLine());
		
		for(int tcase=0;tcase<loop;tcase++) {
			int maximum = -1;
			int minimum = 99999;
			
			String cur = br.readLine();
			int k = Integer.parseInt(br.readLine());
			int e = cur.length();
			
			for(int i=0;i<26;i++) alpha[i] = new ArrayList<>();
			for(int i=0;i<e;i++) alpha[cur.charAt(i)-'a'].add(i);
			
			for(int i=0;i<26;i++) {
				int fin = alpha[i].size();
				if(fin < k) continue;
				int s = 0;
				while(s+k <= fin) {
					minimum = Math.min(minimum, alpha[i].get(s+k-1) - alpha[i].get(s) + 1);
					maximum = Math.max(maximum, alpha[i].get(s+k-1) - alpha[i].get(s) + 1);
					s++;
				}
			}
			
			if(maximum == -1 || minimum == 99999) System.out.println(-1);
			else System.out.println(minimum + " " + maximum);
		}
	}
}