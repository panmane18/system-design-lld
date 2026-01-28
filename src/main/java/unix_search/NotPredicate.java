package unix_search;

public class NotPredicate implements CompositePredicate {

    private final Predicate operand;

    public NotPredicate(Predicate operand) {
        this.operand = operand;
    }

    @Override
    public boolean isMatch(File inputFile) {
        return !operand.isMatch(inputFile);
    }
}
