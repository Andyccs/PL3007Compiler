/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production Assignment : {@link Expr} ::= <span class="component">LHS:{@link LHSExpr}</span> <span class="component">RHS:{@link Expr}</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:44
 */
public class Assignment extends Expr implements Cloneable {
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
  public Assignment clone() throws CloneNotSupportedException {
    Assignment node = (Assignment)super.clone();
    node.type_visited = false;
    node.type_computed = false;
    node.type_value = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Assignment copy() {
      try {
        Assignment node = (Assignment)clone();
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
  public Assignment fullCopy() {
    try {
      Assignment tree = (Assignment) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:157
   */
  public void namecheck() {
		getLHS().namecheck();
		getRHS().namecheck();
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:129
   */
  public void typecheck() {
		getLHS().typecheck();
		getRHS().typecheck();
		if(getLHS().type() != getRHS().type())
			error("The two sides of the assignment have different types.");
	}
  /**
   * @ast method 
   * 
   */
  public Assignment() {
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
  public Assignment(LHSExpr p0, Expr p1) {
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
   * Replaces the LHS child.
   * @param node The new node to replace the LHS child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setLHS(LHSExpr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the LHS child.
   * @return The current node used as the LHS child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public LHSExpr getLHS() {
    return (LHSExpr)getChild(0);
  }
  /**
   * Retrieves the LHS child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the LHS child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public LHSExpr getLHSNoTransform() {
    return (LHSExpr)getChildNoTransform(0);
  }
  /**
   * Replaces the RHS child.
   * @param node The new node to replace the RHS child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setRHS(Expr node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the RHS child.
   * @return The current node used as the RHS child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Expr getRHS() {
    return (Expr)getChild(1);
  }
  /**
   * Retrieves the RHS child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the RHS child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public Expr getRHSNoTransform() {
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:45
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
  private TypeDescriptor type_compute() {  return getLHS().type();  }
}
