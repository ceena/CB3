package com.cb.evaluation;

import java.util.ArrayList;

public abstract class ClassCodeEvaluator extends CodeEvaluator {
	protected ArrayList<ClassEvaluationRule> rules = new ArrayList<ClassEvaluationRule>();
	protected Class cl;
	
	public void evaluate(){		
		for (ClassEvaluationRule rule : rules) {
			rule.cl = cl;
			rule.setResult(rule.evaluate());
		}
	}
	
	public void compile(String code){
		this.compiler.compile(code);
	}

	/**
	 * @return the cl
	 */
	public Class getCl() {
		return cl;
	}

	/**
	 * @param cl the cl to set
	 */
	public void setCl(Class cl) {
		this.cl = cl;
	}

	/**
	 * @return the rules
	 */
	public ArrayList<ClassEvaluationRule> getRules() {
		return rules;
	}

	/**
	 * @param rules the rules to set
	 */
	public void setRules(ArrayList<ClassEvaluationRule> rules) {
		this.rules = rules;
	}
	
	
}
