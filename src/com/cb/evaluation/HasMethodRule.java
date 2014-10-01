package com.cb.evaluation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HasMethodRule extends ClassEvaluationRule {

	protected Method m;
	protected String mstr;

	public HasMethodRule(Method m) {
		super();
		this.m = m;
	}

	public HasMethodRule(String mstr) {
		super();
		this.mstr = mstr;
	}

	@Override
	public boolean evaluate() {
		try {
			if (m != null) {
				cl.getDeclaredMethod(m.getName(), m.getParameterTypes());
			} else {
				Method[] methods = cl.getDeclaredMethods();
				for (Method method : methods) {
					if (method.getName().equals(mstr)) {
						return true;
					}

				}

			}
		} catch (NoSuchMethodException | SecurityException e) {
			return false;
		}
		return false;
	}

}
