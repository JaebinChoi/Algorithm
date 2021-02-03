import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3865_학회원 {
    static Map<String, ArrayList<String>> map;
    static Set<String> members;
    static String firstGroup;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        members = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), ":,.");
                String group = st.nextToken();
                map.put(group, new ArrayList<>());

                if (i == 0) firstGroup = group;
                while (st.hasMoreTokens()) {
                    map.get(group).add(st.nextToken());
                }
            }
            sb.append(getTotalMembers()).append("\n");
            map.clear();
            members.clear();
        }
        System.out.println(sb.toString());
    }

    private static int getTotalMembers() {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(firstGroup);
        int cnt = 0;

        while (!queue.isEmpty()) {
            String group = queue.poll();
            for (String member : map.get(group)) {
                if (!members.contains(member)) {
                    members.add(member);
                    if (map.get(member) != null) queue.offer(member);
                    else ++cnt;
                }
            }
        }
        return cnt;
    }
}
