/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production LocalVarDecl : {@link VarDecl};
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:16
 */
public class LocalVarDecl extends VarDecl implements Cloneable {
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
  public LocalVarDecl clone() throws CloneNotSupportedException {
    LocalVarDecl node = (LocalVarDecl)super.clone();
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public LocalVarDecl copy() {
      try {
        LocalVarDecl node = (LocalVarDecl)clone();
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
  public LocalVarDecl fullCopy() {
    try {
      LocalVarDecl tree = (LocalVarDecl) clone();
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
   * 
   */
  public LocalVarDecl() {
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
  public LocalVarDecl(TypeName p0, String p1) {
    setChild(p0, 0);
    setName(p1);
  }
  /**
   * @ast method 
   * 
   */
  public LocalVarDecl(TypeName p0, beaver.Symbol p1) {
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
}
