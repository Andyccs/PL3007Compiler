/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production Block : {@link Stmt} ::= <span class="component">{@link Stmt}*</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:31
 */
public class Block extends Stmt implements Cloneable, Scope {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    lookupVar_String_visited = null;
    lookupVar_String_values = null;
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
  public Block clone() throws CloneNotSupportedException {
    Block node = (Block)super.clone();
    node.lookupVar_String_visited = null;
    node.lookupVar_String_values = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Block copy() {
      try {
        Block node = (Block)clone();
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
  public Block fullCopy() {
    try {
      Block tree = (Block) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:103
   */
  public void namecheck() {
		for(Stmt stmt : getStmts())
			stmt.namecheck();
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:52
   */
  public void typecheck() {
		for(Stmt stmt : getStmts())
			stmt.typecheck();
	}
  /**
   * @ast method 
   * 
   */
  public Block() {
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
  public Block(List<Stmt> p0) {
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
   * Replaces the Stmt list.
   * @param list The new list node to be used as the Stmt list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setStmtList(List<Stmt> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Stmt list.
   * @return Number of children in the Stmt list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public int getNumStmt() {
    return getStmtList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Stmt list.
   * Calling this method will not trigger rewrites..
   * @return Number of children in the Stmt list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public int getNumStmtNoTransform() {
    return getStmtListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Stmt list..
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Stmt list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Stmt getStmt(int i) {
    return (Stmt)getStmtList().getChild(i);
  }
  /**
   * Append an element to the Stmt list.
   * @param node The element to append to the Stmt list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void addStmt(Stmt node) {
    List<Stmt> list = (parent == null || state == null) ? getStmtListNoTransform() : getStmtList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void addStmtNoTransform(Stmt node) {
    List<Stmt> list = getStmtListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Stmt list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setStmt(Stmt node, int i) {
    List<Stmt> list = getStmtList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Stmt list.
   * @return The node representing the Stmt list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public List<Stmt> getStmts() {
    return getStmtList();
  }
  /**
   * Retrieves the Stmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmt list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public List<Stmt> getStmtsNoTransform() {
    return getStmtListNoTransform();
  }
  /**
   * Retrieves the Stmt list.
   * @return The node representing the Stmt list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Stmt> getStmtList() {
    List<Stmt> list = (List<Stmt>)getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Stmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmt list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Stmt> getStmtListNoTransform() {
    return (List<Stmt>)getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupVar_String_visited;
  protected java.util.Map lookupVar_String_values;
  /**
   * @attribute inh
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:16
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VarDecl lookupVar(String name) {
    Object _parameters = name;
    if(lookupVar_String_visited == null) lookupVar_String_visited = new java.util.HashSet(4);
    if(lookupVar_String_values == null) lookupVar_String_values = new java.util.HashMap(4);
    if(lookupVar_String_values.containsKey(_parameters)) {
      return (VarDecl)lookupVar_String_values.get(_parameters);
    }
    if(lookupVar_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: lookupVar in class: ");
    lookupVar_String_visited.add(_parameters);
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    VarDecl lookupVar_String_value = getParent().Define_VarDecl_lookupVar(this, null, name);
      if(true) lookupVar_String_values.put(_parameters, lookupVar_String_value);
    lookupVar_String_visited.remove(_parameters);
    return lookupVar_String_value;
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:20
   * @apilevel internal
   */
  public VarDecl Define_VarDecl_lookupVar(ASTNode caller, ASTNode child, String name) {
    if(caller == getStmtListNoTransform()) { 
   int j = caller.getIndexOfChild(child);
{
		/* TODO: Implement lookup of a variable within a block.
		 * 
		 *       Note that only variables declared before statement j should be taken
		 *       into account. If the variable is not found within this block, lookup
		 *       should continue with the parent node (as shown in the lecture).
		 */
		 
		 for (int c = 0; c < j; ++c)
		 {
		 	Stmt statment = this.getStmt(c);
		 	
			if (statment instanceof VarDeclStmt) 
			{
				VarDecl decl = ((VarDeclStmt) statment).getVarDecl();
				if (decl.getName().equals(name))
						return decl;
		 	}
		 }
		 return this.lookupVar(name);
	}
}
    else {    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
      return getParent().Define_VarDecl_lookupVar(this, caller, name);
    }
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:26
   * @apilevel internal
   */
  public Scope Define_Scope_getScope(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return this;
    }
  }
}
