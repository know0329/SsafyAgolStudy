package Test;
import java.util.*;
public class B2002 {

	static class Car{
		int idx;
		String name;
		
		Car(int i, String n){
			this.idx = i;
			this.name = n;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		Queue<Car> que = new LinkedList<>();
		
		int count = 0;
		int index = 0;
		int N = scn.nextInt();
		String [] arr = new String[N];
		boolean [] visited = new boolean[N];
		N = N*2;
		
		for(int i = 0; i < N/2; i ++) {
			String str = scn.next();
			arr[i] = str;
		}
		// 나오는 차량의 들어간 순서대로 번호 매기기
		for(int i = 0; i < N/2; i ++) {
			String str = scn.next();
			for(int j = 0; j < N/2; j++) {
				if(arr[j].equals(str)) {
					que.add(new Car(j, str));
					break;
				}
			}
			
		}
		
		while(!que.isEmpty() && index < N/2) {
			Car pollCar = que.poll();
			visited[pollCar.idx] = true; // 확인한 차량 true 변경
			if(index == pollCar.idx) { // 순서와 일치하는 차량이 발견된 경우
				for(int i = 0; i < N/2; i++) {
					if(!visited[i]) { // 체크하지 않은 차량 중 가장 먼저 들어간 순서로 변경
						index = i;
						break;
					}
				}
			}
			else { // 다른 차량을 초월했을 경우 count++
				
				count++;
			}
		}
		System.out.println(count);

	}

}
