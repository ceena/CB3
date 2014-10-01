package com.cb.evaluation;

import java.util.ArrayList;

public class GuitarEvaluator extends ClassCodeEvaluator {

	public final static String HALLO_WORLD_SOURCE = "public class Guitar"
			+ "{\n"
			+ "      int price; public static String run() {\n"
			+ "        return \"run sucessfully...\";\n" + "    }\n" + "}";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ClassEvaluationRule> rules = new ArrayList<ClassEvaluationRule>();
		rules.add(new IsClassRule("Guitar"));
		rules.add(new HasFieldRule("price2"));
		rules.add(new HasMethodRule("run"));
		
		GuitarEvaluator ge = new GuitarEvaluator();
		ge.setRules(rules);
		ge.compile(HALLO_WORLD_SOURCE);
		ge.setCl(ge.compiler.loadClass("Guitar"));
		ge.evaluate();
		
		for (ClassEvaluationRule classEvaluationRule : rules) {
			System.out.println(classEvaluationRule.result);
		}
		
		
		
	}

}
