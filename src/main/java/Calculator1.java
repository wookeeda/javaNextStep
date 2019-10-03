import java.util.Arrays;

public class Calculator1 {

    private String regex = "[,:]";

    public String[] split(String str) {
        str = str.trim();
        String target = str;

        if (str.contains("//") && str.contains("\n")) {
            int startIndex = str.indexOf("//");
            int endIndex = str.indexOf("\n") + 1;
            String dividerToken = str.substring(startIndex, endIndex);

            dividerToken = dividerToken.replace("//", "");
            dividerToken = dividerToken.replace("\n", "");

            setCustomDivider(dividerToken);

            target = str.substring(endIndex);
        }

        if (target.length() == 0) {
            return new String[0];
        }
        String[] result = target.split(regex);

        return result;
    }

    public int[] parseInt(String[] strArr) {
        int len = strArr.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.parseInt(strArr[i]);
            if (result[i] < 0) {
                throw new RuntimeException();
            }
        }
        return result;
    }

    public int sum(int[] intArr) {
        return Arrays.stream(intArr).sum();

    }

    public void setCustomDivider(String customDivider) {
        regex = regex.replace("]", customDivider + "]");
    }

    public int add(String str) {
        String[] strings = split(str);
        int[] intArr = parseInt(strings);
        int result = sum(intArr);
        return result;
    }
}
