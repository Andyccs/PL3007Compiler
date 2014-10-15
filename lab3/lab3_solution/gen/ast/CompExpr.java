/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production CompExpr : {@link BinaryExpr};
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:54
 */
public abstract class CompExpr extends BinaryExpr implements Cloneable {
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
  public CompExpr clone() throws CloneNotSupportedException {
    CompExpr node = (CompExpr)super.clone();
    node.type_visited = false;
    node.type_computed = false;
    node.type_value = null;
    return node;
  }
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:145
   */
  public void typecheck() {
		getLeft().typecheck();
		getRight().typecheck();
		if(getLeft().type() != getRight().type())
			error("Both operands of a comparison operator must be of the same type.");
		if(getLeft().type().isVoid())
			error("Operands in comparison may not be of type void.");
	}
  /**
   * @ast method 
   * 
   */
  public CompExpr() {
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
    children = new ASTNode[2];
  }
  /**
   * @ast method 
   * 
   */
  public CompExpr(Expr p0, Expr p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * Replaces the Left child.
   * @param node The new node to replace the Left child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setLeft(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Left child.
   * @return The current node used as the Left child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Expr getLeft() {
    return (Expr)getChild(0);
  }
  /**
   * Retrieves the Left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Left child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public Expr getLeftNoTransform() {
    return (Expr)getChildNoTransform(0);
  }
  /**
   * Replaces the Right child.
   * @param node The new node to replace the Right child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setRight(Expr node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Right child.
   * @return The current node used as the Right child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Expr getRight() {
    return (Expr)getChild(1);
  }
  /**
   * Retrieves the Right child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Right child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public Expr getRightNoTransform() {
    return (Expr)getChildNoTransform(1);
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:47
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
  private TypeDescriptor type_compute() {  return TypeDescriptor.BOOLEAN;  }
}
