/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production TypeName : {@link ASTNode};
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:19
 */
public abstract class TypeName extends ASTNode<ASTNode> implements Cloneable {
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
  public TypeName clone() throws CloneNotSupportedException {
    TypeName node = (TypeName)super.clone();
    return node;
  }
  /**
   * @ast method 
   * @aspect Namecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:93
   */
  public void namecheck() {}
  /**
   * @ast method 
   * @aspect Runtime
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/runtime.jrag:3
   */
  public static TypeName forClass(Class<?> klass) {
		String name = klass.getCanonicalName();
		if("void".equals(name))
			return new VoidTypeName();
		else if("int".equals(name))
			return new IntTypeName();
		else if("boolean".equals(name))
			return new BooleanTypeName();
		else
			return new JavaTypeName(name);
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:182
   */
  public void typecheck() {}
  /**
   * @ast method 
   * 
   */
  public TypeName() {
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
  /** Determine type descriptor for type name. * @attribute syn
   * @aspect types
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:21
   */
  @SuppressWarnings({"unchecked", "cast"})
  public abstract TypeDescriptor getDescriptor();
}
