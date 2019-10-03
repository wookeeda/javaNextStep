import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator3 {

    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toIntArr(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    private String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimeter = matcher.group(1);
            return matcher.group(2).split(customDelimeter);
        }

        return text.split(",|:");
    }

    private int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private int toPositive(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException("음수가 입력되었습니다");
        }
        return number;
    }

    private int[] toIntArr(String[] tokens) {
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = toPositive(tokens[i]);
        }
        return result;
    }
}
