import java.util.*;

public class Interface extends UMLComponent {
    private String[] parentsName;
    private LinkedList<Method> methods;
    private LinkedList<Attribute> attributes;

    public Interface(String declaration) {
        String[] prototype = Parser.getInterfaceDeclaration(declaration);

        String[] parts = prototype[0].split("\\s+");
        int len = parts.length;

        name = parts[len - 1];

        for (int i = len - 2; i >= 0; --i) {
            String cur = parts[i];
            if (modifiers.contains(cur))
                accessModifier = cur;
            else
                type = cur;
        }
        isAbstract = true;

        parentsName = prototype[1].split("\\s+");

        methods = new LinkedList<Method>();
    }

    public String[] getParentsName() {
        return parentsName;
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
	 * @return a string representation of Interface for printing
	 */
	@Override
	public String toString() {

        String s = "";
        if (accessModifier != null) s += accessModifier + " ";

        return s  + type + " " + name;
	}

    public static void main(String[] args) {
        String s = "public interface Interface extends UMLComponent implements a1, a2 {";
        Interface test = new Interface(s);
        System.out.println(test);
        for (String p : test.getParentsName())
            System.out.println(p);
    }
}
