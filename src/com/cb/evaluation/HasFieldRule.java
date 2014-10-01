package com.cb.evaluation;
import java.lang.reflect.Field;


public class HasFieldRule extends ClassEvaluationRule {

	protected Field f;
	protected String fstr;	
	
	public HasFieldRule(Field f) {
		super();
		this.f = f;
	}
	
	public HasFieldRule(String fstr) {
		super();
		this.fstr = fstr;
	}


	@Override
	public boolean evaluate() {
		try {
			if(f!=null){
				cl.getDeclaredField(f.getName());
			}else{
				cl.getDeclaredField(fstr);
			}
			return true;
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

}
