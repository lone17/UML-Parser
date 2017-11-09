import java.util.*;

public class Attribute extends UMLComponent {

    public static LinkedList<Attribute> generateInstances(String declaration) {
        String[] instances = Parser.getAttributeDeclaration(declaration);

        LinkedList<Attribute> attributes = new LinkedList<Attribute>();

        attributes.add(new Attribute(instances[0]));
        String properties = instances[0].trim().replaceAll(" [^ ]+$", "");
        for (int i = 1, len = instances.length; i < len; ++i)
            attributes.add(new Attribute(properties + " " + instances[i]));

        return attributes;
    }

    private Attribute(String declaration) {
        String[] parts = declaration.trim().split("\\s+");
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
    }

    /**
     * @return true if this component is a attribute
     *         false otherwise
     */
    @Override
    public boolean isAttribute() {
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

        return s  + name;
    }

    public static void main(String[] args) {
        List<Attribute> atts = Attribute.generateInstances("protected boolean isStatic = false, isAbstract, isFinal = false");
        for (Attribute a : atts)
            System.out.println(a);
    }
}
