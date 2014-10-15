package ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Modifier;
/** Utility class for representing compiler errors.  * @ast class
 * 
 */
public class CompilerError extends java.lang.Object {

		private final String msg;


		private final int line, column;


		
		public CompilerError(String msg, int line, int column) {
			this.msg = msg;
			this.line = line;
			this.column = column;
		}


		
		@Override
		public String toString() {
			return "Line " + line + ", column " + column + ": " + msg;
		}


}
