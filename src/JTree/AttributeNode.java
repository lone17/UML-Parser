package JTree;

import Parser.Attribute;

import javax.swing.tree.DefaultMutableTreeNode;

public class AttributeNode extends DefaultMutableTreeNode{
    public AttributeNode(Attribute attribute) {
        super(attribute.toString());
    }
}
