/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production ArrayType : {@link TypeDescriptor} ::= <span class="component">ElementType:{@link TypeDescriptor}</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:75
 */
public class ArrayType extends TypeDescriptor implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    isArrayType_visited = false;
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
  public ArrayType clone() throws CloneNotSupportedException {
    ArrayType node = (ArrayType)super.clone();
    node.isArrayType_visited = false;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ArrayType copy() {
      try {
        ArrayType node = (ArrayType)clone();
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
  public ArrayType fullCopy() {
    try {
      ArrayType tree = (ArrayType) clone();
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
  public ArrayType() {
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
  public ArrayType(TypeDescriptor p0) {
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
   * Replaces the ElementType child.
   * @param node The new node to replace the ElementType child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setElementType(TypeDescriptor node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the ElementType child.
   * @return The current node used as the ElementType child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public TypeDescriptor getElementType() {
    return (TypeDescriptor)getChild(0);
  }
  /**
   * Retrieves the ElementType child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the ElementType child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public TypeDescriptor getElementTypeNoTransform() {
    return (TypeDescriptor)getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  protected boolean isArrayType_visited = false;
  /**
   * @attribute syn
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:4
   */
  public boolean isArrayType() {
    if(isArrayType_visited)
      throw new RuntimeException("Circular definition of attr: isArrayType in class: ");
    isArrayType_visited = true;
    try {  return true;  }
    finally {
      isArrayType_visited = false;
    }
  }
}
