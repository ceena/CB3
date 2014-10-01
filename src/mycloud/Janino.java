package mycloud;

import org.codehaus.janino.SimpleCompiler;

public class Janino {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*// Compile the expression once; relatively slow.
		ExpressionEvaluator ee = new ExpressionEvaluator(
		    "c > d ? c : d",                     // expression
		    int.class,                           // expressionType
		    new String[] { "c", "d" },           // parameterNames
		    new Class[] { int.class, int.class } // parameterTypes
		);
		 */

		SimpleCompiler sc = new SimpleCompiler("Test.java");
		

	}

}
