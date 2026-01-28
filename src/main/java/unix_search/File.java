package unix_search;

import java.util.HashSet;
import java.util.Set;

public class File {

    private final boolean isDirectory;
    private final int size;
    private final String owner;
    private final String filename;

    // Only directories will have entries
    private final Set<File> entries = new HashSet<>();

    public File(boolean isDirectory, int size, String owner, String filename) {
        this.isDirectory = isDirectory;
        this.size = size;
        this.owner = owner;
        this.filename = filename;
    }

    public Object extract(FileAttribute attribute) {
        switch (attribute) {
            case IS_DIRECTORY:
                return isDirectory;
            case SIZE:
                return size;
            case OWNER:
                return owner;
            case FILENAME:
                return filename;
            default:
                throw new IllegalArgumentException("Invalid attribute");
        }
    }

    public void addEntry(File entry) {
        if (!isDirectory) {
            throw new IllegalStateException("Cannot add entry to a file");
        }
        entries.add(entry);
    }

    public Set<File> getEntries() {
        return entries;
    }

    public String getFilename() {
        return filename;
    }
}
