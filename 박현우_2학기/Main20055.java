import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean possible = true;
		
		int[] belt = new int[2*n];	
		boolean[] isRobot = new boolean[2*n];
		Queue<Integer> robot = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*n;i++)
			belt[i] = Integer.parseInt(st.nextToken());

		int up = 0; // 1 올리는 위치
		int down = n-1; // n 내리는 위치
		int cycle = 0;
		
		while(possible) {
			cycle++;
			
			// 벨트 회전 - 이전 칸이 다음 위치로
			up = (up == 0) ? 2*n - 1: up-1;
			down = (down == 0) ? 2*n - 1 : down-1;
			
			int rSize = robot.size();
			// 벨트 회전에 따른 로봇 idx 이동
			for(int i=0;i<rSize;i++) {
				int cur = robot.poll();
				// 내리는 위치면 내리고 다시 넣지 않는다.
				if(cur == down) {
					isRobot[cur] = false;
					continue;
				}
				// 내리는 위치가 아니면 다시 넣는다.
				robot.add(cur);
			}
			
			rSize = robot.size();
			// 먼저 올라간 로봇 부터 이동
			for(int i=0;i<rSize;i++) {
				int cur = robot.poll();
				int next = (cur+1)%(2*n);

				// 다음 위치에 로봇있거나 내구도가 0이면 이동x 없으면 이동
				if(isRobot[next] || belt[next] <= 0) robot.add(cur);
				else {
					isRobot[cur] = false;
					belt[next]--; // 내구도 감소
					// 다음 위치가 내리는 위치면 내리고 다시 넣지 않는다.
					if(next == down) continue;
					
					robot.add(next);
					isRobot[next] = true;
				}
			}
			
			// up 내구도 1감소 시키고 로봇 올리기
			if(belt[up]-- > 0 && !isRobot[up]) {
				robot.add(up);
				isRobot[up] = true;
			}
           
			possible = chk(belt, n, k);
		}
		
		System.out.println(cycle);
	}
	
	private static boolean chk(int[] belt, int n, int k) {
		int temp = 0;
		for(int i=0;i<2*n;i++)
			if(belt[i] <= 0) temp++; 
		return temp < k;
	}
}