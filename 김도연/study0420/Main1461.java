import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
//음수와 양수로 나누어 받는다
//가장 거리가 먼 책은 가장 나중에 놔둔다 -> 거리 가장 먼것을 맨 나중에 골라야하므로 정렬해야한다
//음수 목록과 양수목록을 m으로 묶고 묶은것 중 가장 거리가 먼것과 출발지점 거리 * 2 가 해당 묶음의 이동비용이다
//이동 비용이 가장 큰 것을 마지막에 가져다 놓기 때문에 해당 묶음만 /2 한다
//묶음을 만들때 먼것부터 묶음을 만들어야 함 그래야 이동거리가 더 짧음
public class Main{
	private static int n;//책의 수
	private static int m;//들수있는 책수 
	private static ArrayList<Integer> bookPosNegative;//책 위치 음수
	private static ArrayList<Integer> bookPosPositive;//책 위치 양수 
	private static int[] distance;//각 묶음들의 최대값의 거리(편도)
	private static int maxDistanceIdx;//최대 거리의 idx
	private static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine=br.readLine().split(" ");
		n=Integer.parseInt(firstLine[0]);
		m=Integer.parseInt(firstLine[1]);
		String[] secondLine=br.readLine().split(" ");
		bookPosNegative=new ArrayList<Integer>();
		bookPosPositive=new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			int val=Integer.parseInt(secondLine[i]);
			if(val<0) {
				bookPosNegative.add(val);
			}else {
				bookPosPositive.add(val);
			}
		}
		Collections.sort(bookPosPositive, Collections.reverseOrder());
		Collections.sort(bookPosNegative);

		int distanceCount=getCount();
		
		distance=new int[distanceCount];
		makeTable();
		getMax();
		getRes();
		
		System.out.println(res);
	}
	
	private static void makeTable() {
		int top=0;
		for(int i=0;i<bookPosNegative.size();i+=m) {
			
				distance[top]=bookPosNegative.get(i);
				top++;
			
		}
		for(int i=0;i<bookPosPositive.size();i+=m) {
			
				distance[top]=bookPosPositive.get(i);
				top++;
			
		}

	}
	
	private static void getMax() {
		int max=0;
		for(int i=0;i<distance.length;i++) {
			if(max<Math.abs(distance[i])) {
				max=Math.abs(distance[i]);
				maxDistanceIdx=i;
			}
		}
	}
	
	private static void getRes() {
		for(int i=0;i<distance.length;i++) {
			if(i==maxDistanceIdx) {
				res+=Math.abs(distance[i]);
			}else {
				res+=Math.abs(distance[i])*2;
			}
		}
	}
	
	private static int getCount() {
		int res=0;
		res+=bookPosNegative.size()/m;
		res+=bookPosPositive.size()/m;
		if(bookPosNegative.size()%m!=0) {
			res++;
		}
		if(bookPosPositive.size()%m!=0) {
			res++;
		}
		return res;
	}
}
