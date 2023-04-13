
public class test {
	public static void main(String[] args) {
		int n = 100;
		int m = 300;
		int result = 0;
		for(int i=n; i<=m; i++) {
			boolean flag = true;
			String str = Integer.toString(i);
			int[] arr = new int[str.length()];
			for(int j=0; j<str.length(); j++) {
				arr[j] = str.charAt(j) - '0';
			}

			for(int j=0; j<str.length()/2; j++) {
				if(arr[j] == arr[str.length()-1-j]) 
					continue;
				else {
					flag = false;
					break;
				}
			}
			
			if(flag == true) result++;
		}
		System.out.println(result);
	}
}
