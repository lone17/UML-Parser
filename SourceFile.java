import java.io.*;

public class SourceFile {
    private Class containedClass;
    private String name, path, text = "";

    public SourceFile(String filePath) {
        File self;
        try {
            path = filePath;
            self = new File(filePath);
            name = self.getName();
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                text += Parser.removeQuote(line) + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        text = Parser.preprocess(text);

        // text = text.replaceAll("\\{(?:.|[\\r|\\n])*?\\}", "");
        // text = text.replaceAll("[\\n\\r;]", " ").trim();

        String[] lines = text.trim().split("\\s*;\\s*");
        // for (String s : lines) {
        //     System.out.println(s);
        // }
        containedClass = new Class(lines[0]);
        for (int i = 1, len = lines.length; i < len; ++i) {
            // System.out.println(lines[i]);
            if (lines[i].contains("(") && !lines[i].contains("="))
                containedClass.addMethod(new Method(lines[i]));
            else
                containedClass.addAllAttributes(Attribute.generateInstances(lines[i]));
        }
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public Class getContainedClass() {
        return containedClass;
    }

    public static void main(String[] args) {
        SourceFile test = new SourceFile("E:\\Code\\OOP\\UML-Visualizer\\SourceFile.java");
        System.out.println(test.containedClass);
        // System.out.println(test.text);
    }
}
