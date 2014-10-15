/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production IntLiteral : {@link Literal} ::= <span class="component">&lt;Value:Integer&gt;</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:65
 */
public class IntLiteral extends Literal implements Cloneable {
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
  public IntLiteral clone() throws CloneNotSupportedException {
    IntLiteral node = (IntLiteral)super.clone();
    node.type_visited = false;
    node.type_computed = false;
    node.type_value = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public IntLiteral copy() {
      try {
        IntLiteral node = (IntLiteral)clone();
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
  public IntLiteral fullCopy() {
    try {
      IntLiteral tree = (IntLiteral) clone();
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
  public IntLiteral() {
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
   * @ast method 
   * 
   */
  public IntLiteral(Integer p0) {
    setValue(p0);
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
   * Replaces the lexeme Value.
   * @param value The new value for the lexeme Value.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setValue(Integer value) {
    tokenInteger_Value = value;
  }
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  protected Integer tokenInteger_Value;
  /**
   * Retrieves the value for the lexeme Value.
   * @return The value for the lexeme Value.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Integer getValue() {
    return tokenInteger_Value;
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:50
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
  private TypeDescriptor type_compute() {  return TypeDescriptor.INT;  }
}
