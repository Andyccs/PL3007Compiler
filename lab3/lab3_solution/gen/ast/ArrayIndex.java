/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production ArrayIndex : {@link LHSExpr} ::= <span class="component">Base:{@link Expr}</span> <span class="component">Index:{@link Expr}</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:41
 */
public class ArrayIndex extends LHSExpr implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    type_visited = false;
    type_computed = false;
    type_value = null;
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
  public ArrayIndex clone() throws CloneNotSupportedException {
    ArrayIndex node = (ArrayIndex)super.clone();
    node.type_visited = false;
    node.type_computed = false;
    node.type_value = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ArrayIndex copy() {
      try {
        ArrayIndex node = (ArrayIndex)clone();
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
  public ArrayIndex fullCopy() {
    try {
      ArrayIndex tree = (ArrayIndex) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:146
   */
  public void namecheck() {
		getBase().namecheck();
		getIndex().namecheck();
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:103
   */
  public void typecheck() {
		getBase().typecheck();
		getIndex().typecheck();
		
		if(!getBase().type().isArrayType())
			error("Base expression of array index should be of array type.");
		if(!getIndex().type().isNumeric())
			error("Index expression of array index should be of integer type.");
	}
  /**
   * @ast method 
   * 
   */
  public ArrayIndex() {
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
  public ArrayIndex(Expr p0, Expr p1) {
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
   * Replaces the Base child.
   * @param node The new node to replace the Base child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setBase(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Base child.
   * @return The current node used as the Base child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Expr getBase() {
    return (Expr)getChild(0);
  }
  /**
   * Retrieves the Base child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Base child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public Expr getBaseNoTransform() {
    return (Expr)getChildNoTransform(0);
  }
  /**
   * Replaces the Index child.
   * @param node The new node to replace the Index child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setIndex(Expr node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Index child.
   * @return The current node used as the Index child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Expr getIndex() {
    return (Expr)getChild(1);
  }
  /**
   * Retrieves the Index child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Index child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public Expr getIndexNoTransform() {
    return (Expr)getChildNoTransform(1);
  }
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:42
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
  private TypeDescriptor type_compute() {  return ((ArrayType)getBase().type()).getElementType();  }
}
