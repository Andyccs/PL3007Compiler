/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production FieldDeclaration : {@link Declaration} ::= <span class="component">{@link VarDecl}</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:12
 */
public class FieldDeclaration extends Declaration implements Cloneable {
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
  public FieldDeclaration clone() throws CloneNotSupportedException {
    FieldDeclaration node = (FieldDeclaration)super.clone();
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FieldDeclaration copy() {
      try {
        FieldDeclaration node = (FieldDeclaration)clone();
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
  public FieldDeclaration fullCopy() {
    try {
      FieldDeclaration tree = (FieldDeclaration) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:59
   */
  public void namecheck() {
		getVarDecl().namecheck();
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:35
   */
  public void typecheck() {
		getVarDecl().typecheck();
	}
  /**
   * @ast method 
   * 
   */
  public FieldDeclaration() {
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
  public FieldDeclaration(Accessibility p0, VarDecl p1) {
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
   * Replaces the VarDecl child.
   * @param node The new node to replace the VarDecl child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setVarDecl(VarDecl node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the VarDecl child.
   * @return The current node used as the VarDecl child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public VarDecl getVarDecl() {
    return (VarDecl)getChild(1);
  }
  /**
   * Retrieves the VarDecl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the VarDecl child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public VarDecl getVarDeclNoTransform() {
    return (VarDecl)getChildNoTransform(1);
  }
}
