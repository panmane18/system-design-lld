package unix_search;

import java.util.List;

public class FileSearchTest {

    public static void main(String[] args) {

        File root = new File(true, 0, "adam", "root");
        File a = new File(false, 2000, "adam", "a");
        File b = new File(false, 3000, "george", "b");

        root.addEntry(a);
        root.addEntry(b);

        Predicate criteriaPredicate =
                new AndPredicate(List.of(
                        new SimplePredicate<>(
                                FileAttribute.IS_DIRECTORY,
                                new EqualsOperator<>(),
                                false
                        ),
                        new SimplePredicate<>(
                                FileAttribute.OWNER,
                                new RegexMatchOperator(),
                                "ge.*"
                        )
                ));

        FileSearchCriteria criteria = new FileSearchCriteria(criteriaPredicate);

        FileSearch search = new FileSearch();
        List<File> result = search.search(root, criteria);

        System.out.println("Matched files:");
        result.forEach(file -> System.out.println(file.getFilename()));
    }
}
