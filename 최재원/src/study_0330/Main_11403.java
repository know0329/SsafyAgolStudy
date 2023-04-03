package study_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403 {
//	(0,3), (1,6), (3,4), (3,5), (4,0), (5,6), (6,2)
//	0->3->4->0
//	0->3->5->6->2
//	1->6->2
	static int N;
	static int[][] arr;
	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// i에서 j까지 갈 수 있는가?
        // i에서 k로 가고, k에서 j로 갈 수 있는가?
        // 위에 2개의 질문은 동일함.
        for (int k = 0; k < N; k++) 
            for (int i = 0; i < N; i++) 
                for (int j = 0; j < N; j++) 
                	// 단순히 갈 수 있는 경로가 있는지만 체크
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
//                        System.out.println(k+ "에서 겹쳐, " +i + ", " + j + " 칠함");
                    }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) 
        		sb.append(arr[i][j] + " ");
        	sb.append("\n");
        }
		System.out.println(sb);
	}
}
