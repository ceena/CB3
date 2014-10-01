package com.cb.evaluation;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.SimpleCompiler;

public class CodeCompiler {

	protected ClassLoader classLoader = null;
	
	public void compile(String code) {
		String out = "";

		SimpleCompiler compiler = new SimpleCompiler();
		try {
			compiler.cook(new StringReader(code));
		} catch (CompileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // compile the string
			// get the loaded class
		boolean priceFieldFlag = false;
		Class<?> cl;
		try {
			classLoader = compiler.getClassLoader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Class loadClass(String className){
		Class cl = null;
		try {
			cl = classLoader.loadClass(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;
	}

	/**
	 * @return the classLoader
	 */
	public ClassLoader getClassLoader() {
		return classLoader;
	}

	/**
	 * @param classLoader the classLoader to set
	 */
	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

}