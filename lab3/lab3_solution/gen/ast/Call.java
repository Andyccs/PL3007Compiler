/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production Call : {@link Expr} ::= <span class="component">Callee:{@link FunctionName}</span> <span class="component">Argument:{@link Expr}*</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:43
 */
public class Call extends Expr implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getCallTarget_visited = false;
    getCallTarget_computed = false;
    getCallTarget_value = null;
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
  public Call clone() throws CloneNotSupportedException {
    Call node = (Call)super.clone();
    node.getCallTarget_visited = false;
    node.getCallTarget_computed = false;
    node.getCallTarget_value = null;
    node.type_visited = false;
    node.type_computed = false;
    node.type_value = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Call copy() {
      try {
        Call node = (Call)clone();
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
  public Call fullCopy() {
    try {
      Call tree = (Call) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:151
   */
  public void namecheck() {
		getCallee().namecheck();
		for(Expr argument : getArguments())
			argument.namecheck();
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:114
   */
  public void typecheck() {
		FunctionDeclaration callee = getCallTarget();
		for(int i=0;i<getNumArgument(); i++) 
			getArgument(i).typecheck();
		if (getNumArgument() != callee.getNumParameter()) {
			error("Number of arguments (" + getNumArgument() + ") and number of " +
					"parameters (" + callee.getNumParameter() + ") do not match."); 
		} else {
			for(int i=0;i<getNumArgument(); i++) 
				if(getArgument(i).type() != callee.getParameter(i).type())
					error("The " + i + "th argument has the wrong type.");
		}
	}
  /**
   * @ast method 
   * 
   */
  public Call() {
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
    setChild(new List(), 1);
  }
  /**
   * @ast method 
   * 
   */
  public Call(FunctionName p0, List<Expr> p1) {
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
   * Replaces the Callee child.
   * @param node The new node to replace the Callee child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setCallee(FunctionName node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Callee child.
   * @return The current node used as the Callee child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public FunctionName getCallee() {
    return (FunctionName)getChild(0);
  }
  /**
   * Retrieves the Callee child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Callee child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public FunctionName getCalleeNoTransform() {
    return (FunctionName)getChildNoTransform(0);
  }
  /**
   * Replaces the Argument list.
   * @param list The new list node to be used as the Argument list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setArgumentList(List<Expr> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Argument list.
   * @return Number of children in the Argument list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public int getNumArgument() {
    return getArgumentList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Argument list.
   * Calling this method will not trigger rewrites..
   * @return Number of children in the Argument list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public int getNumArgumentNoTransform() {
    return getArgumentListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Argument list..
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Argument list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Expr getArgument(int i) {
    return (Expr)getArgumentList().getChild(i);
  }
  /**
   * Append an element to the Argument list.
   * @param node The element to append to the Argument list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void addArgument(Expr node) {
    List<Expr> list = (parent == null || state == null) ? getArgumentListNoTransform() : getArgumentList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void addArgumentNoTransform(Expr node) {
    List<Expr> list = getArgumentListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Argument list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setArgument(Expr node, int i) {
    List<Expr> list = getArgumentList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Argument list.
   * @return The node representing the Argument list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public List<Expr> getArguments() {
    return getArgumentList();
  }
  /**
   * Retrieves the Argument list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Argument list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public List<Expr> getArgumentsNoTransform() {
    return getArgumentListNoTransform();
  }
  /**
   * Retrieves the Argument list.
   * @return The node representing the Argument list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Expr> getArgumentList() {
    List<Expr> list = (List<Expr>)getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Argument list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Argument list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Expr> getArgumentListNoTransform() {
    return (List<Expr>)getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  protected boolean getCallTarget_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean getCallTarget_computed = false;
  /**
   * @apilevel internal
   */
  protected FunctionDeclaration getCallTarget_value;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:212
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FunctionDeclaration getCallTarget() {
    if(getCallTarget_computed) {
      return getCallTarget_value;
    }
    if(getCallTarget_visited)
      throw new RuntimeException("Circular definition of attr: getCallTarget in class: ");
    getCallTarget_visited = true;
    getCallTarget_value = getCallTarget_compute();
      if(true) getCallTarget_computed = true;
    getCallTarget_visited = false;
    return getCallTarget_value;
  }
  /**
   * @apilevel internal
   */
  private FunctionDeclaration getCallTarget_compute() {  return getCallee().decl();  }
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:44
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
  private TypeDescriptor type_compute() {  return getCallTarget().getReturnType().getDescriptor();  }
}
