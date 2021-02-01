import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main_4358_생태학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int total = 0;

        while (true) {
            String name = br.readLine();
            if (name == null || name.length() == 0) break;
            map.put(name, map.getOrDefault(name, 0) + 1);
            ++total;
        }

        ArrayList<Map.Entry<String, Integer>> list_entry = sort(map);
        System.out.println(getPercentage(list_entry, total));
    }

    private static String getPercentage(ArrayList<Map.Entry<String, Integer>> list_entry, int total) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list_entry) {
            double percent = (double) entry.getValue() / total * 100;
            BigDecimal bigDecimal = new BigDecimal(percent).setScale(4, RoundingMode.HALF_UP);
            sb.append(entry.getKey()).append(" ").append(bigDecimal).append("\n");
        }
        return sb.toString();
    }

    private static ArrayList<Map.Entry<String, Integer>> sort(Map<String, Integer> map) {
        ArrayList<Map.Entry<String, Integer>> list_entry = new ArrayList<>(map.entrySet());
        Collections.sort(list_entry, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        return list_entry;
    }
}
