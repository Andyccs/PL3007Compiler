package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import backend.ProgramCodeGenerator;

import junit.framework.Assert;
import lexer.Lexer;
import parser.Parser;
import soot.Printer;
import soot.SootClass;
import soot.jimple.JasminClass;
import soot.util.JasminOutputStream;
import ast.List;
import ast.Module;
import ast.Program;

/**
 * System tests for the compiler: compiles a given program to Java bytecode, then immediately
 * loads it into the running JVM and executes it.
 */
public class CompilerTests {
	// set this flag to true to dump generated Jimple code to standard output
	private static final boolean DEBUG = false;
	
	/**
	 * A simple class loader that allows us to directly load compiled classes.
	 */
	private static class CompiledClassLoader extends URLClassLoader {
		private final Map<String, byte[]> classes = new HashMap<String, byte[]>();
		
		public CompiledClassLoader() {
			super(new URL[0], CompilerTests.class.getClassLoader());
		}
		
		public void addClass(String name, byte[] code) {
			classes.put(name, code);
		}
		
		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			if(classes.containsKey(name)) {
				byte[] code = classes.get(name);
				return defineClass(name, code, 0, code.length);
			}
			return super.findClass(name);
		}
	}

	/**
	 * Test runner class.
	 * 
	 * @param modules_src Array of strings, representing the source code of the program modules
	 * @param main_module the name of the main module
	 * @param main_function the name of the main function
	 * @param parm_types the parameter types of the main function
	 * @param args arguments to pass to the main method
	 * @param expected expected result
	 */
	private void runtest(String[] modules_src, String main_module, String main_function, Class<?>[] parm_types, Object[] args, Object expected) {
		try {
			List<Module> modules = new List<Module>();
			for(String module_src : modules_src) {
				Parser parser = new Parser();
				Module module = (Module)parser.parse(new Lexer(new StringReader(module_src)));
				modules.add(module);
			}
			Program prog = new Program(modules);
			
			prog.namecheck();
			prog.typecheck();
			prog.flowcheck();
			if(prog.hasErrors()) {
				Assert.fail(prog.getErrors().iterator().next().toString());
			}
			
			CompiledClassLoader loader = new CompiledClassLoader();
			try {
				for(SootClass klass : new ProgramCodeGenerator().generate(prog)) {
					if(DEBUG) {
						PrintWriter stdout_pw = new PrintWriter(System.out);
						Printer.v().printTo(klass, stdout_pw);
						stdout_pw.flush();
					}

					String name = klass.getName();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintWriter pw = new PrintWriter(new JasminOutputStream(baos));
					new JasminClass(klass).print(pw);
					pw.flush();
					loader.addClass(name, baos.toByteArray());
				}

				Class<?> testclass = loader.loadClass(main_module);
				Method method = testclass.getMethod(main_function, parm_types);
				Object actual = method.invoke(null, args);
				if(!method.getReturnType().equals(void.class))
					Assert.assertEquals(expected, actual);
			} finally {
				loader.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		} catch(ClassFormatError e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/** Convenience wrapper for runtest with only a single module. Other arguments are the same .*/
	private void runtest(String string, String classname, String methodname, Class<?>[] parmTypes, Object[] args, Object expected) {
		runtest(new String[] { string }, classname, methodname, parmTypes, args, expected);
	}

	@Test public void testAddition() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return 23+19;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				42);
	}

	@Test public void testSubtraction() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return 42-19;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				23);
	}

	@Test public void testMultiplication() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return 2*21;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				42);
	}

	@Test public void testDivision() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return 42/2;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				21);
	}

	@Test public void testPrecedence() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return 2+42/2;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				23);
	}

     @Test public void testParentheses() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return (2+42)/2;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				22);
	}

	@Test public void testNegation() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return -42;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				-42);
	}
	
	//Test Expressions
	@Test public void testNegInt() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return -42;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				-42);
	}
	
	@Test public void testPosInt() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return 35;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				35);
	}

	@Test public void testString() {
		runtest("module Test {" +
				"  public String f() {" +
				"    return \"good luck!\";" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				"good luck!");
	}
	
	@Test public void testBoolean() {
		runtest("module Test {" +
				"  public boolean f() {" +
				"    return false;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				false);
	}
	
	@Test public void testArrayIndex() {
		runtest("module Test {" +
				"  public int f() {" +
				"    int[] a;" + 
				"    int b;" + 
				"    int c;" + 
				"	 b=2;" +
				"	 c=5;" +
				"    a = [2,4,6,7,-100,-20,b*c];" + 	
				"    return a[6];}" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				10);
	}
	
	@Test public void testAddExpr() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return 1+4;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				5);
	}
	
	@Test public void testSubExpr() {
		runtest("module Test {" +
				"  public int f() {" +
				"	 int a;" +
				"	 int b;" +
				"	 a=3;" +
				"	 b=4;" +
				"    return a*b;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				12);
	}
	
	@Test public void testMulExpr() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return 100*4;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				400);
	}
	
	@Test public void testDivExpr() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return -6/2;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				-3);
	}
	
	@Test public void testModExpr() {
		runtest("module Test {" +
				"  public int f() {" +
				"    return 5%2;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				1);
	}
	
	@Test public void testWhileStatement() {
		runtest("module Test {" +
				"  public int f() {" +
				"    int a;"+
				"    int b;"+
				"    a=40;"+
				"    b=24;"+
				"    while(a!=b){" +
				"    	if(a>b) a=a-b;" +
				"    	else b=b-a;" +
				"	 }"+
				"    return a;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				8);
	}
	
	@Test public void testBreakStatement() {
		runtest("module Test {" +
				"  public int f() {" +
				"    int a;"+
				"    a=40;"+
				"    while(true){" +
				"    	a=a-1;" +
				"    	if(a==4) break;"+
				"	 }"+
				"    return a;" +
				"  }" +
				"}",
				"Test",
				"f",
				new Class<?>[0],
				new Object[0],
				4);
	}
}
