package com.demo;

public class BooleanTestBean implements HelloApi{
	private boolean success;
	public void setSuccess(boolean success){
		this.success=success;
	}
	public boolean isOk(){
		return success;
	}
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		
	}

}
