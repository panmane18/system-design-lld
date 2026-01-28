package unix_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {

    public List<File> search(File root, FileSearchCriteria criteria) {
        List<File> result = new ArrayList<>();
        ArrayDeque<File> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            File current = stack.pop();

            if (criteria.isMatch(current)) {
                result.add(current);
            }

            for (File entry : current.getEntries()) {
                stack.push(entry);
            }
        }

        return result;
    }
}
