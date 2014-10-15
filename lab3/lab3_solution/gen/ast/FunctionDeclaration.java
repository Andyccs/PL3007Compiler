/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production FunctionDeclaration : {@link Declaration} ::= <span class="component">ReturnType:{@link TypeName}</span> <span class="component">&lt;Name:String&gt;</span> <span class="component">{@link Parameter}*</span> <span class="component">Body:{@link Block}</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:11
 */
public class FunctionDeclaration extends Declaration implements Cloneable, Scope {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getModule_visited = false;
    lookupFunction_String_visited = null;
    lookupVar_String_visited = null;
    lookupVar_String_values = null;
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
  public FunctionDeclaration clone() throws CloneNotSupportedException {
    FunctionDeclaration node = (FunctionDeclaration)super.clone();
    node.getModule_visited = false;
    node.lookupFunction_String_visited = null;
    node.lookupVar_String_visited = null;
    node.lookupVar_String_values = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FunctionDeclaration copy() {
      try {
        FunctionDeclaration node = (FunctionDeclaration)clone();
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
  public FunctionDeclaration fullCopy() {
    try {
      FunctionDeclaration tree = (FunctionDeclaration) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:41
   */
  public void namecheck() {

		/* TODO: check that there aren't multiple functions with the same name (hint: use lookupFunction) */
		
		getReturnType().namecheck();
		for(Parameter parm : getParameters())
			parm.namecheck();
		getBody().namecheck();
			
		FunctionDeclaration DuplicateName = lookupFunction(getName());
		
		if(DuplicateName != this && 
			DuplicateName != null){
			
			error("Duplicate declaration for function " + DuplicateName);
		}
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:28
   */
  public void typecheck() {
		getReturnType().typecheck();
		for(Parameter parm : getParameters())
			parm.typecheck();
		getBody().typecheck();
	}
  /**
   * @ast method 
   * 
   */
  public FunctionDeclaration() {
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
    children = new ASTNode[4];
    setChild(new List(), 2);
  }
  /**
   * @ast method 
   * 
   */
  public FunctionDeclaration(Accessibility p0, TypeName p1, String p2, List<Parameter> p3, Block p4) {
    setChild(p0, 0);
    setChild(p1, 1);
    setName(p2);
    setChild(p3, 2);
    setChild(p4, 3);
  }
  /**
   * @ast method 
   * 
   */
  public FunctionDeclaration(Accessibility p0, TypeName p1, beaver.Symbol p2, List<Parameter> p3, Block p4) {
    setChild(p0, 0);
    setChild(p1, 1);
    setName(p2);
    setChild(p3, 2);
    setChild(p4, 3);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  protected int numChildren() {
    return 4;
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
   * Replaces the ReturnType child.
   * @param node The new node to replace the ReturnType child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setReturnType(TypeName node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the ReturnType child.
   * @return The current node used as the ReturnType child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public TypeName getReturnType() {
    return (TypeName)getChild(1);
  }
  /**
   * Retrieves the ReturnType child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the ReturnType child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public TypeName getReturnTypeNoTransform() {
    return (TypeName)getChildNoTransform(1);
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
   * Replaces the Parameter list.
   * @param list The new list node to be used as the Parameter list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setParameterList(List<Parameter> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the Parameter list.
   * @return Number of children in the Parameter list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public int getNumParameter() {
    return getParameterList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Parameter list.
   * Calling this method will not trigger rewrites..
   * @return Number of children in the Parameter list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public int getNumParameterNoTransform() {
    return getParameterListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Parameter list..
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Parameter list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Parameter getParameter(int i) {
    return (Parameter)getParameterList().getChild(i);
  }
  /**
   * Append an element to the Parameter list.
   * @param node The element to append to the Parameter list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void addParameter(Parameter node) {
    List<Parameter> list = (parent == null || state == null) ? getParameterListNoTransform() : getParameterList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void addParameterNoTransform(Parameter node) {
    List<Parameter> list = getParameterListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Parameter list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setParameter(Parameter node, int i) {
    List<Parameter> list = getParameterList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Parameter list.
   * @return The node representing the Parameter list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public List<Parameter> getParameters() {
    return getParameterList();
  }
  /**
   * Retrieves the Parameter list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Parameter list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public List<Parameter> getParametersNoTransform() {
    return getParameterListNoTransform();
  }
  /**
   * Retrieves the Parameter list.
   * @return The node representing the Parameter list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Parameter> getParameterList() {
    List<Parameter> list = (List<Parameter>)getChild(2);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Parameter list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Parameter list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Parameter> getParameterListNoTransform() {
    return (List<Parameter>)getChildNoTransform(2);
  }
  /**
   * Replaces the Body child.
   * @param node The new node to replace the Body child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setBody(Block node) {
    setChild(node, 3);
  }
  /**
   * Retrieves the Body child.
   * @return The current node used as the Body child.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public Block getBody() {
    return (Block)getChild(3);
  }
  /**
   * Retrieves the Body child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Body child.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public Block getBodyNoTransform() {
    return (Block)getChildNoTransform(3);
  }
  /**
   * @apilevel internal
   */
  protected boolean getModule_visited = false;
  /**
   * @attribute inh
   * @aspect ASTUtil
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:29
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Module getModule() {
    if(getModule_visited)
      throw new RuntimeException("Circular definition of attr: getModule in class: ");
    getModule_visited = true;
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    Module getModule_value = getParent().Define_Module_getModule(this, null);
    getModule_visited = false;
    return getModule_value;
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupFunction_String_visited;
  /**
   * @attribute inh
   * @aspect Namecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:40
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FunctionDeclaration lookupFunction(String name) {
    Object _parameters = name;
    if(lookupFunction_String_visited == null) lookupFunction_String_visited = new java.util.HashSet(4);
    if(lookupFunction_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: lookupFunction in class: ");
    lookupFunction_String_visited.add(_parameters);
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    FunctionDeclaration lookupFunction_String_value = getParent().Define_FunctionDeclaration_lookupFunction(this, null, name);
    lookupFunction_String_visited.remove(_parameters);
    return lookupFunction_String_value;
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupVar_String_visited;
  protected java.util.Map lookupVar_String_values;
  /**
   * @attribute inh
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:17
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VarDecl lookupVar(String name) {
    Object _parameters = name;
    if(lookupVar_String_visited == null) lookupVar_String_visited = new java.util.HashSet(4);
    if(lookupVar_String_values == null) lookupVar_String_values = new java.util.HashMap(4);
    if(lookupVar_String_values.containsKey(_parameters)) {
      return (VarDecl)lookupVar_String_values.get(_parameters);
    }
    if(lookupVar_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: lookupVar in class: ");
    lookupVar_String_visited.add(_parameters);
    if(getParent() == null) throw new RuntimeException("Trying to evaluate attribute in subtree not attached to main tree");
    VarDecl lookupVar_String_value = getParent().Define_VarDecl_lookupVar(this, null, name);
      if(true) lookupVar_String_values.put(_parameters, lookupVar_String_value);
    lookupVar_String_visited.remove(_parameters);
    return lookupVar_String_value;
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:5
   * @apilevel internal
   */
  public WhileStmt Define_WhileStmt_getEnclosingLoop(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:43
   * @apilevel internal
   */
  public VarDecl Define_VarDecl_lookupVar(ASTNode caller, ASTNode child, String name) {
     { 
   int childIndex = this.getIndexOfChild(caller);
{
		for(Parameter parm : getParameters()){
			if(parm.getName().equals(name))
				return parm;
		}
		return this.lookupVar(name);
	}
    }
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:73
   * @apilevel internal
   */
  public FunctionDeclaration Define_FunctionDeclaration_getFunction(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return this;
    }
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:26
   * @apilevel internal
   */
  public Scope Define_Scope_getScope(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return this;
    }
  }
}
