package com.cb.evaluation;

import java.util.ArrayList;

public abstract class CodeEvaluator {
	protected CodeCompiler compiler = new CodeCompiler();
	protected CodeRunner runner = new CodeRunner();

	
	/**
	 * @return the compiler
	 */
	public CodeCompiler getCompiler() {
		return compiler;
	}

	/**
	 * @param compiler the compiler to set
	 */
	public void setCompiler(CodeCompiler compiler) {
		this.compiler = compiler;
	}

	/**
	 * @return the runner
	 */
	public CodeRunner getRunner() {
		return runner;
	}

	/**
	 * @param runner the runner to set
	 */
	public void setRunner(CodeRunner runner) {
		this.runner = runner;
	}
}
