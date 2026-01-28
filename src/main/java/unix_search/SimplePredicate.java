package unix_search;

public class SimplePredicate<T> implements Predicate {

    private final FileAttribute attributeName;
    private final ComparisonOperator<T> operator;
    private final T expectedValue;

    public SimplePredicate(FileAttribute attributeName,
                           ComparisonOperator<T> operator,
                           T expectedValue) {
        this.attributeName = attributeName;
        this.operator = operator;
        this.expectedValue = expectedValue;
    }

    @Override
    public boolean isMatch(File inputFile) {
        Object actualValue = inputFile.extract(attributeName);

        if (!expectedValue.getClass().isInstance(actualValue)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        T castedValue = (T) actualValue;

        return operator.isMatch(castedValue, expectedValue);
    }
}
