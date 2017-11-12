import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Represent a directory
 */
public class Directory {
    private File self; // the directory itself
    private final LinkedList<Directory> subDirectories; // all subdirectories
    private final LinkedList<String> sourceFiles; // all source files path

    /**
     * Constructor
     *
     * @param path the directory's address
     */
    public Directory(String path) {
        self = new File(path);
        if (!self.exists())
            throw new RuntimeException(": Directory not found");
        subDirectories = new LinkedList<>();
        setSubDirectories();
        sourceFiles = new LinkedList<String>();
        setSourceFiles();
    }

    /**
     * Get all subfolder and file
     */
    private void setSubDirectories() {
        if (self.isFile()) return;

        for (File file : self.listFiles()) {
            subDirectories.add(new Directory(file.getPath()));
        }
    }

    /**
     * Get all source files
     */
    private void setSourceFiles() {
        if (self.isFile()) {
            if (self.getName().endsWith(".java"))
                sourceFiles.add(self.getAbsolutePath());
            return;
        }

        for (Directory dir : subDirectories)
            sourceFiles.addAll(dir.sourceFiles);
    }

    /**
     * Return all subdirectories and files
     *
     * @return a Linked List contains children of this directory
     */
    public LinkedList<Directory> getSubDirectories() {
        return subDirectories;
    }

    /**
     * Return all source files path
     *
     * @return a Linked List contains all source files path
     */
    public LinkedList<String> getSourceFiles() {
        return sourceFiles;
    }

    /**
     * Print all files, subfolders and their files/subfolders
     */
    public void printContent() {
        printContent(0);
    }

    /**
     * Helper method for content printing
     */
    private void printContent(int level) {
        for (int i = 0; i < level; ++i)
        System.out.print("  ");

        if (self.isDirectory() && level != 0) System.out.print("> ");
        else if (self.isFile()) System.out.print("- ");

        System.out.println(self.getName());

        if (self.isDirectory()) {
            for (Directory dir : subDirectories)
                dir.printContent(level+1);
        }
    }

    /*
     * Local testing
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Directory dir = null;

        if (args.length != 0 )
            dir = new Directory(args[0]);
        else
            dir = new Directory("E:\\Code\\OOP\\UML-Visualizer\\Attribute.java");

        for (String s : dir.getSourceFiles())
            System.out.println(s);
    }
}
