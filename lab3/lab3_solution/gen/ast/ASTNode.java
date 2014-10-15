/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production ASTNode;
 * @ast node
 * 
 */
public class ASTNode<T extends ASTNode> extends beaver.Symbol  implements Cloneable, Iterable<T> {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
  }
  /**
   * @apilevel internal
   */
  public void flushCollectionCache() {
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ASTNode<T> clone() throws CloneNotSupportedException {
    ASTNode node = (ASTNode)super.clone();
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ASTNode<T> copy() {
      try {
        ASTNode node = (ASTNode)clone();
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
  public ASTNode<T> fullCopy() {
    try {
      ASTNode tree = (ASTNode) clone();
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
   * @aspect ASTUtil
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:9
   */
  protected Program getProgram() {
		if(getParent() == null)
			return null;
		return getParent().getProgram();
	}
  /** Report an error from some node within the AST. * @ast method 
   * @aspect Errors
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/errors.jrag:31
   */
  public void error(String msg) {
		getProgram().error(msg, getLine(getStart()), getColumn(getStart()));
	}
  /**
   * @ast method 
   * 
   */
  public ASTNode() {
    super();

    init$Children();

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
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  public static final boolean generatedWithCircularEnabled = true;
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  public static final boolean generatedWithCacheCycle = true;
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  public static final boolean generatedWithComponentCheck = false;
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  protected static ASTNode$State state = new ASTNode$State();
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  public final ASTNode$State state() { return state; }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  @SuppressWarnings("cast")
  public T getChild(int i) {
    return (T)getChildNoTransform(i);
  }
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  private int childIndex;
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public int getIndexOfChild(ASTNode node) {
    if(node != null && node.childIndex < getNumChildNoTransform() && node == getChildNoTransform(node.childIndex))
      return node.childIndex;
    for(int i = 0; i < getNumChildNoTransform(); i++)
      if(getChildNoTransform(i) == node) {
        node.childIndex = i;
        return i;
      }
    return -1;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void addChild(T node) {
    setChild(node, getNumChildNoTransform());
  }
  /**
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @apilevel low-level
   * @ast method 
   * 
   */
  @SuppressWarnings("cast")
  public final T getChildNoTransform(int i) {
    return (T) (children != null ? children[i] : null);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  
  /**
   * @apilevel low-level
   */
  protected int numChildren;
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  protected int numChildren() {
    return numChildren;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public int getNumChild() {
    return numChildren();
  }
  /**
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @apilevel low-level
   * @ast method 
   * 
   */
  public final int getNumChildNoTransform() {
    return numChildren();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void setChild(ASTNode node, int i) {
    debugNodeAttachment(node);
    if(children == null) {
      children = new ASTNode[i+1>4?i+1:4];
    } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if(i >= numChildren) numChildren = i+1;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void insertChild(ASTNode node, int i) {
    debugNodeAttachment(node);
    if(children == null) {
      children = new ASTNode[i+1>4?i+1:4];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if(i < children.length) {
        System.arraycopy(children, i, c, i+1, children.length-i);
        for(int j = i+1; j < c.length; ++j) {
          if(c[j] != null)
            c[j].childIndex = j;
        }
      }
      children = c;
    }
    numChildren++;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void removeChild(int i) {
    if(children != null) {
      ASTNode child = (ASTNode)children[i];
      if(child != null) {
        child.setParent(null);
        child.childIndex = -1;
      }
      System.arraycopy(children, i+1, children, i, children.length-i-1);
      numChildren--;
      for(int j = i; j < numChildren; ++j) {
        if(children[j] != null) {
          child = (ASTNode) children[j];
          child.childIndex = j;
        }
      }
    }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public ASTNode getParent() {
    return (ASTNode)parent;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void setParent(ASTNode node) {
    parent = node;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  
  /**
   * @apilevel low-level
   */
  protected ASTNode parent;
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  
  /**
   * @apilevel low-level
   */
  protected ASTNode[] children;
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  protected boolean debugNodeAttachmentIsRoot() { return false; }
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  private static void debugNodeAttachment(ASTNode node) {
    if(node == null) throw new RuntimeException("Trying to assign null to a tree child node");
    while(node != null && !node.debugNodeAttachmentIsRoot()) {
      ASTNode parent = (ASTNode)node.parent;
      if(parent != null && parent.getIndexOfChild(node) == -1) return;
      node = parent;
    }
    if(node == null) return;
    throw new RuntimeException("Trying to insert the same tree at multiple tree locations");
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      private int counter = 0;
      public boolean hasNext() {
        return counter < getNumChild();
      }
      @SuppressWarnings("unchecked") public T next() {
        if(hasNext())
          return (T)getChild(counter++);
        else
          return null;
      }
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  /**
   * @apilevel internal
   */
  public Module Define_Module_getModule(ASTNode caller, ASTNode child) {
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    return getParent().Define_Module_getModule(this, caller);
  }
  /**
   * @apilevel internal
   */
  public VarDecl Define_VarDecl_lookupVar(ASTNode caller, ASTNode child, String name) {
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    return getParent().Define_VarDecl_lookupVar(this, caller, name);
  }
  /**
   * @apilevel internal
   */
  public TypeDeclaration Define_TypeDeclaration_lookupType(ASTNode caller, ASTNode child, String name) {
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    return getParent().Define_TypeDeclaration_lookupType(this, caller, name);
  }
  /**
   * @apilevel internal
   */
  public FunctionDeclaration Define_FunctionDeclaration_lookupFunction(ASTNode caller, ASTNode child, String name) {
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    return getParent().Define_FunctionDeclaration_lookupFunction(this, caller, name);
  }
  /**
   * @apilevel internal
   */
  public Scope Define_Scope_getScope(ASTNode caller, ASTNode child) {
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    return getParent().Define_Scope_getScope(this, caller);
  }
  /**
   * @apilevel internal
   */
  public WhileStmt Define_WhileStmt_getEnclosingLoop(ASTNode caller, ASTNode child) {
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    return getParent().Define_WhileStmt_getEnclosingLoop(this, caller);
  }
  /**
   * @apilevel internal
   */
  public FunctionDeclaration Define_FunctionDeclaration_getFunction(ASTNode caller, ASTNode child) {
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    return getParent().Define_FunctionDeclaration_getFunction(this, caller);
  }
}
