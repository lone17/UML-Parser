import java.util.*;

public abstract class UMLComponent {
    protected final List<String> modifiers = Arrays.asList("public", "protected", "private");

    protected String name, type, accessModifier;
    protected boolean isStatic = false, isAbstract = false, isFinal = false;


	/**
	 * @return the caller's type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @return the caller's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the caller's accessModifier
	 */
	public String getAccessModifier() {
		return this.accessModifier;
	}

	/**
	 * @return true if this component is static
	 *         false otherwise
	 */
	public boolean isStatic() {
		return this.isStatic;
	}

	/**
	 * @return true if this component is abstract
     *         false otherwise
	 */
	public boolean isAbstract() {
		return this.isAbstract;
	}

	/**
	 * @return true if this component is abstract
     *         false otherwise
	 */
	public boolean isFinal() {
		return this.isFinal;
	}

	/**
	* @return true if this component is a class
	*         false otherwise
	*/
	public boolean isClass() {
		return type.equals("class");
	}

	/**
	* @return true if this component is a interface
	*         false otherwise
	*/
	public boolean isInterface() {
		return type.equals("interface");
	}

	/**
	* @return true if this component is a method
	*         false otherwise
	*/
	public boolean isMethod() {
		return false;
	}

	/**
	* @return true if this component is a attribute
	*         false otherwise
	*/
	public boolean isAttribute() {
		return false;
	}
}
