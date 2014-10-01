package com.cb.evaluation;
import java.lang.reflect.Method;


public class IsClassRule extends ClassEvaluationRule {
	
	protected String className;	
	
	public IsClassRule(String className) {
		super();
		this.className = className;
	}

	@Override
	public boolean evaluate() {
		if(cl == null){
			System.out.println("Class to evaluate is null!");
		}
		try {
			if(cl.getName().equals(className))
				return true;
		} catch (SecurityException e) {
			return false;
		}
		return false;
	}

}
