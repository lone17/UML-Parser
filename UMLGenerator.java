import java.io.*;

public class UMLGenerator {
    private Class self;
    String wholeFile = "";

    public UMLGenerator(String filePath) {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                wholeFile += Parser.removeQuote(line) + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        wholeFile = Parser.preprocess(wholeFile);

        // wholeFile = wholeFile.replaceAll("\\{(?:.|[\\r|\\n])*?\\}", "");
        // wholeFile = wholeFile.replaceAll("[\\n\\r;]", " ").trim();

        String[] lines = wholeFile.trim().split("\\s*;\\s*");
        // for (String s : lines) {
        //     System.out.println(s);
        // }
        self = new Class(lines[0]);
        for (int i = 1, len = lines.length; i < len; ++i) {
            // System.out.println(lines[i]);
            if (lines[i].contains("(") && !lines[i].contains("="))
                self.addMethod(new Method(lines[i]));
            else
                self.addAllAttributes(Attribute.generateInstances(lines[i]));
        }
    }

    public static void main(String[] args) {
        UMLGenerator test = new UMLGenerator("E:\\Code\\OOP\\UML-Visualizer\\UMLGenerator.java");
        System.out.println(test.self);
        // System.out.println(test.wholeFile);
    }
}
