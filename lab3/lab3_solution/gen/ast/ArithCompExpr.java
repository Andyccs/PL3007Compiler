/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production ArithCompExpr : {@link CompExpr};
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:57
 */
public abstract class ArithCompExpr extends CompExpr implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
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
  public ArithCompExpr clone() throws CloneNotSupportedException {
    ArithCompExpr node = (ArithCompExpr)super.clone();
    return node;
  }
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:154
   */
  public void typecheck() {
		super.typecheck();
		if(!getLeft().type().isNumeric())
			error("Operands of arithmetic comparison must be numeric.");
	}
  /**
   * @ast method 
   * 
   */
  public ArithCompExpr() {
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
  public ArithCompExpr(Expr p0, Expr p1) {
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
}
