package mycloud;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ClassBodyEvaluator;
import org.codehaus.janino.SimpleCompiler;

public class StringBodyExecutor 
{ 
	private final static String HALLO_WORLD_CLASS_NAME = "HalloWorldTest";
	public final static String HALLO_WORLD_SOURCE_TMPL1 = 
			 "    public static String run() {\n" +
			" java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(); " + 
    		" java.io.PrintStream ps = new java.io.PrintStream(baos);    System.setOut(ps);   ";
    		
	public final static String HALLO_WORLD_SOURCE_TMPL2 =	 "System.out.flush();" + 
			 "        return baos.toString();\n" + "    }\n" ;
	
 public static void main(String[] args) throws Exception 
 { 

	 System.out.println(runCode(HALLO_WORLD_SOURCE_TMPL1+"System.out.println(\"hey you\");"+HALLO_WORLD_SOURCE_TMPL2));
 } // end of main() 
 
	public static String runCode(String code) {
		String out = "";
	 
		try {
			Class<?> cl = new ClassBodyEvaluator(HALLO_WORLD_SOURCE_TMPL1+code+HALLO_WORLD_SOURCE_TMPL2).getClazz(); 
			 Method mainMeth = cl.getMethod("run"); 
					 //,new Class[] { String[].class }); 
			 String[] methArgs = new String[] {  }; // one input 
			 return (String) mainMeth.invoke(null);
					 //, new Object[] { methArgs });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return out;

	}
} 