import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main15666 {
	private static int n;
	private static int m;
	private static ArrayList<Integer> numbers;
	private static StringBuffer sb;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine=br.readLine().split(" ");
		String[] secondLine=br.readLine().split(" ");
		n=Integer.parseInt(firstLine[0]);
		m=Integer.parseInt(firstLine[1]);
		numbers=new ArrayList<Integer>();
		sb=new StringBuffer();
		
		Set<Integer> set=new HashSet<Integer>();
		
		for(int i=0;i<secondLine.length;i++) {
			set.add(Integer.parseInt(secondLine[i]));
		}
		
		for(Integer i:set) {
			numbers.add(i);
		}
		Collections.sort(numbers);
		
		getRes(0, new Integer[m], 0);
		System.out.println(sb);
	}
	
	public static void getRes(int count, Integer[] picked, int start) {
		if(count==m) {
			for(int i=0;i<picked.length;i++) {
				sb.append(picked[i]+" ");
			}
			sb.append("\n");
			
		}else {
			for(int i=start;i<numbers.size();i++){
				//순서를 고려하지 않고 선택하므로 start를 통해 이전 것을 보지 않는다
				//하지만 같은 수를 또 고를 수 있도록 해야하므로 start를 i+1이 아닌 i로 보낸다
				picked[count]=numbers.get(i);
				getRes(count+1, picked, i);
			}
		}
	}

}