package algorithm;

import java.io.*;
import java.util.*;

public class Main9935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static String n,bomb, res="FRULA";
	static Stack<Character> s = new Stack<>();
	static Stack<Character> e = new Stack<>();
	public static void main(String[] args) throws IOException {
		n = br.readLine();
		bomb = br.readLine();
		Character trigger = bomb.charAt(bomb.length()-1);
		for(int i=0;i<n.length();i++) {
			s.add(n.charAt(i));
			if(n.charAt(i) == trigger) {
				int cnt = bomb.length()-1;
				
				while(!s.isEmpty() && cnt >= 0) {
					Character t = s.pop();
					e.add(t);
					if(t != bomb.charAt(cnt)) break;
					cnt--;
				}
				if(cnt == -1) e.clear();
				else {
					while(!e.isEmpty()) s.add(e.pop());
				}
			}
		}
		
		while(!s.isEmpty()) sb.append(s.pop());
		if(sb.toString().compareTo("") == 0) System.out.println(res);
		else System.out.println(sb.reverse());
	}

}