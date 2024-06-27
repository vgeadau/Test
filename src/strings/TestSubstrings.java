package strings;

import java.util.ArrayList;
import java.util.List;

public class TestSubstrings {

    public static List<String> findAllSubstrings(String input) {
        List<String> substrings = new ArrayList<>();
        int n = input.length();
        int numOfSubstrings = 1 << n; // 2^n

        for (int i = 0; i < numOfSubstrings; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sb.append(input.charAt(j));
                }
            }
            substrings.add(sb.toString());
        }

        return substrings;
    }

    public static void main(String[] args) {
        String input = "abcd";
        List<String> substrings = findAllSubstrings(input);

        System.out.println("All substrings of \"" + input + "\":");
        for (String substring : substrings) {
            System.out.println(substring);
        }
    }
}