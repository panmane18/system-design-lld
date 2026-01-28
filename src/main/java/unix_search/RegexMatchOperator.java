package unix_search;

import java.util.regex.Pattern;

public class RegexMatchOperator implements ComparisonOperator<String> {
    @Override
    public boolean isMatch(String actualValue, String expectedValue) {
        return Pattern.matches(expectedValue, actualValue);
    }
}
