import java.util.LinkedList;

public class Project extends Directory {
    private final LinkedList<SourceFile> sourceFiles; // all source files

    public Project(String path) {
        super(path);
        sourceFiles = new LinkedList<SourceFile>();

        for (String filePath : allSourceFilePaths)
            sourceFiles.add(new SourceFile(filePath));
    }

    /**
     * Return all source files
     *
     * @return a LinkedList contains all source files
     */
    public LinkedList<SourceFile> getSourceFiles() {
        return sourceFiles;
    }

    public static void main(String[] args) {
        Project uml;
        if (args.length != 0)
            uml = new Project(args[0]);
        else
            uml = new Project("E:\\Code\\OOP\\UML-Visualizer");
        for (SourceFile file : uml.sourceFiles) {
            System.out.println("********************************************");
            System.out.println(file.getContainedClass());
        }
    }
}
