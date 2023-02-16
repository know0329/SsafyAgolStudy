package backjoon;

import java.util.*;
import java.io.*;
import java.util.Set;

public class B1941
{
	
	static int [][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int result;
	static char [][] arr;
	static int [] xArr;
	static int [] yArr;
	//참고한 곳에서는 combination 함수의 매개변수에 left라는 변수가 하나 더 있었는데  left라는 역할이 그냥 7개를 골랐는지 체크하는 용도였음
	// => 그런데 index값 또한 이를 체크할 수 있기에 불필요한 변수는 제거했음 
	static void combination(int [] newArr, int index , int num) {
		if(index == 7) { // 7명을 선정하였다
			bfs(newArr);
			return;
		}
		if(num == 25) { // 25명을 모두 확인했다
			return;
		}
		newArr[index] = num;
		combination(newArr, index+1, num+1);
		combination(newArr, index, num+1); // index가 변하지 않으면 newArr[index] = num에 의해  index가 변할 때 까지 값이 교체됨
	}
	static void bfs(int [] newArr) { //내가 뽑은 사람들의 배열이 연결된 것인지 확인하는 용도
		Queue<Integer> q = new LinkedList<>();
		boolean [] visited = new boolean[7];
		
		visited[0] = true; // 시작부분 체크
		q.add(newArr[0]);
		int cnt = 1, sCnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll(); 
			if(arr[xArr[cur]][yArr[cur]] == 'S') sCnt++; //이다솜 파이면 이다솜 파 인원수 ++
			
			for(int i = 0; i < 4; i++) { // 방향 벡터 루프문
				for(int next=1; next < 7; next++) {
					// 확인한 적이 없다 && 현재 수의 X, Y좌표에 방향벡터를 각각 더해서 좌표이동한 값이 다음에 확인할 사람의 좌표와 일치하는가? 
					if(!visited[next] && xArr[cur]+dir[i][0] == xArr[newArr[next]] && yArr[cur]+dir[i][1] == yArr[newArr[next]]) {
                        visited[next] = true; 
                        q.add(newArr[next]); // 일치한다면 연결되어있으므로 이다솜파인지 임도연 파인지 체크할 항목에 넣음
                        cnt++; 
                    }
				}
			}
		}
		if(cnt == 7) { // 7명 모두 연결되어 있다
            if(sCnt >=4) { // 이다솜파가 더 많다
                result++;
            }
        }
		
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new char[5][5];
        String name = st.nextToken();
        for(int i = 0; i < 5; i++){
            arr[0][i] = name.charAt(i);
        }
        for(int i = 1; i < 5; i++){
        	st = new StringTokenizer(br.readLine());
        	name = st.nextToken();
            for(int j = 0; j < 5; j++){
            	
                arr[i][j] = name.charAt(j);
            }
        }
        xArr = new int[25];
        yArr = new int[25];
        for(int i = 0; i < 25; i++) {
        	xArr[i] = i % 5;
        	yArr[i] = i / 5;
        }
        combination(new int[7], 0, 0);
        System.out.println(result);
    }
}