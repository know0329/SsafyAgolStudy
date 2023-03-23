import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2293 {
	private static int n;
	private static int k;
	private static int[] coins;
	private static int[] dp;//인덱스: 만들 숫자, 값: 경우의 수
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] line=br.readLine().split(" ");
		n=Integer.parseInt(line[0]);
		k=Integer.parseInt(line[1]);
		dp=new int[k+1];
		coins=new int[n];
		for(int i=0;i<n;i++) {
			coins[i]=Integer.parseInt(br.readLine());
		}
		getTable();
		System.out.println(dp[k]);
		
	}
	public static void getTable() {
		dp[0]=1;
		for(int i=0;i<n;i++) {
			for(int j=coins[i];j<=k;j++) {
				dp[j]=dp[j]+dp[j-coins[i]];
			}
		}
	}
}