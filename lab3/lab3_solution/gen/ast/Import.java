/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production Import : {@link ASTNode} ::= <span class="component">&lt;Package:String&gt;</span> <span class="component">&lt;Name:String&gt;</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:5
 */
public class Import extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getQualifiedName_visited = false;
    getQualifiedName_computed = false;
    getQualifiedName_value = null;
    resolve_visited = false;
    resolve_computed = false;
    resolve_value = null;
    getModule_visited = false;
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
  public Import clone() throws CloneNotSupportedException {
    Import node = (Import)super.clone();
    node.getQualifiedName_visited = false;
    node.getQualifiedName_computed = false;
    node.getQualifiedName_value = null;
    node.resolve_visited = false;
    node.resolve_computed = false;
    node.resolve_value = null;
    node.getModule_visited = false;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Import copy() {
      try {
        Import node = (Import)clone();
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
  public Import fullCopy() {
    try {
      Import tree = (Import) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:31
   */
  public void namecheck() {
		if(resolve() == null)
			error("Module cannot be resolved: " + getQualifiedName());
		if(getQualifiedName().equals(getModule().getQualifiedName()))
			error("Modules cannot import themselves.");
	}
  /**
   * @ast method 
   * 
   */
  public Import() {
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
  public Import(String p0, String p1) {
    setPackage(p0);
    setName(p1);
  }
  /**
   * @ast method 
   * 
   */
  public Import(beaver.Symbol p0, beaver.Symbol p1) {
    setPackage(p0);
    setName(p1);
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
   * Replaces the lexeme Package.
   * @param value The new value for the lexeme Package.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setPackage(String value) {
    tokenString_Package = value;
  }
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  protected String tokenString_Package;
  /**
   * @ast method 
   * 
   */
  
  public int Packagestart;
  /**
   * @ast method 
   * 
   */
  
  public int Packageend;
  /**
   * JastAdd-internal setter for lexeme Package using the Beaver parser.
   * @apilevel internal
   * @ast method 
   * 
   */
  public void setPackage(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
      throw new UnsupportedOperationException("setPackage is only valid for String lexemes");
    tokenString_Package = (String)symbol.value;
    Packagestart = symbol.getStart();
    Packageend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Package.
   * @return The value for the lexeme Package.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public String getPackage() {
    return tokenString_Package != null ? tokenString_Package : "";
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
  protected boolean getQualifiedName_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean getQualifiedName_computed = false;
  /**
   * @apilevel internal
   */
  protected String getQualifiedName_value;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:8
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String getQualifiedName() {
    if(getQualifiedName_computed) {
      return getQualifiedName_value;
    }
    if(getQualifiedName_visited)
      throw new RuntimeException("Circular definition of attr: getQualifiedName in class: ");
    getQualifiedName_visited = true;
    getQualifiedName_value = getQualifiedName_compute();
      if(true) getQualifiedName_computed = true;
    getQualifiedName_visited = false;
    return getQualifiedName_value;
  }
  /**
   * @apilevel internal
   */
  private String getQualifiedName_compute() {  return getPackage().isEmpty() ? getName() : getPackage() + "." + getName();  }
  /**
   * @apilevel internal
   */
  protected boolean resolve_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean resolve_computed = false;
  /**
   * @apilevel internal
   */
  protected Module resolve_value;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:114
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Module resolve() {
    if(resolve_computed) {
      return resolve_value;
    }
    if(resolve_visited)
      throw new RuntimeException("Circular definition of attr: resolve in class: ");
    resolve_visited = true;
    resolve_value = resolve_compute();
      if(true) resolve_computed = true;
    resolve_visited = false;
    return resolve_value;
  }
  /**
   * @apilevel internal
   */
  private Module resolve_compute() {  return getProgram().resolveModule(getQualifiedName());  }
  /**
   * @apilevel internal
   */
  protected boolean getModule_visited = false;
  /**
   * @attribute inh
   * @aspect Namecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:30
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Module getModule() {
    if(getModule_visited)
      throw new RuntimeException("Circular definition of attr: getModule in class: ");
    getModule_visited = true;
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    Module getModule_value = getParent().Define_Module_getModule(this, null);
    getModule_visited = false;
    return getModule_value;
  }
}
