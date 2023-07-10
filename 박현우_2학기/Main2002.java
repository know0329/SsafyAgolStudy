import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// }}}}}}{{ >> 반례 , }}}}}{{{
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int answer = 0;
        HashMap<String, Integer> cars = new HashMap<>();
        // in
        for(int i=1;i<=loop;i++) {
            String car = br.readLine();
            cars.put(car, i);
        }
        // out
        for(int i=1;i<=loop;i++) {
            String car = br.readLine();

            Integer cur = cars.get(car);
            // 추월한 차가 생기는 경우
            if(cur > i) {
                cars.put(car,i); // 추월한 차의 순위 업데이트
                answer++;
                for( String key : cars.keySet() ){
                    // 추월당한 차 순위 변경
                    Integer delayed = cars.get(key);
                    if(delayed <= cur && !key.equals(car)) cars.put(key, delayed+1);
                }
            }
        }

        System.out.println(answer);
    }
}
