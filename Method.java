public class Method extends UMLComponent {
    private String parametersType;

    public Method(String declaration) {
        String[] prototype = Parser.getMethodDeclaration(declaration);

        String[] parts = prototype[0].split("\\s+");
        int len = parts.length;

        name = parts[len - 1];
        type = parts[len - 2];

        for (int i = len - 3; i >= 0; --i) {
            String cur = parts[i];
            if (cur.equals("static"))
                isStatic = true;
            else if (cur.equals("abstract"))
                isAbstract = true;
            else if (cur.equals("final"))
                isFinal = true;
            else if (modifiers.contains(cur))
                accessModifier = cur;
        }

        parts = prototype[1].split(" ");
        len = parts.length;
        parametersType = parts[0];
        for (int i = 2; i < len; i += 2)
            parametersType += ", " + parts[i];
    }
    
    /**
    * @return true if this component is a method
    *         false otherwise
    */
    @Override
    public boolean isMethod() {
        return true;
    }

    /**
    * @return a string representation of Method for printing
    */
    @Override
    public String toString() {

        String s = "";
        if (accessModifier != null) s += accessModifier + " ";
        if (isAbstract) s += "abstract ";
        if (isStatic)   s += "static ";
        if (isFinal)    s += "final ";
        if (type != null) s += type + " ";

        return s  + name + "(" + parametersType + ")";
    }

    public static void main(String[] args) {

        String s = "public static void main(String[] args) throws Exception {};";
        Method test = new Method(s);
        System.out.println(test);
    }
}
