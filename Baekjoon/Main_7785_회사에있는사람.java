import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7785_회사에있는사람 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String type = st.nextToken();

            if (type.equals("enter")) map.put(name, true);
            else map.put(name, false);
        }

        ArrayList<Map.Entry<String, Boolean>> list_entry = sort(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Boolean> entry : list_entry) {
            if (entry.getValue()) {
                sb.append(entry.getKey()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static ArrayList<Map.Entry<String, Boolean>> sort(Map<String, Boolean> map) {
        ArrayList<Map.Entry<String, Boolean>> list_enrty = new ArrayList<>(map.entrySet());
        Collections.sort(list_enrty, new Comparator<Map.Entry<String, Boolean>>() {
            @Override
            public int compare(Map.Entry<String, Boolean> o1, Map.Entry<String, Boolean> o2) {
                return -1 * o1.getKey().compareTo(o2.getKey());
            }
        });
        return list_enrty;
    }
}
