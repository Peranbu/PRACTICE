public class Main {
    public static String hash(String s) {
        int hashcount = 0;
        for (char c : s.toCharArray()) {
            if (c == '#') {
                hashcount++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                sb.append(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hashcount; i++) {
            result.append("#");
        }
        result.append(sb.toString());
        return result.toString();
    }
    public static void main(String[] args) {
        String input = "ab#cd#ef#";
        String output = hash(input);
        System.out.println("Original String: " + input);
        System.out.println("Processed String: " + output);
    }
}
