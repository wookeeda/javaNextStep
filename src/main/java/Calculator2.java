import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator2 {

    public int add(String text) {

        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String[] tokens;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimeter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimeter);
        }else {
            tokens = text.split(",|:");
        }
        int[] numbers = new int[tokens.length];
        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
            if (numbers[i] < 0) {
                throw new RuntimeException("음수가 입력되었습니다");
            }
            result += numbers[i];
        }

        return result;
    }
}
