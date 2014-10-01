package mycloud;

import java.io.StringReader;
import java.lang.reflect.Method;

import org.codehaus.janino.SimpleCompiler;

public class StringExecutor 
{ 
 private static final String CLASS_NAME = "Foo"; 
 public static void main(String[] args) throws Exception 
 { 

 String codeStr = 
 "public class " + CLASS_NAME + " {" + 
 "public static void main(String[] args){" + 
 "System.out.println(\"Hello \" );}}"; 
 SimpleCompiler compiler = new SimpleCompiler(); 
 compiler.cook( new StringReader(codeStr) ); // compile the string 
 // get the loaded class 
 Class<?> cl = compiler.getClassLoader().loadClass(CLASS_NAME); 
 // Invoke the "public static main(String[])" method 
 Method mainMeth = cl.getMethod("main", 
 new Class[] { String[].class }); 
 String[] methArgs = new String[] {  }; // one input 
 mainMeth.invoke(null, new Object[] { methArgs }); 
 } // end of main() 
} 