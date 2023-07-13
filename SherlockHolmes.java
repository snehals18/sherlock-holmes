import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockHolmes {

    public static boolean checkPermutation(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();

        if (patternLength > textLength) {
            return false;
        }

        Map<Character, Integer> patternFreq = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternFreq.put(c, patternFreq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= textLength - patternLength; i++) {
            String substring = text.substring(i, i + patternLength);
            Map<Character, Integer> substringFreq = new HashMap<>();
            for (char c : substring.toCharArray()) {
                substringFreq.put(c, substringFreq.getOrDefault(c, 0) + 1);
            }
            if (patternFreq.equals(substringFreq)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (t > 0) {
            String pattern = scanner.nextLine().trim();
            String text = scanner.nextLine().trim();

            if (checkPermutation(pattern, text)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }

        scanner.close();
    }
}