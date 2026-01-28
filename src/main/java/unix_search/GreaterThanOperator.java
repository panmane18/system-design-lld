package unix_search;

public class GreaterThanOperator implements ComparisonOperator<Integer> {
    @Override
    public boolean isMatch(Integer actualValue, Integer expectedValue) {
        return actualValue > expectedValue;
    }
}
