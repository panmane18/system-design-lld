package unix_search;

public interface ComparisonOperator<T> {
    boolean isMatch(T actualValue, T expectedValue);
}
