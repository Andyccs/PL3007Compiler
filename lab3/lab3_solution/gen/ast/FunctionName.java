/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production FunctionName : {@link ASTNode} ::= <span class="component">&lt;Name:String&gt;</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:69
 */
public class FunctionName extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    decl_visited = false;
    lookupFunction_String_visited = null;
    lookupFunction_String_values = null;
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
  public FunctionName clone() throws CloneNotSupportedException {
    FunctionName node = (FunctionName)super.clone();
    node.decl_visited = false;
    node.lookupFunction_String_visited = null;
    node.lookupFunction_String_values = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FunctionName copy() {
      try {
        FunctionName node = (FunctionName)clone();
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
  public FunctionName fullCopy() {
    try {
      FunctionName tree = (FunctionName) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:178
   */
  public void namecheck() {
		/* TODO: check that the function can be resolved */
		
		if(decl() == null)	error("The function '" + getName() + "()'cannot be resolved ");
	}
  /**
   * @ast method 
   * 
   */
  public FunctionName() {
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
  public FunctionName(String p0) {
    setName(p0);
  }
  /**
   * @ast method 
   * 
   */
  public FunctionName(beaver.Symbol p0) {
    setName(p0);
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
  protected boolean decl_visited = false;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:165
   */
  public FunctionDeclaration decl() {
    if(decl_visited)
      throw new RuntimeException("Circular definition of attr: decl in class: ");
    decl_visited = true;
    try {  return lookupFunction(getName());  }
    finally {
      decl_visited = false;
    }
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupFunction_String_visited;
  protected java.util.Map lookupFunction_String_values;
  /**
   * @attribute inh
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:167
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FunctionDeclaration lookupFunction(String name) {
    Object _parameters = name;
    if(lookupFunction_String_visited == null) lookupFunction_String_visited = new java.util.HashSet(4);
    if(lookupFunction_String_values == null) lookupFunction_String_values = new java.util.HashMap(4);
    if(lookupFunction_String_values.containsKey(_parameters)) {
      return (FunctionDeclaration)lookupFunction_String_values.get(_parameters);
    }
    if(lookupFunction_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: lookupFunction in class: ");
    lookupFunction_String_visited.add(_parameters);
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    FunctionDeclaration lookupFunction_String_value = getParent().Define_FunctionDeclaration_lookupFunction(this, null, name);
      if(true) lookupFunction_String_values.put(_parameters, lookupFunction_String_value);
    lookupFunction_String_visited.remove(_parameters);
    return lookupFunction_String_value;
  }
}
