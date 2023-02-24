package baekjoon.클래스.집합11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        S set = new S();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "add" : {
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "remove": {
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "check": {
                    sb.append(set.check(Integer.parseInt(st.nextToken())))
                            .append("\n");
                    break;
                }
                case "toggle": {
                    set.toggle(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "all":
                    set.all();
                    break;
                case "empty":
                    set.empty();
                    break;
            }
        }
        System.out.print(sb);
    }
}

class S {

    private final Set<Integer> store;

    public S() {
        store = new HashSet<>();
    }

    public void add(int element) {
        store.add(element);
    }

    public void remove(int element) {
        store.remove(element);
    }

    public int check(int element) {
        if (store.contains(element)) {
            return 1;
        }
        return 0;
    }

    public void toggle(int element) {
        if (store.contains(element)) {
            store.remove(element);
            return;
        }
        add(element);
    }

    public void all() {
        for (int i = 1; i < 21; i++) {
            store.add(i);
        }
    }

    public void empty() {
        store.clear();
    }

}
