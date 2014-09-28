package test;

//import static frontend.Token.Type.EOF;
//import static frontend.Token.Type.ID;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
import static frontend.Token.Type.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import lexer.Lexer;

import org.junit.Test;

import frontend.Token;
import frontend.Token.Type;

/**
 * This class contains unit tests for your lexer. You
 * are strongly encouraged to write your own tests.
 */
public class LexerTests {
	// helper method to run tests; no need to change this
	private final void runtest(String input, Token... output) {
		Lexer lexer = new Lexer(new StringReader(input));
		int i=0;
		Token actual, expected;
		try {
			do {
				assertTrue(i < output.length);
				expected = output[i++];
				try {
					actual = lexer.nextToken();
					assertEquals(expected, actual);
				} catch(Error e) {
					if(expected != null)
						fail(e.getMessage());
					return;
				}
			} while(!actual.isEOF());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testIdentifier1(){
		runtest("AndyChong123", 
				new Token(ID, 0, 0, "AndyChong123"),
				new Token(EOF, 0, 12, ""));
	}
	
	@Test 
	public void testIdentifier2(){
		runtest("123ndyChong123", 
				new Token(Type.INT_LITERAL, 0, 0, "123"),
				new Token(ID, 0, 3, "ndyChong123"),
				new Token(EOF, 0, 14, ""));
	}
	
	@Test
	public void testIdentifier3(){
		runtest("AndyChong_123", 
				new Token(ID, 0, 0, "AndyChong_123"),
				new Token(EOF, 0, 13, ""));
	}
	
	@Test
	public void testString1(){
		runtest("\"andychong\"", 
				new Token(Type.STRING_LITERAL, 0, 0, "andychong"),
				new Token(EOF, 0, 11, ""));
	}
	
	@Test
	public void testString2(){
		try{
			runtest("\"andy\"sng\"", 
					new Token(Type.STRING_LITERAL, 0, 0, "andy"),
					new Token(ID, 0, 6, "sng"),
					new Token(EOF, 0, 9, "\""));
		}catch(AssertionError e){
			assertEquals("unexpected character '\"'", e.getMessage());
			return;
		}
		fail("Should not identify the id token");
	}

	@Test
	public void testIfElseStatement(){
		runtest("if(true){break;}else{break;}", 
				new Token(Type.IF, 0, 0, "if"),
				new Token(Type.LPAREN, 0, 2, "("),
				new Token(Type.TRUE, 0, 3, "true"),
				new Token(Type.RPAREN, 0, 7, ")"),
				new Token(Type.LCURLY, 0, 8, "{"),
				new Token(Type.BREAK, 0, 9, "break"),
				new Token(Type.SEMICOLON, 0, 14, ";"),
				new Token(Type.RCURLY, 0, 15, "}"),
				new Token(Type.ELSE, 0, 16, "else"),
				new Token(Type.LCURLY, 0, 20, "{"),
				new Token(Type.BREAK, 0, 21, "break"),
				new Token(Type.SEMICOLON, 0, 26, ";"),
				new Token(Type.RCURLY, 0, 27, "}"),
				new Token(EOF, 0, 28, "")
		);
	}
	
	/** Example unit test. */
	@Test
	public void testKWs() {
		// first argument to runtest is the string to lex; the remaining arguments
		// are the expected tokens
		runtest("module false\nreturn while",
				new Token(Type.MODULE, 0, 0, "module"),
				new Token(Type.FALSE, 0, 7, "false"),
				new Token(Type.RETURN, 1, 0, "return"),
				new Token(Type.WHILE, 1, 7, "while"),
				new Token(EOF, 1, 12, ""));
	}

		
	@Test
	public void testStringLiteralWithDoubleQuote() {
		runtest("\"\"\"",
				(Token)null);
	}
	
	@Test
	public void testStringLiteralEscapeCharacter() {
		runtest("\"\\n\"",
				new Token(Type.STRING_LITERAL, 0, 0, "\\n"),
				new Token(EOF, 0, 4, ""));
	}
	
	@Test
	public void testAcceptLongestTokenFirst(){
		runtest("breaker",
				new Token(Type.ID, 0, 0, "breaker"),
				new Token(EOF, 0, 7, ""));
	}
	
	@Test
	public void testInt() {
		runtest("1234", 
				new Token(INT_LITERAL, 0, 0, "1234"),
				new Token(EOF, 0, 4, ""));
	}
	
	@Test
	public void testStringPass() {
		runtest("\"Yong123*)(\"",
				new Token(STRING_LITERAL, 0, 0, "Yong123*)("),
				new Token(EOF, 0, 12, ""));
	}
	
	@Test
	public void testStringPass1() {
		runtest("\"\\\"",
				new Token(STRING_LITERAL, 0, 0, "\\"),
				new Token(EOF, 0, 3, ""));
	}
	
	@Test
	public void testStringPass2() {
		runtest("\"\\\\\"",
				new Token(STRING_LITERAL, 0, 0, "\\\\"),
				new Token(EOF, 0, 4, ""));
	}
	
	@Test 
	public void testCaseSensitiveKeyword(){
		runtest("Break",
				new Token(Type.ID, 0, 0, "Break"),
				new Token(EOF, 0, 5, ""));
	}
	
	@Test
	public void testOperator() {
		runtest("+-  / * = > < == <= >=!=",
				new Token(PLUS, 0, 0, "+"),
				new Token(MINUS, 0, 1, "-"),
				new Token(DIV, 0, 4, "/"),
				new Token(TIMES, 0, 6, "*"),
				new Token(EQL, 0, 8, "="),
				new Token(GT, 0, 10, ">"),
				new Token(LT, 0, 12, "<"),
				new Token(EQEQ, 0, 14, "=="),
				new Token(LEQ, 0, 17, "<="),
				new Token(GEQ, 0, 20, ">="),
				new Token(NEQ, 0, 22, "!="),
				new Token(EOF, 0, 24, ""));
	}
	
	@Test
	public void testUnaryOperator() {
		runtest("-+10",
				new Token(MINUS, 0, 0, "-"),
				new Token(PLUS, 0, 1, "+"),
				new Token(INT_LITERAL, 0, 2, "10"),
				new Token(EOF, 0, 4, ""));
	}
}
