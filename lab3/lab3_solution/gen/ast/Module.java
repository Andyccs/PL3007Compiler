/* This file was generated with JastAdd2 (http://jastadd.org) version R20121122 (r889) */
package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/**
 * @production Module : {@link ASTNode} ::= <span class="component">&lt;Package:String&gt;</span> <span class="component">&lt;Name:String&gt;</span> <span class="component">{@link Import}*</span> <span class="component">{@link Declaration}*</span>;
 * @ast node
 * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/grammar.ast:3
 */
public class Module extends ASTNode<ASTNode> implements Cloneable, Scope {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getQualifiedName_visited = false;
    getQualifiedName_computed = false;
    getQualifiedName_value = null;
    lookupLocalField_String_visited = null;
    lookupLocalField_String_values = null;
    lookupLocalType_String_visited = null;
    lookupLocalType_String_values = null;
    lookupLocalFunction_String_visited = null;
    lookupLocalFunction_String_values = null;
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
  public Module clone() throws CloneNotSupportedException {
    Module node = (Module)super.clone();
    node.getQualifiedName_visited = false;
    node.getQualifiedName_computed = false;
    node.getQualifiedName_value = null;
    node.lookupLocalField_String_visited = null;
    node.lookupLocalField_String_values = null;
    node.lookupLocalType_String_visited = null;
    node.lookupLocalType_String_values = null;
    node.lookupLocalFunction_String_visited = null;
    node.lookupLocalFunction_String_values = null;
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Module copy() {
      try {
        Module node = (Module)clone();
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
  public Module fullCopy() {
    try {
      Module tree = (Module) clone();
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
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/namecheck.jrag:17
   */
  public void namecheck() {
		// check for duplicate imports
		Set<String> imports = new HashSet<String>();
		for(Import imp : getImports()) {
			imp.namecheck();
			if(!imports.add(imp.getQualifiedName()))
				error("Multiple imports of module " + imp.getQualifiedName());
		}
		
		for(Declaration decl : getDeclarations())
			decl.namecheck();
	}
  /**
   * @ast method 
   * @aspect Typecheck
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/typecheck.jrag:21
   */
  public void typecheck() {
		for(Declaration decl : getDeclarations())
			decl.typecheck();
	}
  /**
   * @ast method 
   * 
   */
  public Module() {
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
    setChild(new List(), 0);
    setChild(new List(), 1);
  }
  /**
   * @ast method 
   * 
   */
  public Module(String p0, String p1, List<Import> p2, List<Declaration> p3) {
    setPackage(p0);
    setName(p1);
    setChild(p2, 0);
    setChild(p3, 1);
  }
  /**
   * @ast method 
   * 
   */
  public Module(beaver.Symbol p0, beaver.Symbol p1, List<Import> p2, List<Declaration> p3) {
    setPackage(p0);
    setName(p1);
    setChild(p2, 0);
    setChild(p3, 1);
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
   * Replaces the lexeme Package.
   * @param value The new value for the lexeme Package.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setPackage(String value) {
    tokenString_Package = value;
  }
  /**
   * @apilevel internal
   * @ast method 
   * 
   */
  
  /**
   * @apilevel internal
   */
  protected String tokenString_Package;
  /**
   * @ast method 
   * 
   */
  
  public int Packagestart;
  /**
   * @ast method 
   * 
   */
  
  public int Packageend;
  /**
   * JastAdd-internal setter for lexeme Package using the Beaver parser.
   * @apilevel internal
   * @ast method 
   * 
   */
  public void setPackage(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
      throw new UnsupportedOperationException("setPackage is only valid for String lexemes");
    tokenString_Package = (String)symbol.value;
    Packagestart = symbol.getStart();
    Packageend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Package.
   * @return The value for the lexeme Package.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public String getPackage() {
    return tokenString_Package != null ? tokenString_Package : "";
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
   * Replaces the Import list.
   * @param list The new list node to be used as the Import list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setImportList(List<Import> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Import list.
   * @return Number of children in the Import list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public int getNumImport() {
    return getImportList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Import list.
   * Calling this method will not trigger rewrites..
   * @return Number of children in the Import list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public int getNumImportNoTransform() {
    return getImportListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Import list..
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Import list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Import getImport(int i) {
    return (Import)getImportList().getChild(i);
  }
  /**
   * Append an element to the Import list.
   * @param node The element to append to the Import list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void addImport(Import node) {
    List<Import> list = (parent == null || state == null) ? getImportListNoTransform() : getImportList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void addImportNoTransform(Import node) {
    List<Import> list = getImportListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Import list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setImport(Import node, int i) {
    List<Import> list = getImportList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Import list.
   * @return The node representing the Import list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public List<Import> getImports() {
    return getImportList();
  }
  /**
   * Retrieves the Import list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Import list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public List<Import> getImportsNoTransform() {
    return getImportListNoTransform();
  }
  /**
   * Retrieves the Import list.
   * @return The node representing the Import list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Import> getImportList() {
    List<Import> list = (List<Import>)getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Import list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Import list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Import> getImportListNoTransform() {
    return (List<Import>)getChildNoTransform(0);
  }
  /**
   * Replaces the Declaration list.
   * @param list The new list node to be used as the Declaration list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setDeclarationList(List<Declaration> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Declaration list.
   * @return Number of children in the Declaration list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public int getNumDeclaration() {
    return getDeclarationList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Declaration list.
   * Calling this method will not trigger rewrites..
   * @return Number of children in the Declaration list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public int getNumDeclarationNoTransform() {
    return getDeclarationListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Declaration list..
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Declaration list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Declaration getDeclaration(int i) {
    return (Declaration)getDeclarationList().getChild(i);
  }
  /**
   * Append an element to the Declaration list.
   * @param node The element to append to the Declaration list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void addDeclaration(Declaration node) {
    List<Declaration> list = (parent == null || state == null) ? getDeclarationListNoTransform() : getDeclarationList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * 
   */
  public void addDeclarationNoTransform(Declaration node) {
    List<Declaration> list = getDeclarationListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Declaration list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public void setDeclaration(Declaration node, int i) {
    List<Declaration> list = getDeclarationList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Declaration list.
   * @return The node representing the Declaration list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  public List<Declaration> getDeclarations() {
    return getDeclarationList();
  }
  /**
   * Retrieves the Declaration list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Declaration list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  public List<Declaration> getDeclarationsNoTransform() {
    return getDeclarationListNoTransform();
  }
  /**
   * Retrieves the Declaration list.
   * @return The node representing the Declaration list.
   * @apilevel high-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Declaration> getDeclarationList() {
    List<Declaration> list = (List<Declaration>)getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Declaration list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Declaration list.
   * @apilevel low-level
   * @ast method 
   * 
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Declaration> getDeclarationListNoTransform() {
    return (List<Declaration>)getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  protected boolean getQualifiedName_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean getQualifiedName_computed = false;
  /**
   * @apilevel internal
   */
  protected String getQualifiedName_value;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:9
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String getQualifiedName() {
    if(getQualifiedName_computed) {
      return getQualifiedName_value;
    }
    if(getQualifiedName_visited)
      throw new RuntimeException("Circular definition of attr: getQualifiedName in class: ");
    getQualifiedName_visited = true;
    getQualifiedName_value = getQualifiedName_compute();
      if(true) getQualifiedName_computed = true;
    getQualifiedName_visited = false;
    return getQualifiedName_value;
  }
  /**
   * @apilevel internal
   */
  private String getQualifiedName_compute() {  return getPackage().isEmpty() ? getName() : getPackage() + "." + getName();  }
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupLocalField_String_visited;
  protected java.util.Map lookupLocalField_String_values;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:86
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FieldDeclaration lookupLocalField(String name) {
    Object _parameters = name;
    if(lookupLocalField_String_visited == null) lookupLocalField_String_visited = new java.util.HashSet(4);
    if(lookupLocalField_String_values == null) lookupLocalField_String_values = new java.util.HashMap(4);
    if(lookupLocalField_String_values.containsKey(_parameters)) {
      return (FieldDeclaration)lookupLocalField_String_values.get(_parameters);
    }
    if(lookupLocalField_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: lookupLocalField in class: ");
    lookupLocalField_String_visited.add(_parameters);
    FieldDeclaration lookupLocalField_String_value = lookupLocalField_compute(name);
      if(true) lookupLocalField_String_values.put(_parameters, lookupLocalField_String_value);
    lookupLocalField_String_visited.remove(_parameters);
    return lookupLocalField_String_value;
  }
  /**
   * @apilevel internal
   */
  private FieldDeclaration lookupLocalField_compute(String name) {

		/* TODO: Implement local lookup of a field within a module. */
		
		for(Declaration decl : getDeclarations())
		{
			if(decl instanceof FieldDeclaration)
			{
				FieldDeclaration DF = (FieldDeclaration) decl;
				
				if(DF.getVarDecl().getName().equals(name))
				{
					return DF;
				}
			}
		}
		
		return null;
	}
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupLocalType_String_visited;
  protected java.util.Map lookupLocalType_String_values;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:146
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDeclaration lookupLocalType(String name) {
    Object _parameters = name;
    if(lookupLocalType_String_visited == null) lookupLocalType_String_visited = new java.util.HashSet(4);
    if(lookupLocalType_String_values == null) lookupLocalType_String_values = new java.util.HashMap(4);
    if(lookupLocalType_String_values.containsKey(_parameters)) {
      return (TypeDeclaration)lookupLocalType_String_values.get(_parameters);
    }
    if(lookupLocalType_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: lookupLocalType in class: ");
    lookupLocalType_String_visited.add(_parameters);
    TypeDeclaration lookupLocalType_String_value = lookupLocalType_compute(name);
      if(true) lookupLocalType_String_values.put(_parameters, lookupLocalType_String_value);
    lookupLocalType_String_visited.remove(_parameters);
    return lookupLocalType_String_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDeclaration lookupLocalType_compute(String name) {
		/* TODO: Implement; same as lookupLocalField */
		
		for(Declaration decl : getDeclarations())
		{
			if(decl instanceof TypeDeclaration)
			{
				TypeDeclaration typeDecl = (TypeDeclaration) decl;
				
				if(typeDecl.getName().equals(name))
				{
					return typeDecl;
				}
			}
		}
		return null;
	}
  /**
   * @apilevel internal
   */
  protected java.util.Set lookupLocalFunction_String_visited;
  protected java.util.Map lookupLocalFunction_String_values;
  /**
   * @attribute syn
   * @aspect names
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:194
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FunctionDeclaration lookupLocalFunction(String name) {
    Object _parameters = name;
    if(lookupLocalFunction_String_visited == null) lookupLocalFunction_String_visited = new java.util.HashSet(4);
    if(lookupLocalFunction_String_values == null) lookupLocalFunction_String_values = new java.util.HashMap(4);
    if(lookupLocalFunction_String_values.containsKey(_parameters)) {
      return (FunctionDeclaration)lookupLocalFunction_String_values.get(_parameters);
    }
    if(lookupLocalFunction_String_visited.contains(_parameters))
      throw new RuntimeException("Circular definition of attr: lookupLocalFunction in class: ");
    lookupLocalFunction_String_visited.add(_parameters);
    FunctionDeclaration lookupLocalFunction_String_value = lookupLocalFunction_compute(name);
      if(true) lookupLocalFunction_String_values.put(_parameters, lookupLocalFunction_String_value);
    lookupLocalFunction_String_visited.remove(_parameters);
    return lookupLocalFunction_String_value;
  }
  /**
   * @apilevel internal
   */
  private FunctionDeclaration lookupLocalFunction_compute(String name) {

		/* TODO: Implement; same as lookupLocalField */
		
		for(Declaration decl : getDeclarations())
		{
			if(decl instanceof FunctionDeclaration)
			{
				FunctionDeclaration functionDecl = (FunctionDeclaration) decl;
				if(functionDecl.getName().equals(name))
				{
					return functionDecl;
				}
			}
		}
		return null;
	}
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/astutil.jrag:30
   * @apilevel internal
   */
  public Module Define_Module_getModule(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return this;
    }
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:52
   * @apilevel internal
   */
  public VarDecl Define_VarDecl_lookupVar(ASTNode caller, ASTNode child, String name) {
     { 
   int childIndex = this.getIndexOfChild(caller);
{
		FieldDeclaration decl;

		/* TODO: Implement lookup of a field within a module scope.
		 * 
		 *       First, you should try to find the field among the locally declared fields
		 *       (use attribute lookupLocalField declared below). Otherwise, it should
		 *       be looked up among the imported modules (again using lookupLocalField); in
		 *       that case, however, the field is only found if it is declared public
		 *       (use attribute isPublic).
		 */
		
			decl = this.lookupLocalField(name);
			
		 	if (decl != null)
		 	{
		 		return decl.getVarDecl();
		 	}
		 	else 
		 	{
		 		for (Import imp : getImports())
		 		{
		 			decl = imp.resolve().lookupLocalField(name);
		 			
		 			if (decl != null && decl.isPublic()) 
		 				return decl.getVarDecl();
		 			else
		 				return null;
		 		}
		 	}
		 	return null;
	}
    }
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:120
   * @apilevel internal
   */
  public TypeDeclaration Define_TypeDeclaration_lookupType(ASTNode caller, ASTNode child, String name) {
     { 
   int childIndex = this.getIndexOfChild(caller);
{
		TypeDeclaration tp;

		/* TODO: implement type lookup within a module scope; it works the same as for fields */
		
		tp = this.lookupLocalType(name);
		
		if(tp == null)
		{		
			for(Import imp : getImports())
			{
				tp = imp.reslove().lookupLocalType(name);
				if (tp != null && tp.isPublic())
					return tp;
				else return null;
			}	
		}
		
		else 
		{
			return tp;		
		}
		return null;
	}
    }
  }
  /**
   * @declaredat C:/teaching/CZ3007/lab3_solution/src/frontend/names.jrag:168
   * @apilevel internal
   */
  public FunctionDeclaration Define_FunctionDeclaration_lookupFunction(ASTNode caller, ASTNode child, String name) {
     { 
   int childIndex = this.getIndexOfChild(caller);
{
		FunctionDeclaration fn;

		/* TODO: implement function lookup within a module scope; it works the same as for fields */
		
		fn = this.lookupLocalFunction(name);
		
		 if (fn == null){
		 
		 		for (Import imp : getImports())
		 		{
					fn = imp.resolve().lookupLocalFunction(name);
		 			if (fn != null && fn.isPublic())
		 				return fn;
		 			else return null;
		 		}
		 }
		 
		 else 
		 {
		 		return fn;
		 }
		 
		 return null;
	}
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
