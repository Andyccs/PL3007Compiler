/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production Declaration : {@link ASTNode} ::= <span class="component">{@link Accessibility}</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:7
 */
public abstract class Declaration extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    isPublic_visited = false;
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
  public Declaration clone() throws CloneNotSupportedException {
    Declaration node = (Declaration)super.clone();
    node.isPublic_visited = false;
    return node;
  }
  /**
   * @ast method 
   * @aspect Namecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:38
   */
  public abstract void namecheck();
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:26
   */
  public void typecheck() {}
  /**
   * @ast method 
   * 
   */
  public Declaration() {
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
  public Declaration(Accessibility p0) {
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
   * @apilevel internal
   */
  protected boolean isPublic_visited = false;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:214
   */
  public boolean isPublic() {
    if(isPublic_visited)
      throw new RuntimeException("Circular definition of attr: isPublic in class: ");
    isPublic_visited = true;
    try {  return getAccessibility().getPublic();  }
    finally {
      isPublic_visited = false;
    }
  }
}
