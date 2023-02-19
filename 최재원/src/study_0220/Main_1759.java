package study_0220;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// char 배열로 -> nullpointer runtime error
// -> 메모리 초과

public class Main_1759 {
	
	static int L, C;
	static StringBuffer sb = new StringBuffer();

	static String[] arr2;
	static String[] result2;
	static String[] visited;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		result2 = new String[L];
		arr2 = new String[C];
		visited = new String[C];
		
		for(int i=0; i<C; i++) {
			arr2[i] = sc.next();
//			System.out.println(arr2[i]);
		}
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		str = str.replace(" ", "");
//		arr = new char[C];
//		result = new char[L];
//		for(int i=0; i<C; i++) {
//			arr[i] = str.charAt(i);
//		}
		
		// 입력받은 문자열 정렬.
//		Arrays.sort(arr);
		Arrays.sort(arr2);
		
		dfs(0);
		
		System.out.println(sb);
		
		sc.close();
		
	}
	
	private static void dfs(int depth) {
		if(depth == L) {
			// 조건(정렬, 중복X, 자음&모음 개수) 체크 후 출력
			if(checkArr()) {
				for(int k=0; k<result2.length; k++) {
					sb.append(result2[k]);
				}
				sb.append("\n");
			}
			return;
		}
//		for(int i=0; i<C; i++) {
//			result[depth] = arr[i];
//			dfs(depth+1);
//		}
		for(int i=0; i<C; i++) {
			result2[depth] = arr2[i];
			dfs(depth+1);
		}
	}
	
	private static boolean checkArr() {
		// 모음 & 자음 개수
		int mo = 0;
		int za = 0;
		
		// 중복 확인
//		visited[0] = result2[0];
		List<String> strList = new ArrayList<>(Arrays.asList(visited));
		String before = result2[0];
		// 중복 및 정렬 확인에 사용할 stack
//		Stack<String> before = new Stack<>();
//		before.push(result2[0]);
		for(int i=0; i<L; i++) {
			// 중복 문자 제거
			String now = result2[i];
			if(i>0) {
				if(strList.contains(now)) {
					return false;
				}
				if(before.charAt(0) >= now.charAt(0)) {
					return false;
				}
				strList.add(now);
				before = now;
			}
			
//			if(i>0) {
//				String now = result2[i];
//				
//				// 스택의 top <-> now 확인
//				if(before.contains(now)) {
//					return false;
//				}else if(now.charAt(0) <= before.peek().charAt(0)) {
//					return false;
//				}
//				else {
//					before.push(now);
//				}
			
			
			// 모음 & 자음 개수 확인
			if(now.equals("a") || now.equals("e") || result2[i].equals("i")
					|| result2[i].equals("o") || result2[i].equals("u")) 
				mo++;
			else za++;
		}
		
//		before.clear();
		if(mo < 1 || za < 2) {
			return false;
		}else {
			return true;
		}
	}
}
