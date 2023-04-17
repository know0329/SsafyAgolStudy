package algorithm;

import java.io.*;
import java.util.*;

// integer여야 내림차순 가능(int는 불가능) - Integer로 잡아도 크기 n으로 잡으면 null값때문에 정렬안됨
public class Library {
	static ArrayList<Integer> right; // 오른쪽 책장
	static ArrayList<Integer> left; // 왼쪽 책장
	static int n, m, res, fin;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		right = new ArrayList<>();
		left = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int temp = Integer.parseInt(st.nextToken());
			fin = Math.abs(temp) > Math.abs(fin) ? temp : fin;
			if(temp > 0) right.add(temp);
			else left.add(temp);
		}
		
		// 정렬
		Collections.sort(right);
		Collections.sort(left,Comparator.reverseOrder());

		// 크기
		int rpos=right.size(), lpos=left.size();
		
		// 절대값이 제일 큰 값을 마지막에 갈거임(돌아오는 경우를 제거)
		if(fin > 0) {
			res += fin;
			rpos -= m;
		} else {
			res -= fin;
			lpos -= m;
		}

		// 오른쪽 남은 책장 채우기
		while(rpos > 0) {
			res += 2*right.get(rpos-1);
			rpos -= m;
		}		
		// 왼쪽 남은 책장 채우기
		while(lpos > 0) {
			res -= 2*left.get(lpos-1);
			lpos -= m;
		}
		
		System.out.println(res);
	}
}

