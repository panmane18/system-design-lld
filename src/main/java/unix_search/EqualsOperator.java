package unix_search;

public class EqualsOperator<T> implements ComparisonOperator<T> {
    @Override
    public boolean isMatch(T actualValue, T expectedValue) {
        return actualValue.equals(expectedValue);
    }
}
