package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Algo3_구미_6반_최재원 {
	static int T, N, M, C, startX, startY, result;
	static int[][] arr;
	static boolean[][] visited;
	static List<Integer> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// �Է� �迭, �湮 �迭, ������ list, ��� result �ʱ�ȭ.
			arr = new int[N][M];
			visited = new boolean[N][M];
			C = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			result = 0;
			// �Է� �ޱ�
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// �Է°��� 1�� ��, �κ��� ���� ��ġ
					if(arr[i][j] == 1) {
						startX = i;
						startY = j;
					}
					// �Է°��� 1�� �ƴ� �� �� 0�� �ƴϸ� ������ ��ġ.
					else if(arr[i][j] != 0) 
						list.add(arr[i][j]);
				}
			}
			
			// ������ ���� ū ������ �湮�� �� �ִ��� Ȯ���� �����̹Ƿ�, ������������ sort����.
			Collections.sort(list);
			Collections.reverse(list);
			
			// ������ �ֿ췯 ���ٿ��� �Լ�.
			clean();
			sb.append("#" + t + " ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	static void clean() {
		// ������ C�� 0�� ���ų� ������ return
//		if(C <= 0) return;
		for(int i=0; i<list.size(); i++) {
			// ������ ���� ū ������, ���ʷ� �ݺ���
			// �ش� ������ ���� ���� ���� ��ǥ�� Ȯ��
			int[] trash = find(list.get(i));
			if(isOk(trash[0],trash[1]) == 0) continue;
			// �����Ⱑ �ִ� ���� ��ǥ���� �պ��� �Ұ����ϸ� continue, �ƴϸ� else�� ����.
			else {
				// ���� �κ��� �� ���������� �����⸦ �ֿ췯 ���ٿ� �պ� �Ÿ� �������� ���ش�.
				C -= isOk(trash[0],trash[1]);
				// ��������� �ش��ϴ� ��������� �߰�.
				result += list.get(i);
			}
		}
	}
	
	// �κ��� ���� ��ġ���� ������ ��ġ���� �պ� �̵��� �������� Ȯ��
	static int isOk(int x, int y) {
		// ��ǥ ���� �Ÿ� dis�� �����ش�.
		int dis = Math.abs(x-startX) + Math.abs(y-startY);
		// �պ� �Ÿ� dis*2���� ������(C)�� ������ �ش� �Ÿ��� return. 
		// �׷��� ������ 0�� ����.
		if(C >= dis*2) return dis*2;
		else return 0;
	}
	// Ư�� ���� �����⸦ ���� ���� ��ǥ�� ã�� �Լ�
	static int[] find(int c) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == c && visited[i][j]==false) {
					// �ش� ���� �߰��ϸ� i,j�� �������ִµ�, �湮 Ȯ�ε� üũ����.
					visited[i][j] = true;
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
}