public class Parser {

    public static String removeComment(String input) {
        String test = "/* asda /* /* */ protected boolean isStatic = false, /* a /* b /* c */  isAbstract = false, /* a */ isFinal /* a */ = false; //asd /* */ /*";

        input = input.replaceAll("//.+$", "");
        while (input.matches(".*/\\*[^*/]+/\\*.*"))
            input = input.replaceAll("/\\*[^*/]*/\\*", "/*");
        // while (input.matches(".*\\*/[^/*]+\\*/.*"))
        //     input = input.replaceAll("\\*/[^/*]+\\*/", "*/");
        while (input.matches(".*/\\*[^/*]+\\*/.*"))
            input = input.replaceAll("/\\*[^/*]+\\*/", "");

        return input;
    }
    public static String[] getMethodDeclaration(String input) {
        String[] res = removeComment(input).replace("\n", " ").split("throws")[0].split("\\(");
        res[0] = res[0].trim();
        res[1] = res[1].split("\\)")[0].trim().replace(",", " ");

        return res;
    }

    public static String[] getClassDeclaration(String input) {
        String[] res = removeComment(input).replace("\n", " ").split("\\{")[0].split("extends");
        res[0] = res[0].trim();
        res[1] = res[1].replace("implements", "").replace(",", " ").trim();

        return res;
    }

    public static String[] getInterfaceDeclaration(String input) {
        String[] res = removeComment(input).replace("\n", " ").split("\\{")[0].split("extends");
        res[0] = res[0].trim();
        res[1] = res[1].replace("implements", "").replace(",", " ").trim();

        return res;
    }

    public static String[] getAttributeDeclaration(String input) {
        String[] res = removeComment(input).replace("\n", " ").trim().replaceAll("=\\s+[^ ]+\\b", "").split(",");

        return res;
    }

    public static void main(String[] args) {

    }
}
