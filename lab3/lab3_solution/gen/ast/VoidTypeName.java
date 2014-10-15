/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production VoidTypeName : {@link TypeName};
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:22
 */
public class VoidTypeName extends TypeName implements Cloneable {
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
  public VoidTypeName clone() throws CloneNotSupportedException {
    VoidTypeName node = (VoidTypeName)super.clone();
    node.getDescriptor_visited = false;
    node.getDescriptor_computed = false;
    node.getDescriptor_value = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VoidTypeName copy() {
      try {
        VoidTypeName node = (VoidTypeName)clone();
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
  public VoidTypeName fullCopy() {
    try {
      VoidTypeName tree = (VoidTypeName) clone();
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
   * 
   */
  public VoidTypeName() {
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
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  protected int numChildren() {
    return 0;
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:24
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
  private TypeDescriptor getDescriptor_compute() {  return TypeDescriptor.VOID;  }
}
