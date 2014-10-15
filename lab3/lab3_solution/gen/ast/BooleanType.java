/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production BooleanType : {@link TypeDescriptor};
 * @ast node
 * @declaredat C:/Users/Andy/Desktop/PL3007Compiler/lab3/lab3_solution/src/frontend/grammar.ast:73
 */
public class BooleanType extends TypeDescriptor implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    isBoolean_visited = false;
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
  public BooleanType clone() throws CloneNotSupportedException {
    BooleanType node = (BooleanType)super.clone();
    node.isBoolean_visited = false;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public BooleanType copy() {
      try {
        BooleanType node = (BooleanType)clone();
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
  public BooleanType fullCopy() {
    try {
      BooleanType tree = (BooleanType) clone();
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
  public BooleanType() {
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
  protected boolean isBoolean_visited = false;
  /**
   * @attribute syn
   * @aspect Typecheck
   * @declaredat C:/Users/Andy/Desktop/PL3007Compiler/lab3/lab3_solution/src/frontend/typecheck.jrag:7
   */
  public boolean isBoolean() {
    if(isBoolean_visited)
      throw new RuntimeException("Circular definition of attr: isBoolean in class: ");
    isBoolean_visited = true;
    try {  return true;  }
    finally {
      isBoolean_visited = false;
    }
  }
}
