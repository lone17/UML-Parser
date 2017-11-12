public class Parser {

    public static String preprocess(String input) {
        // input = removeQuote(input);
        input = removeComment(input);
        input = input.replaceAll("(import|package)[^;]+;", "");
        input = input.replaceAll("@[\\S]*\\b", "");

        int begin = input.indexOf("{");
        int end = input.lastIndexOf("}");
        input = input.substring(0, begin) + ";" + input.substring(begin+1, end);

        while (input.contains("{"))
            input = input.replaceAll("\\{[^{^}]*\\}", ";");

        input = input.replace("\n", " ");

        return input;
    }

    public static String removeComment(String input) {
        String test = "/* asda /* /* */ protected boolean isStatic = false, /* a /* b /* c */  isAbstract = false, /* a */ isFinal /* a */ = false; //asd /* */ /*";

        input = input.replaceAll("(/\\*(?:.|[\\r|\\n])*?\\*/)|(//.*)", "");
        return input;
    }

    public static String[] getMethodDeclaration(String input) {
        String[] res = input.split("throws")[0].split("\\(");
        res[0] = res[0].trim();
        if (res[1].matches(".*[^)].*"))
            res[1] = res[1].split("\\)")[0].trim().replace(",", " ");
        else
            res[1] = "";

        return res;
    }

    public static String removeQuote(String input) {
        input = input.replace("\\\"", "");
        input = input.replaceAll("([\"'])[^\1]*?\\1", "");
        return input;
    }

    public static String[] getClassDeclaration(String input) {
        String[] res = new String[3];
        String[] tmp = input.split("\\{")[0].replaceAll("(\\bextends\\b)|(\\bimplements\\b)", "-").split("-");
        res[0] = tmp[0].trim();
        if (tmp.length == 1) return res;

        if (tmp.length == 2)
            if (input.matches("\\bextends\\b"))
                res[1] = tmp[1].trim();
            else
                res[2] = tmp[1].trim().replace(",", " ");
        else {
            res[1] = tmp[1].trim();
            res[2] = tmp[2].trim().replace(",", " ");
        }


        return res;
    }

    public static String[] getInterfaceDeclaration(String input) {
        String[] res = new String[2];
        String[] tmp = removeComment(input).split("extends");
        res[0] = tmp[0].trim();
        if (tmp.length > 1)
            res[1] = tmp[1].replace(",", " ").trim();

        return res;
    }

    public static String[] getAttributeDeclaration(String input) {
        input = input.split("\\(")[0];
        String[] res = input.trim().replaceAll("=\\s*[^ ]*\\s*(,|$)", ",").split("\\s*,\\s*");

        return res;
    }

    public static void main(String[] args) {
        String test = "/* asda /* /* */ protected boolean isStatic = false, /* a /* b /* c */  isAbstract = \"nkn\", /* ** a */ isFinal /* a */ = false; //asd /* */";
        test = removeQuote(test);
        test = removeComment(test);
        System.out.println(test.replace("\n", " ").trim().replaceAll("=\\s*[^ ]*\\s*(,|$)", ","));
    }
}
