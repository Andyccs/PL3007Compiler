/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production WhileStmt : {@link Stmt} ::= <span class="component">{@link Expr}</span> <span class="component">Body:{@link Stmt}</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:33
 */
public class WhileStmt extends Stmt implements Cloneable {
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
  public WhileStmt clone() throws CloneNotSupportedException {
    WhileStmt node = (WhileStmt)super.clone();
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public WhileStmt copy() {
      try {
        WhileStmt node = (WhileStmt)clone();
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
  public WhileStmt fullCopy() {
    try {
      WhileStmt tree = (WhileStmt) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:133
   */
  public void namecheck() {
		getExpr().namecheck();
		getBody().namecheck();
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:88
   */
  public void typecheck() {
		getExpr().typecheck();
		getBody().typecheck();
		
		if(!getExpr().type().isBoolean())
	
		error("Loop condition is not of type boolean.");
	}
  /**
   * @ast method 
   * 
   */
  public WhileStmt() {
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
  public WhileStmt(Expr p0, Stmt p1) {
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
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setExpr(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Expr getExpr() {
    return (Expr)getChild(0);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public Expr getExprNoTransform() {
    return (Expr)getChildNoTransform(0);
  }
  /**
   * Replaces the Body child.
   * @param node The new node to replace the Body child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setBody(Stmt node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Body child.
   * @return The current node used as the Body child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Stmt getBody() {
    return (Stmt)getChild(1);
  }
  /**
   * Retrieves the Body child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Body child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public Stmt getBodyNoTransform() {
    return (Stmt)getChildNoTransform(1);
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:6
   * @apilevel internal
   */
  public WhileStmt Define_WhileStmt_getEnclosingLoop(ASTNode caller, ASTNode child) {
    if(caller == getBodyNoTransform()) {
      return this;
    }
    else {    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
      return getParent().Define_WhileStmt_getEnclosingLoop(this, caller);
    }
  }
}
