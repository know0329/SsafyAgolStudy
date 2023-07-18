import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[] good;
	static int[] goodNum;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		good = new String[n];
		goodNum = new int[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			good[i] = st.nextToken();
			goodNum[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<m;i++) {
			int cur = Integer.parseInt(br.readLine());
			chk(cur, 0, n);
		}
		System.out.println(sb);
	}
	
	private static void chk(int c, int l, int h) {
		if(l>=h) {
			sb.append(good[l]).append("\n");
			return;
		}
		int mid = (l+h)/2;
		if(c > goodNum[mid]) chk(c,mid+1,h);
		else chk(c,l,mid);
	}
}
