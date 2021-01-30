import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(String.valueOf(i), name);
            map.put(name, String.valueOf(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.println(sb.toString());
    }
}
