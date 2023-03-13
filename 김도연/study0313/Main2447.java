import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

////6:2~9:00 다른사람의 풀이를 참고함
public class Main2447{
	private static int n;
	private static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				getRes(i, j, n);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void getRes(int i, int j, int len) {
		if(((i/len)%3)==1 && ((j/len)%3)==1) {
			sb.append(" ");
		}else {
			if(len==1) {
				sb.append("*");
			}else {
				getRes(i, j, len/3);
			}
		}
	}
}