/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production VarDecl : {@link ASTNode} ::= <span class="component">{@link TypeName}</span> <span class="component">&lt;Name:String&gt;</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:15
 */
public class VarDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getScope_visited = false;
    lookupVar_String_visited = null;
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
  public VarDecl clone() throws CloneNotSupportedException {
    VarDecl node = (VarDecl)super.clone();
    node.getScope_visited = false;
    node.lookupVar_String_visited = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VarDecl copy() {
      try {
        VarDecl node = (VarDecl)clone();
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
  public VarDecl fullCopy() {
    try {
      VarDecl tree = (VarDecl) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:77
   */
  public void namecheck() {
		getTypeName().namecheck();
		
		/* TODO: check that there aren't multiple variables with the same name (hint: use lookupVar);
		 *       however, only report an error if there are multiple variables within the same scope 
		 *       (hint: use getScope) */
		 	 
		VarDecl DuplicateVariable = lookupVar(getName());
		
		if(DuplicateVariable != null && 
		DuplicateVariable != this && 
		DuplicateVariable.getScope() == this.getScope())
		
			error("Multiple variables have the same name '" + DuplicateVariable + "'");
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:40
   */
  public void typecheck() {
		getTypeName().typecheck();
		if(getTypeName().getDescriptor().isVoid())
			error("Cannot declare variable of type void.");
	}
  /**
   * @ast method 
   * 
   */
  public VarDecl() {
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
  public VarDecl(TypeName p0, String p1) {
    setChild(p0, 0);
    setName(p1);
  }
  /**
   * @ast method 
   * 
   */
  public VarDecl(TypeName p0, beaver.Symbol p1) {
    setChild(p0, 0);
    setName(p1);
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
   * Replaces the TypeName child.
   * @param node The new node to replace the TypeName child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setTypeName(TypeName node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the TypeName child.
   * @return The current node used as the TypeName child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public TypeName getTypeName() {
    return (TypeName)getChild(0);
  }
  /**
   * Retrieves the TypeName child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the TypeName child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public TypeName getTypeNameNoTransform() {
    return (TypeName)getChildNoTransform(0);
  }
  /**
   * Replaces the lexeme Name.
   * @param value The new value for the lexeme Name.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setName(String value) {
    tokenString_Name = value;
  }
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  protected String tokenString_Name;
  /**
   * @ast method 
   * 
   */
  
  public int Namestart;
  /**
   * @ast method 
   * 
   */
  
  public int Nameend;
  /**
   * JastAdd-internal setter for lexeme Name using the Beaver parser.
   * @apilevel internal
   * @ast method 
   * 
   */
  public void setName(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
      throw new UnsupportedOperationException("setName is only valid for String lexemes");
    tokenString_Name = (String)symbol.value;
    Namestart = symbol.getStart();
    Nameend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Name.
   * @return The value for the lexeme Name.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public String getName() {
    return tokenString_Name != null ? tokenString_Name : "";
  }
  /**
   * @apilevel internal
   */
  protected boolean getScope_visited = false;
  /**
   * @attribute inh
   * @aspect ASTUtil
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:25
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Scope getScope() {
    if(getScope_visited)
      throw new RuntimeException("Circular definition of attr: getScope in class: ");
    getScope_visited = true;
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    Scope getScope_value = getParent().Define_Scope_getScope(this, null);
    getScope_visited = false;
    return getScope_value;
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupVar_String_visited;
  /**
   * @attribute inh
   * @aspect Namecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:76
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VarDecl lookupVar(String name) {
    Object _parameters = name;
    if(lookupVar_String_visited == null) lookupVar_String_visited = new java.util.HashSet(4);
    if(lookupVar_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: lookupVar in class: ");
    lookupVar_String_visited.add(_parameters);
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    VarDecl lookupVar_String_value = getParent().Define_VarDecl_lookupVar(this, null, name);
    lookupVar_String_visited.remove(_parameters);
    return lookupVar_String_value;
  }
}
