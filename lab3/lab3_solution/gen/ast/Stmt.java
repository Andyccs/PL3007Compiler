/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production Stmt : {@link ASTNode};
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:27
 */
public abstract class Stmt extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getEnclosingLoop_visited = false;
    getFunction_visited = false;
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
  public Stmt clone() throws CloneNotSupportedException {
    Stmt node = (Stmt)super.clone();
    node.getEnclosingLoop_visited = false;
    node.getFunction_visited = false;
    return node;
  }
  /**
   * @ast method 
   * @aspect Namecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:101
   */
  public abstract void namecheck();
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:46
   */
  public void typecheck() {}
  /**
   * @ast method 
   * 
   */
  public Stmt() {
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
   * @apilevel low-level
   * @ast method 
   * 
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   */
  protected boolean getEnclosingLoop_visited = false;
  /**
   * @attribute inh
   * @aspect ASTUtil
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:4
   */
  @SuppressWarnings({"unchecked", "cast"})
  public WhileStmt getEnclosingLoop() {
    if(getEnclosingLoop_visited)
      throw new RuntimeException("Circular definition of attr: getEnclosingLoop in class: ");
    getEnclosingLoop_visited = true;
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    WhileStmt getEnclosingLoop_value = getParent().Define_WhileStmt_getEnclosingLoop(this, null);
    getEnclosingLoop_visited = false;
    return getEnclosingLoop_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean getFunction_visited = false;
  /**
   * @attribute inh
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:72
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FunctionDeclaration getFunction() {
    if(getFunction_visited)
      throw new RuntimeException("Circular definition of attr: getFunction in class: ");
    getFunction_visited = true;
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    FunctionDeclaration getFunction_value = getParent().Define_FunctionDeclaration_getFunction(this, null);
    getFunction_visited = false;
    return getFunction_value;
  }
}
