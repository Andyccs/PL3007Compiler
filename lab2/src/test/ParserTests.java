package test;

import static org.junit.Assert.fail;

import java.io.StringReader;

import lexer.Lexer;

import org.junit.Test;

import parser.Parser;

public class ParserTests {
	private void runtest(String src) {
		runtest(src, true);
	}

	private void runtest(String src, boolean succeed) {
		Parser parser = new Parser();
		try {
			parser.parse(new Lexer(new StringReader(src)));
			if(!succeed) {
				fail("Test was supposed to fail, but succeeded");
			}
		} catch (beaver.Parser.Exception e) {
			if(succeed) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		} catch (Throwable e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEmptyModule() {
		runtest("module Test { }");
	}
	
	@Test
	public void testFunctionCall(){
		//test precondition
		runtest("module Test{ public int function_name() {  } }");
		
		//test function call 
		runtest("module Test{ public int function_name() { abc(); } }");
		runtest("module Test{ public int function_name() { abc(a=1); } }");
		runtest("module Test{ public int function_name() { abc(a=1,b=2); } }");		runtest("module Test{ public int function_name() { abc(a=1); } }");
		runtest("module Test{ public int function_name() { abc(a,b); } }");
		runtest("module Test{ public int function_name() { abc(1,2); } }");
	}
	
	@Test
	public void testArrayExpression(){
		//test precondition
		runtest("module Test{ public int function_name() {  } }");
		
		//test array expression 
		runtest("module Test{ public int function_name() { []; } }",false);
		runtest("module Test{ public int function_name() { [a=1]; } }");
		runtest("module Test{ public int function_name() { [a=1,b=2]; } }");
		runtest("module Test{ public int function_name() { [a]; } }");
		runtest("module Test{ public int function_name() { [a,b]; } }");
		runtest("module Test{ public int function_name() { [1]; } }");
		runtest("module Test{ public int function_name() { [1,2]; } }");
	}
	
	@Test
	public void testBooleanLiteral(){
		//test precondition
		runtest("module Test{ public int function_name() {  } }");
		
		//start test
		runtest("module Test{ public int function_name() { true; } }");
		runtest("module Test{ public int function_name() { false; } }");
	}
	
	@Test
	public void testParenthesisExpression(){
		//test precondition
		runtest("module Test{ public int function_name() {  } }");
		
		//start test
		runtest("module Test{ public int function_name() { (); } }",false);
		runtest("module Test{ public int function_name() { (1+1); } }");
		runtest("module Test{ public int function_name() { (true+true); } }");
		runtest("module Test{ public int function_name() { (a[1]+b[c=2]); } }");
	}
	
	
}
