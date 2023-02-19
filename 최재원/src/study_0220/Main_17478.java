package study_0220;

import java.util.Scanner;

public class Main_17478 {
	static int N;
	static String STR = "____";
	static String Line1 = "\"재귀함수가 뭔가요?\"\n";
	static String Line2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	static String Line3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static String Line4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		dfs(0);
		System.out.println(sb);
		sc.close();
		
	}
	
	private static void dfs(int n) {
		String str = "";
		for(int i=0; i<n; i++) {
			str += "____";
		}
		if(n == N) {
			sb.append(str).append(Line1);
			sb.append(str).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(str).append("라고 답변하였지.\n");
			answer(N);
//		} else if(n==0) {
//			sb.append(Line1);
//			sb.append(Line2);
//			sb.append(Line3);
//			sb.append(Line4);
//			dfs(1);
		} else {
			sb.append(str).append(Line1);
			sb.append(str).append(Line2);
			sb.append(str).append(Line3);
			sb.append(str).append(Line4);
			dfs(n+1);
		}
		
	}
	
	private static void answer(int ans) {
		String str1 = "";
		for(int i=ans; i>0; i--) {
			str1 += STR;
		}
		for(int i=0; i<N; i++) {
			str1 = str1.substring(0, str1.length()-4);
			sb.append(str1).append("라고 답변하였지.\n");
		}
	}
}
