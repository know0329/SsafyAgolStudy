package Test;
import java.util.*;
public class B4889 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
	
		String input = "";
		int index = 1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			Stack<Character> st = new Stack();
			input = scn.next();	
			if(input.contains("-")) {
				break;
			}
			int count = 0;
			
			for(int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if(st.isEmpty()) {
					st.push(ch);
				}
				else {
					if(st.peek() == '{' && ch == '}') { // 완성된 괄호 제거
						st.pop();  
					}
					else {
						st.push(ch);
					}
				}
				
			}
	
			for(int i = 0; i <= st.size()-2;) {
				
				
				char ch = st.get(i);
				char ch2 = st.get(i+1);
				if(ch == ch2) { // 같은 문자가 연속되어 있으면 하나만 뒤집으면 됨
					count++;
				}
				else { // 괄호가 뒤집혀 있으면 둘다 뒤접어야 됨
					count += 2;
				}
				i+=2;
			}
			
			sb.append(index);
			sb.append(".");
			sb.append(" ");
			sb.append(count);
			sb.append("\n");
			index++;
			
		}
		System.out.print(sb);
		
	}

}
