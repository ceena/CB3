package com.cb.evaluation;

public class ClassEvaluationRule implements EvaluationRule {

	protected Class cl;
	protected boolean result;
	@Override
	public boolean evaluate() {
		// TODO Auto-generated method stub
		return false;
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
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}

}
