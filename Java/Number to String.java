public class Solution {
    private static final String[] LESS_THAN_20 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", 
                                                  "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", 
                                                  "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
                                          "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                words = convert(num % 1000) + " " + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        return words.trim();
    }
    private String convert(int num) {
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_20[num] + " ";
        else if (num < 100) return TENS[num / 10] + " " + convert(num % 10);
        else return LESS_THAN_20[num / 100] + " Hundred " + convert(num % 100);
    }
}
public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.numberToWords(1234));
}

