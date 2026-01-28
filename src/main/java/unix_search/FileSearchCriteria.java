package unix_search;

public class FileSearchCriteria {

    private final Predicate predicate;

    public FileSearchCriteria(Predicate predicate) {
        this.predicate = predicate;
    }

    public boolean isMatch(File inputFile) {
        return predicate.isMatch(inputFile);
    }
}
