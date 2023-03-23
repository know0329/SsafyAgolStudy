import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9527{
	public static long a, b;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] line=br.readLine().split(" ");
		a=Long.parseLong(line[0]);
		b=Long.parseLong(line[1]);
		System.out.println(getCount(b)-getCount(a-1));//a의 1의 개수가 포함되어야 하므로 -1
	}
	public static long getCount(long a) {
		if(a==0||a==1)
			return a;
		int digits=0;
		long powOf2=1;
		while(powOf2*2<=a) {//a가 2의 몇제곱보다 큰지 알아냄
			powOf2*=2;
			digits++;
		}
		long numCount=digits*powOf2/2;//이 숫자보다 작은 2제곱수 중에서 가장 큰애까지의 1 개수
		long firstCount=a-(powOf2-1);//남은 수들의 맨 앞의 1 개수를 구한다
		//맨 앞 1들은 처리했으니 그 뒤의것만 보면 된다 맨앞 1을 떼기위해서는 powOf2를 a에서 빼면된다
		return numCount+firstCount+getCount(a-powOf2);
	}

}