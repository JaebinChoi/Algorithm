import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1302_베스트셀러 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        System.out.println(getBestSeller(map));
    }

    private static String getBestSeller(Map<String, Integer> map) {
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                return -1 * o1.getValue().compareTo(o2.getValue());
            }
        });
        return list.get(0).getKey();
    }
}
