package JTree;

import Parser.Attribute;
import Parser.Class;
import Parser.Method;

import javax.swing.tree.DefaultMutableTreeNode;

public class ClassNode extends DefaultMutableTreeNode {

    public ClassNode(Class aClass) {
        super(aClass.getName());

        for (Attribute atts : aClass.getAttributes()) {
            this.add(new AttributeNode(atts));
        }

        for (Method method : aClass.getMethods()) {
            this.add(new MethodNode(method));
        }
    }


}
