/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Module}*</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:1
 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    resolveModule_String_visited = null;
    resolveModule_String_values = null;
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
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program)super.clone();
    node.resolveModule_String_visited = null;
    node.resolveModule_String_values = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Program copy() {
      try {
        Program node = (Program)clone();
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
  public Program fullCopy() {
    try {
      Program tree = (Program) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:14
   */
  protected Program getProgram() {
		return this;
	}
  /** Compiler errors are stored in a list at the program root. * @ast method 
   * @aspect Errors
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/errors.jrag:23
   */
  

	/** Compiler errors are stored in a list at the program root. */
	private ArrayList<CompilerError> errors = new ArrayList<CompilerError>();
  /** Enter a new error into the list. * @ast method 
   * @aspect Errors
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/errors.jrag:26
   */
  protected void error(String msg, int line, int column) {
		errors.add(new CompilerError(msg, line, column));
	}
  /** Provide access to the list of compiler errors. * @ast method 
   * @aspect Errors
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/errors.jrag:36
   */
  public Iterable<CompilerError> getErrors() {
		return errors;
	}
  /** Check whether any errors have been reported. * @ast method 
   * @aspect Errors
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/errors.jrag:41
   */
  public boolean hasErrors() {
		return !errors.isEmpty();
	}
  /**
   * @ast method 
   * @aspect Namecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:7
   */
  public void namecheck() {
		// check for name clashes on modules
		Set<String> module_names = new HashSet<String>();
		for(Module module : getModules()) {
			if(!module_names.add(module.getQualifiedName()))
				error("Multiple modules with name " + module.getQualifiedName());
			module.namecheck();
		}
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:16
   */
  public void typecheck() {
		for(Module module : getModules())
			module.typecheck();
	}
  /**
   * @ast method 
   * 
   */
  public Program() {
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
    setChild(new List(), 0);
  }
  /**
   * @ast method 
   * 
   */
  public Program(List<Module> p0) {
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
   * @apilevel internal
   * @ast method 
   * 
   */
  protected boolean debugNodeAttachmentIsRoot() { return true; }
  /**
   * Replaces the Module list.
   * @param list The new list node to be used as the Module list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setModuleList(List<Module> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Module list.
   * @return Number of children in the Module list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public int getNumModule() {
    return getModuleList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Module list.
   * Calling this method will not trigger rewrites..
   * @return Number of children in the Module list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public int getNumModuleNoTransform() {
    return getModuleListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Module list..
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Module list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Module getModule(int i) {
    return (Module)getModuleList().getChild(i);
  }
  /**
   * Append an element to the Module list.
   * @param node The element to append to the Module list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void addModule(Module node) {
    List<Module> list = (parent == null || state == null) ? getModuleListNoTransform() : getModuleList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void addModuleNoTransform(Module node) {
    List<Module> list = getModuleListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Module list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setModule(Module node, int i) {
    List<Module> list = getModuleList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Module list.
   * @return The node representing the Module list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public List<Module> getModules() {
    return getModuleList();
  }
  /**
   * Retrieves the Module list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Module list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public List<Module> getModulesNoTransform() {
    return getModuleListNoTransform();
  }
  /**
   * Retrieves the Module list.
   * @return The node representing the Module list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Module> getModuleList() {
    List<Module> list = (List<Module>)getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Module list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Module list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Module> getModuleListNoTransform() {
    return (List<Module>)getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set resolveModule_String_visited;
  protected java.util.Map resolveModule_String_values;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:107
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Module resolveModule(String qualifiedName) {
    Object _parameters = qualifiedName;
    if(resolveModule_String_visited == null) resolveModule_String_visited = new java.util.HashSet(4);
    if(resolveModule_String_values == null) resolveModule_String_values = new java.util.HashMap(4);
    if(resolveModule_String_values.containsKey(_parameters)) {
      return (Module)resolveModule_String_values.get(_parameters);
    }
    if(resolveModule_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: resolveModule in class: ");
    resolveModule_String_visited.add(_parameters);
    Module resolveModule_String_value = resolveModule_compute(qualifiedName);
      if(true) resolveModule_String_values.put(_parameters, resolveModule_String_value);
    resolveModule_String_visited.remove(_parameters);
    return resolveModule_String_value;
  }
  /**
   * @apilevel internal
   */
  private Module resolveModule_compute(String qualifiedName) {
		for(Module module : getModules())
			if(module.getQualifiedName().equals(qualifiedName))
				return module;
		return null;
	}
}
