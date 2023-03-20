import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1799{
	private static int n;
	private static int blackMax;
	private static int whiteMax;
	private static ArrayList<int[]> blackPos;//비숍이 들어갈수있는 위치 중 검은 칸
	private static ArrayList<int[]> whitePos;//비숍이 들어갈수있는 위치 중 흰 칸
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		blackPos=new ArrayList<int[]>();
		whitePos=new ArrayList<int[]>();
		
		for(int i=0;i<n;i++) {
			String[] line=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				int num=Integer.parseInt(line[j]);
				if(num==1) {
					if((i+j)%2==0) {
						blackPos.add(new int[] {i,j});
					}else {
						whitePos.add(new int[] {i,j});
					}
				}
					
			}
		}

		getRes(0, new boolean[whitePos.size()], 0, true, whitePos);
		getRes(0, new boolean[blackPos.size()], 0, false, blackPos);
		System.out.println(whiteMax+blackMax);
	}
	
	public static void getRes(int count, boolean[] pick, int bishopCount, boolean isWhite, ArrayList<int[]> pos) {
		if(isWhite==true && count==pos.size()) {
			if(bishopCount>whiteMax) {
				whiteMax=bishopCount;
			}
		}else if(isWhite==false && count==pos.size()){
			if(bishopCount>blackMax) {
				blackMax=bishopCount;
			}
		}else {
			int row=pos.get(count)[0];
			int col=pos.get(count)[1];
			if(check(pick, count, row, col, pos)==true) {
				pick[count]=true;
				getRes(count+1, pick, bishopCount+1, isWhite, pos);
			}
			pick[count]=false;
			getRes(count+1, pick, bishopCount, isWhite, pos);
		}
	}

	public static boolean check(boolean[] pick, int count, int row, int col, ArrayList<int[]> pos) {//조건에 부합하는지 확인한다
		for(int i=0;i<count;i++) {
			if(pick[i]==false)//pick되지 않았다면 넘어간다
				continue;
			int nowRow=pos.get(i)[0];
			int nowCol=pos.get(i)[1];
			if(Math.abs(nowRow-row)==Math.abs(nowCol-col)) {
				return false;
			}
		}
		
		return true;
	}
	

}