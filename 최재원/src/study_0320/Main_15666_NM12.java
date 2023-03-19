package study_0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_15666_NM12 {
	
	static int N, M;
	static int[] input, output;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		output = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			input[i] = Integer.parseInt(st.nextToken());
		// 입력 배열 정렬
		Arrays.sort(input);
		// dfs
		solve(0,0);
		System.out.println(sb);
		
	}
	static HashSet<String> set = new HashSet<String>();
	static void solve(int depth, int start) {
		// depth가 M이면, output 배열을 string으로 뽑아
		// hashset에 중복 없으면 넣어주고 sb(StringBuilder)에도 넣어줌.
		// 이때 오름차순으로 출력하기 위해, before를 만들어 output의 다음 요소와 비교.
		if(depth == M) {
			String str = "";
			int before = -1;
			for(int i=0; i<M; i++) {
				if(before > output[i]) return;
				else before = output[i];
				str += output[i];
				str += " ";
			}
			if(set.contains(str)) return;
			else {
				set.add(str);
				sb.append(str).append("\n");
			}
			return;
		}
		// depth가 M이 아니면, dfs. visited 등 필요 없음.
		for(int i=start; i<N; i++) {
			output[depth] = input[i];
			solve(depth+1,i);
		}
	}
}
