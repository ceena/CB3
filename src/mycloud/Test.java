package mycloud;

import java.io.File;

import org.codehaus.janino.JavaSourceClassLoader;

public class Test {

	public static void main(String[] args) {
		new Test().run();		
	}
	
	public void run(){
		ClassLoader cl = new JavaSourceClassLoader(
			    this.getClass().getClassLoader(),  // parentClassLoader
			    new File[] { new File("srcdir") }, // optionalSourcePath
			    (String) null                  // optionalCharacterEncoding
			    // debuggingInformation
			);
		
		try {
			Object o = cl.loadClass("mycloud.Dog").newInstance();
			((Animal) o).makeNoise();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
