/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production TypeDeclaration : {@link Declaration} ::= <span class="component">&lt;Name:String&gt;</span> <span class="component">&lt;JavaType:String&gt;</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:13
 */
public class TypeDeclaration extends Declaration implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    lookupType_String_visited = null;
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
  public TypeDeclaration clone() throws CloneNotSupportedException {
    TypeDeclaration node = (TypeDeclaration)super.clone();
    node.lookupType_String_visited = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDeclaration copy() {
      try {
        TypeDeclaration node = (TypeDeclaration)clone();
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
  public TypeDeclaration fullCopy() {
    try {
      TypeDeclaration tree = (TypeDeclaration) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:64
   */
  public void namecheck() {
		/* TODO: check that there aren't multiple types with the same name (hint: use lookupType) */
		
		TypeDeclaration DuplicateType = lookupType(getName());
		
		if(DuplicateType != null && 
		DuplicateType != this && 
		DuplicateType.getParent()==this.getParent())
		
			error("The name " + DuplicateType + " has multiple types, please check your program.");
	}
  /**
   * @ast method 
   * 
   */
  public TypeDeclaration() {
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
  public TypeDeclaration(Accessibility p0, String p1, String p2) {
    setChild(p0, 0);
    setName(p1);
    setJavaType(p2);
  }
  /**
   * @ast method 
   * 
   */
  public TypeDeclaration(Accessibility p0, beaver.Symbol p1, beaver.Symbol p2) {
    setChild(p0, 0);
    setName(p1);
    setJavaType(p2);
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
   * Replaces the Accessibility child.
   * @param node The new node to replace the Accessibility child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setAccessibility(Accessibility node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Accessibility child.
   * @return The current node used as the Accessibility child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Accessibility getAccessibility() {
    return (Accessibility)getChild(0);
  }
  /**
   * Retrieves the Accessibility child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Accessibility child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public Accessibility getAccessibilityNoTransform() {
    return (Accessibility)getChildNoTransform(0);
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
   * Replaces the lexeme JavaType.
   * @param value The new value for the lexeme JavaType.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setJavaType(String value) {
    tokenString_JavaType = value;
  }
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  protected String tokenString_JavaType;
  /**
   * @ast method 
   * 
   */
  
  public int JavaTypestart;
  /**
   * @ast method 
   * 
   */
  
  public int JavaTypeend;
  /**
   * JastAdd-internal setter for lexeme JavaType using the Beaver parser.
   * @apilevel internal
   * @ast method 
   * 
   */
  public void setJavaType(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
      throw new UnsupportedOperationException("setJavaType is only valid for String lexemes");
    tokenString_JavaType = (String)symbol.value;
    JavaTypestart = symbol.getStart();
    JavaTypeend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme JavaType.
   * @return The value for the lexeme JavaType.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public String getJavaType() {
    return tokenString_JavaType != null ? tokenString_JavaType : "";
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupType_String_visited;
  /**
   * @attribute inh
   * @aspect Namecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:63
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDeclaration lookupType(String name) {
    Object _parameters = name;
    if(lookupType_String_visited == null) lookupType_String_visited = new java.util.HashSet(4);
    if(lookupType_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: lookupType in class: ");
    lookupType_String_visited.add(_parameters);
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    TypeDeclaration lookupType_String_value = getParent().Define_TypeDeclaration_lookupType(this, null, name);
    lookupType_String_visited.remove(_parameters);
    return lookupType_String_value;
  }
}
