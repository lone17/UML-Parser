import java.util.*;

public class Interface extends Component {
    private String[] baseInterfaces;
    private LinkedList<Method> methods;
    private LinkedList<Attribute> attributes;

    public Interface(String input) {
        String[] declaration = Parser.getInterfaceDeclaration(input);

        String[] parts = declaration[0].split("\\s+");
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

        if (declaration[1] != null)
            baseInterfaces = declaration[1].split("\\s+");

        methods = new LinkedList<Method>();
        attributes = new LinkedList<Attribute>();
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
	 * @return a string representation of Interface for printing
	 */
	@Override
	public String toString() {

        String s = "";
        if (accessModifier != null) s += accessModifier + " ";

        s += type + " " + name + "\n";

        for (String item : baseInterfaces)
            s += name + " ---> " + item + "\n";


        for (Attribute item : attributes)
            s += item.toString() + "\n";

        for (Method item : methods)
            s += item.toString() + "\n";

        return s;
	}

    public static void main(String[] args) {
        String s = "public interface Interface extends UMLComponent, a1, a2";
        Interface test = new Interface(s);
        System.out.println(test);
    }
}
