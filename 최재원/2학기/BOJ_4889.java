package algo;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4889 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st;
		int caseNum = 1;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			// "-"가 나오는 마지막 줄이면 break;
			if(str.contains("-")) break;
			else {
				st = new Stack<>();
				for(int i=0; i<str.length(); i++) {
					char temp = str.charAt(i);
					// stack 비어있으면 그냥 삽입 후 continue;
					if(st.isEmpty()) {
						st.add(temp);
						continue;
					}
					// 비어있지 않으면, peek해서 비교 후 add() or pop().
					if(st.peek()=='{' && temp=='}') {
						st.pop();
						continue;
					}else {
						st.add(str.charAt(i));
					}
				}
				
				if(st.isEmpty()) {
					sb.append(caseNum + ". 0\n");
				}else {
					int leftCnt = 0;
					int rightCnt = 0;
					while(true) {
						if(st.isEmpty()) break;
						char temp = st.pop();
						if(temp == '{') leftCnt++;
						else if(temp == '}') rightCnt++;
					}
					
					int resultCnt = leftCnt/2 + leftCnt%2;
					resultCnt += rightCnt/2 + rightCnt%2;
					
					sb.append(caseNum + ". " + resultCnt + "\n");
				}
			}
			caseNum++;
		}
		System.out.println(sb);
	}
}
