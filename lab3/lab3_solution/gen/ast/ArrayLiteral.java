/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production ArrayLiteral : {@link Literal} ::= <span class="component">Element:{@link Expr}*</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:67
 */
public class ArrayLiteral extends Literal implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    type_visited = false;
    type_computed = false;
    type_value = null;
  }
  /**
   * @apilevel internal
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ArrayLiteral clone() throws CloneNotSupportedException {
    ArrayLiteral node = (ArrayLiteral)super.clone();
    node.type_visited = false;
    node.type_computed = false;
    node.type_value = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ArrayLiteral copy() {
      try {
        ArrayLiteral node = (ArrayLiteral)clone();
        if(children != null) node.children = (ASTNode[])children.clone();
        return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ArrayLiteral fullCopy() {
    try {
      ArrayLiteral tree = (ArrayLiteral) clone();
      tree.setParent(null);// make dangling
      if (children != null) {
        tree.children = new ASTNode[children.length];
        for (int i = 0; i < children.length; ++i) {
          if (children[i] == null) {
            tree.children[i] = null;
          } else {
            tree.children[i] = ((ASTNode) children[i]).fullCopy();
            ((ASTNode) tree.children[i]).setParent(tree);
          }
        }
      }
      return tree;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " +
        getClass().getName());
    }
  }
  /**
   * @ast method 
   * @aspect Namecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:173
   */
  public void namecheck() {
		for(Expr element : getElements())
			element.namecheck();
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:168
   */
  public void typecheck() {
		if(getNumElement() == 0) {
			error("Array literals must contain at least one element.");
		} else {
			if(getElement(0).type().isVoid())
				error("Array literal elements may not be of type void.");
			for(int i=0;i<getNumElement();++i) {
				getElement(i).typecheck();
				if(i > 0 && getElement(i).type() != getElement(0).type())
					error("Every element in an array literal must have the same type.");
			}
		}
	}
  /**
   * @ast method 
   * 
   */
  public ArrayLiteral() {
    super();


  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @ast method 
   * 
   */
  public void init$Children() {
    children = new ASTNode[1];
    setChild(new List(), 0);
  }
  /**
   * @ast method 
   * 
   */
  public ArrayLiteral(List<Expr> p0) {
    setChild(p0, 0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * Replaces the Element list.
   * @param list The new list node to be used as the Element list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setElementList(List<Expr> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Element list.
   * @return Number of children in the Element list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public int getNumElement() {
    return getElementList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Element list.
   * Calling this method will not trigger rewrites..
   * @return Number of children in the Element list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public int getNumElementNoTransform() {
    return getElementListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Element list..
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Element list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Expr getElement(int i) {
    return (Expr)getElementList().getChild(i);
  }
  /**
   * Append an element to the Element list.
   * @param node The element to append to the Element list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void addElement(Expr node) {
    List<Expr> list = (parent == null || state == null) ? getElementListNoTransform() : getElementList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void addElementNoTransform(Expr node) {
    List<Expr> list = getElementListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Element list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setElement(Expr node, int i) {
    List<Expr> list = getElementList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Element list.
   * @return The node representing the Element list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public List<Expr> getElements() {
    return getElementList();
  }
  /**
   * Retrieves the Element list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Element list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public List<Expr> getElementsNoTransform() {
    return getElementListNoTransform();
  }
  /**
   * Retrieves the Element list.
   * @return The node representing the Element list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Expr> getElementList() {
    List<Expr> list = (List<Expr>)getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Element list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Element list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Expr> getElementListNoTransform() {
    return (List<Expr>)getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  protected boolean type_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean type_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDescriptor type_value;
  /** Type inference for expressions. * @attribute syn
   * @aspect types
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:52
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDescriptor type() {
    if(type_computed) {
      return type_value;
    }
    if(type_visited)
      throw new RuntimeException("Circular definition of attr: type in class: ");
    type_visited = true;
    type_value = type_compute();
      if(true) type_computed = true;
    type_visited = false;
    return type_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDescriptor type_compute() {  return getElement(0).type().arrayType();  }
}
