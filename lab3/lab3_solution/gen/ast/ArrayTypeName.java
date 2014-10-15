/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production ArrayTypeName : {@link TypeName} ::= <span class="component">ElementType:{@link TypeName}</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:23
 */
public class ArrayTypeName extends TypeName implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getDescriptor_visited = false;
    getDescriptor_computed = false;
    getDescriptor_value = null;
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
  public ArrayTypeName clone() throws CloneNotSupportedException {
    ArrayTypeName node = (ArrayTypeName)super.clone();
    node.getDescriptor_visited = false;
    node.getDescriptor_computed = false;
    node.getDescriptor_value = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ArrayTypeName copy() {
      try {
        ArrayTypeName node = (ArrayTypeName)clone();
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
  public ArrayTypeName fullCopy() {
    try {
      ArrayTypeName tree = (ArrayTypeName) clone();
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
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:183
   */
  public void typecheck() {
		if(getElementType().getDescriptor().isVoid())
			error("Component type of array cannot be void.");
	}
  /**
   * @ast method 
   * 
   */
  public ArrayTypeName() {
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
  }
  /**
   * @ast method 
   * 
   */
  public ArrayTypeName(TypeName p0) {
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
   * Replaces the ElementType child.
   * @param node The new node to replace the ElementType child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setElementType(TypeName node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the ElementType child.
   * @return The current node used as the ElementType child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public TypeName getElementType() {
    return (TypeName)getChild(0);
  }
  /**
   * Retrieves the ElementType child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the ElementType child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public TypeName getElementTypeNoTransform() {
    return (TypeName)getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  protected boolean getDescriptor_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean getDescriptor_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDescriptor getDescriptor_value;
  /** Determine type descriptor for type name. * @attribute syn
   * @aspect types
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:25
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDescriptor getDescriptor() {
    if(getDescriptor_computed) {
      return getDescriptor_value;
    }
    if(getDescriptor_visited)
      throw new RuntimeException("Circular definition of attr: getDescriptor in class: ");
    getDescriptor_visited = true;
    getDescriptor_value = getDescriptor_compute();
      if(true) getDescriptor_computed = true;
    getDescriptor_visited = false;
    return getDescriptor_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDescriptor getDescriptor_compute() {
		TypeDescriptor desc = getElementType().getDescriptor();
		return desc == null ? null : desc.arrayType();
	}
}
