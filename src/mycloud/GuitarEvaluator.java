package mycloud;

/*
 * Janino - An embedded Java[TM] compiler
 *
 * Copyright (c) 2001-2010, Arno Unkrig
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *       following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 *       following disclaimer in the documentation and/or other materials provided with the distribution.
 *    3. The name of the author may not be used to endorse or promote products derived from this software without
 *       specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ClassBodyEvaluator;
import org.codehaus.janino.SimpleCompiler;

/**
 * A test program that allows you to play with the {@link ClassBodyEvaluator}
 * API.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public final class GuitarEvaluator {

	private final static String HALLO_WORLD_CLASS_NAME = "Guitar";
	public final static String HALLO_WORLD_SOURCE = "public class "
			+ HALLO_WORLD_CLASS_NAME + "{\n"
			+ "      int price; public static String run() {\n"
			+ "        return \"run sucessfully...\";\n" + "    }\n" + "}";
	
	public static String runCode(String code) {
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
			cl = compiler.getClassLoader().loadClass(HALLO_WORLD_CLASS_NAME);
						
			Field[] fs = cl.getDeclaredFields();
			for(Field f: fs){
				if(f.getName().equals("price"))				
					priceFieldFlag = true;
			}
			

		    
			 String evalResult = "";
			 if(priceFieldFlag)
				 evalResult += "Sucess: field price FOUND\n";
			 else
				 evalResult += "Failure: field price NOT FOUND\n";
				 
			 return evalResult;
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	    
	    
		return out;

	}

	/**/
	public static void main(String[] args) throws Exception {

		System.out.println(runCode(HALLO_WORLD_SOURCE));
	}

	private GuitarEvaluator() {
	}

	private static String readFileToString(String fileName) throws IOException {

		Reader r = new FileReader(fileName);
		try {
			StringBuilder sb = new StringBuilder();
			char[] ca = new char[1024];
			for (;;) {
				int cnt = r.read(ca, 0, ca.length);
				if (cnt == -1)
					break;
				sb.append(ca, 0, cnt);
			}
			return sb.toString();
		} finally {
			r.close();
		}
	}
}