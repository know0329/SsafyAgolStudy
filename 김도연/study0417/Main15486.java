import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//시간초과, DP로 풀어야 한다
public class Main15486 {
	private static int date;
	private static Consulting[] reservation;
	private static int maxGain;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		date=Integer.parseInt(br.readLine());
		reservation=new Consulting[date];
		
		for(int i=0;i<date;i++) {
			String[] line=br.readLine().split(" ");
			reservation[i]=new Consulting(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
		}
		getRes(0, 0);
		System.out.println(maxGain);
	}
	public static void getRes(int count, int gain) {
		if(count>=date) {
			if(gain>maxGain) {
				maxGain=gain;
			}
		}else {
			int nextDays=reservation[count].date;
			if(count+nextDays<=date) {
				int sum=0;
				for(int i=count;i<date;i++) {
					sum+=reservation[i].gain;
				}
				if(gain+sum>maxGain) {
					getRes(count+nextDays, gain+reservation[count].gain);
				}
			}
			getRes(count+1, gain);
		}
	}

}
class Consulting{
	int date;
	int gain;
	public Consulting(int date, int gain) {
		this.date=date;
		this.gain=gain;
	}
}

