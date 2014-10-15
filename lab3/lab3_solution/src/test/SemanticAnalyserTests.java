package test;

import static org.junit.Assert.fail;

import java.io.StringReader;

import lexer.Lexer;

import org.junit.Test;

import parser.Parser;
import ast.CompilerError;
import ast.List;
import ast.Module;
import ast.Program;

public class SemanticAnalyserTests {
	private void runtest(String... srcs) {
		runtest(true, srcs);
	}

	private void runtest(boolean succeed, String... srcs) {
		Parser parser = new Parser();
		try {
			List<Module> modules = new List<Module>();
			for(String src : srcs)
				modules.add((Module)parser.parse(new Lexer(new StringReader(src))));
			Program prog = new Program(modules);
			prog.namecheck();
			if(!prog.hasErrors()) prog.typecheck();
			if(succeed) {
				if(prog.hasErrors()) {
					StringBuffer errors = new StringBuffer();
					for(CompilerError err : prog.getErrors())
						errors.append("\n" + err);
					fail("Program was expected to pass semantic checks, but the following " +
						 "errors were reported:" + errors);
				}
			} else if(!prog.hasErrors()) {
				fail("Program was expected to fail semantic checks, but passed.");
			}
		} catch (Throwable e) {
			if(e instanceof AssertionError) {
				throw (AssertionError)e;
			} else {
				e.printStackTrace();
				if(succeed)
					fail(e.getMessage());
			}
		}
	}

	@Test
	public void testModuleNameNoClash() {
		runtest("module M { }",
				"module N { }");
	}
	
	@Test
	public void testVarNameClash() {
		runtest(false,
				"module M {" +
				"  void foo() {" +
				"    int x;" +
				"    boolean x;" +
				"  }" +
				"}");
	}
	
	@Test
	public void testVarFieldNoNameClash() {
		runtest("module M {" +
				"  int x;" +
				"  void foo() {" +
				"    boolean x;" +
				"  }" +
				"}");
	}
	
	@Test
	public void testUndeclaredVariable() {
		runtest(false,
				"module M {" +
					"  int foo() {" +
				"    return res;" + 
				"  }" +
				"}");
	}
	
	@Test
	public void testBreakInsideLoop() {
		runtest("module M {" +
				"  void foo() {" +
				"    while(true)" +
				"      break;" +
				"  }" +
				"}");
	}
	
	@Test
	public void testBreakNestedInsideLoop() {
		runtest("module M {" +
				"  void foo() {" +
				"    while(true) {" +
				"      if(true) {" +
				"        { break; }" +
				"      }" +
				"    }" +
				"  }" +
				"}");
	}
	
	@Test
	public void testBreakNestedOutsideLoop() {
		runtest(false,
				"module M {" +
				"  void foo() {" +
				"    while(true) {}" +
				"    if(true) {" +
				"      { break; }" +
				"    }" +
				"  }" +
				"}");
	}

	@Test
	public void testLookupLocal() {
		runtest("module M {" +
				"  int foo() {" +
				"    int res;" +
				"    res = 23;" +
				"    return res;" +
				"  }" +
				"}");
	}
	
	@Test
	public void testLookupImportedFunction() {
		runtest("module M {" +
				"  import N;" +
				"  int foo() {" +
				"    return bar();" +
				"  }" +
				"}",
				"module N {" +
				"  public int bar() { return 23; }" +
				"}");
	}

	@Test
	public void testLookupField() {
		runtest("module M {" +
				"  int res;" +
				"  int foo() {" +
				"    return res;" +
				"  }" +
				"}");
	}
	
	@Test
	public void testLookupImportedField() {
		runtest("module M {" +
				"  import N;" +
				"  int foo() {" +
				"    return res;" +
				"  }" +
				"}",
				"module N {" +
				"  public int res;" +
				"}");
	}
	
	@Test
	public void testBooleanIfCond() {
		runtest("module M {" +
				"  int foo() {" +
				"    if(true)" +
				"      return 42;" +
				"    return 23;" +
				"  }" +
				"}");
	}
	
	@Test
	public void testNonBooleanIfCond() {
		runtest(false,
				"module M {" +
				"  int foo() {" +
				"    if(0)" +
				"      return 42;" +
				"    return 23;" +
				"  }" +
				"}");
	}
	
	@Test
	public void testExprReturn() {
		runtest("module M {" +
				"  int foo() {" +
				"    return 0;" +
				"  }" +
				"}");
	}

	@Test
	public void testBooleanLoopCond() {
		runtest("module M {" +
				"  int foo() {" +
				"    while(6>=0)" +
				"      return 42;" +
				"    return 23;" +
				"  }" +
				"}");
	}
	
	@Test
	public void testNonBooleanWhileCond() {
		runtest(false,
				"module M {" +
				"  int foo() {" +
				"    while(5+5)" +
				"      return 42;" +
				"    return 23;" +
				"  }" +
				"}");
	}
	
	@Test
	public void testCorrectArrayExpression() {
		runtest("module M {" +
				"  boolean foo(boolean[][] bss, int i, int j) {" +
				"    return bss[i][j];" +
				"  }" +
				"}");
	}
	
	@Test
	public void testArityMatch() {
		runtest(
				"module M {" +
				"  int id(int x, int y) { return x+y; }" +
				"  int foo() { return id(23, 42); }" +
				"}");
	}

}
	