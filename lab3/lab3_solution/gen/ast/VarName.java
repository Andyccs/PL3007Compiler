/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production VarName : {@link LHSExpr} ::= <span class="component">&lt;Name:String&gt;</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:40
 */
public class VarName extends LHSExpr implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    decl_visited = false;
    decl_computed = false;
    decl_value = null;
    type_visited = false;
    type_computed = false;
    type_value = null;
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
  public VarName clone() throws CloneNotSupportedException {
    VarName node = (VarName)super.clone();
    node.decl_visited = false;
    node.decl_computed = false;
    node.decl_value = null;
    node.type_visited = false;
    node.type_computed = false;
    node.type_value = null;
    node.lookupVar_String_visited = null;
    node.lookupVar_String_values = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VarName copy() {
      try {
        VarName node = (VarName)clone();
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
  public VarName fullCopy() {
    try {
      VarName tree = (VarName) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:140
   */
  public void namecheck() {
		/* TODO: check that the variable can be resolved */
		
		if(decl() == null)	error("The variable '" + getName() + "' cannot be resolved ");
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:99
   */
  public void typecheck() {
	}
  /**
   * @ast method 
   * 
   */
  public VarName() {
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
  public VarName(String p0) {
    setName(p0);
  }
  /**
   * @ast method 
   * 
   */
  public VarName(beaver.Symbol p0) {
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
   * @apilevel internal
   */
  protected boolean decl_computed = false;
  /**
   * @apilevel internal
   */
  protected VarDecl decl_value;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:12
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VarDecl decl() {
    if(decl_computed) {
      return decl_value;
    }
    if(decl_visited)
      throw new RuntimeException("Circular definition of attr: decl in class: ");
    decl_visited = true;
    decl_value = decl_compute();
      if(true) decl_computed = true;
    decl_visited = false;
    return decl_value;
  }
  /**
   * @apilevel internal
   */
  private VarDecl decl_compute() {  return lookupVar(getName());  }
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:41
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
  private TypeDescriptor type_compute() {  return decl().getTypeName().getDescriptor();  }
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupVar_String_visited;
  protected java.util.Map lookupVar_String_values;
  /**
   * @attribute inh
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:15
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
}
