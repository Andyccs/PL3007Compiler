/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production TypeDescriptor : {@link ASTNode};
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:71
 */
public abstract class TypeDescriptor extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    isArrayType_visited = false;
    isBoolean_visited = false;
    isNumeric_visited = false;
    isVoid_visited = false;
    arrayType_visited = false;
    arrayType_computed = false;
    arrayType_value = null;
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
  public TypeDescriptor clone() throws CloneNotSupportedException {
    TypeDescriptor node = (TypeDescriptor)super.clone();
    node.isArrayType_visited = false;
    node.isBoolean_visited = false;
    node.isNumeric_visited = false;
    node.isVoid_visited = false;
    node.arrayType_visited = false;
    node.arrayType_computed = false;
    node.arrayType_value = null;
    return node;
  }
  /** Singleton instances of types int, boolean and void. * @ast method 
   * @aspect types
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:4
   */
  
	/** Singleton instances of types int, boolean and void. */
	public static final IntType INT = new IntType();
  /**
   * @ast method 
   * @aspect types
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:5
   */
  
	public static final BooleanType BOOLEAN = new BooleanType();
  /**
   * @ast method 
   * @aspect types
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:6
   */
  
	public static final VoidType VOID = new VoidType();
  /** Type descriptors for Java types. * @ast method 
   * @aspect types
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:12
   */
  

	/** Type descriptors for Java types. */
	private static final HashMap<String, TypeDescriptor> javaTypeDescriptors = new HashMap<String, TypeDescriptor>();
  /**
   * @ast method 
   * @aspect types
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:13
   */
  public static final TypeDescriptor forJavaType(String name) {
		TypeDescriptor desc = javaTypeDescriptors.get(name);
		if(desc == null)
			javaTypeDescriptors.put(name, desc = new JavaType(name));
		return desc;
	}
  /**
   * @ast method 
   * 
   */
  public TypeDescriptor() {
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
    try {  return false;  }
    finally {
      isArrayType_visited = false;
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean isBoolean_visited = false;
  /**
   * @attribute syn
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:7
   */
  public boolean isBoolean() {
    if(isBoolean_visited)
      throw new RuntimeException("Circular definition of attr: isBoolean in class: ");
    isBoolean_visited = true;
    try {  return false;  }
    finally {
      isBoolean_visited = false;
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean isNumeric_visited = false;
  /**
   * @attribute syn
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:10
   */
  public boolean isNumeric() {
    if(isNumeric_visited)
      throw new RuntimeException("Circular definition of attr: isNumeric in class: ");
    isNumeric_visited = true;
    try {  return false;  }
    finally {
      isNumeric_visited = false;
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean isVoid_visited = false;
  /**
   * @attribute syn
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:13
   */
  public boolean isVoid() {
    if(isVoid_visited)
      throw new RuntimeException("Circular definition of attr: isVoid in class: ");
    isVoid_visited = true;
    try {  return false;  }
    finally {
      isVoid_visited = false;
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean arrayType_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean arrayType_computed = false;
  /**
   * @apilevel internal
   */
  protected ArrayType arrayType_value;
  /** Lazily create array type for an existing type. * @attribute syn
   * @aspect types
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/types.jrag:9
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ArrayType arrayType() {
    if(arrayType_computed) {
      return arrayType_value;
    }
    if(arrayType_visited)
      throw new RuntimeException("Circular definition of attr: arrayType in class: ");
    arrayType_visited = true;
    arrayType_value = arrayType_compute();
      if(true) arrayType_computed = true;
    arrayType_visited = false;
    return arrayType_value;
  }
  /**
   * @apilevel internal
   */
  private ArrayType arrayType_compute() {  return new ArrayType(this);  }
}
