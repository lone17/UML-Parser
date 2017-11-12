import java.util.*;

public class Class extends Component {
    private String baseClass;
    private String[] baseInterfaces;
    private LinkedList<Method> methods;
    private LinkedList<Attribute> attributes;

    public Class(String input) {
        String[] declaration = Parser.getClassDeclaration(input);

        String[] parts = declaration[0].split("\\s+");
        int len = parts.length;

        name = parts[len - 1];

        for (int i = len - 2; i >= 0; --i) {
            String cur = parts[i];
            if (cur.equals("static"))
                isStatic = true;
            else if (cur.equals("abstract"))
                isAbstract = true;
            else if (cur.equals("final"))
                isFinal = true;
            else if (modifiers.contains(cur))
                accessModifier = cur;
            else
                type = cur;
        }

        baseClass = declaration[1];
        if (declaration[2] != null)
            baseInterfaces = declaration[2].split("\\s+");

        methods = new LinkedList<Method>();
        attributes = new LinkedList<Attribute>();
    }

    public String getBaseClass() {
        return baseClass;
    }

    public String[] getBaseInterfaces() {
        return baseInterfaces;
    }

    public void addMethod(Method method) {
        methods.add(method);
    }

    public void addAllMethods(LinkedList<Method> methods) {
        methods.addAll(methods);
    }

    public LinkedList<Method> getMethods() {
        return methods;
    }

    public void addAtribute(Attribute att) {
        attributes.add(att);
    }

    public void addAllAttributes(LinkedList<Attribute> atts) {
        attributes.addAll(atts);
    }

    public LinkedList<Attribute> getAttibutes() {
        return attributes;
    }
	/**
	 * @return a string representation of Class for printing
	 */
	@Override
	public String toString() {

        String s = "";
        if (accessModifier != null) s += accessModifier + " ";
        if (isAbstract) s += "abstract ";
        if (isStatic)   s += "static ";
        if (isFinal)    s += "final ";

        s += type + " " + name + "\n";

        if (baseClass != null) s += name + " ---> " + baseClass + "\n";

        if (baseInterfaces != null)
            for (String item : baseInterfaces)
                s += name + " ---> " + item + "\n";

        s += "\n" + "Attributes: " + "\n";
        for (Attribute item : attributes)
            s += item.toString() + "\n";

        s += "\n" + "Method: " + "\n";
        for (Method item : methods)
            s += item.toString() + "\n";

        return s;
	}

    public static void main(String[] args) {
        String s = "public class Class extends UMLComponent implements a1, a2 {";
        Class test = new Class(s);
        System.out.println(test);
    }
}
