import java.util.*;
public class B2447 {

    static char arr[][];
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        arr = new char[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                star(i,j,N);
            }
        }
        for(int i=0; i<N; i++) {
            System.out.println(arr[i]);
        }

    }
    static void star(int i, int j, int N) {

        if((i/N)%3 == 1 && (j/N)%3 == 1 ) { // 현재 N길이의 사각형에서 가운데 위치한다
            arr[i][j]=' ';
        }
        else { // N길이가 작아졌을 때 가운데 위치할 수 있기에 더 쪼갬
            if(N/3 == 0) { // 더이상 쪼갤수 없다
                arr[i][j]='*';
            }
            else { // 아직 쪼개짐
                star(i,j,N/3);
            }
        }
    }
}
