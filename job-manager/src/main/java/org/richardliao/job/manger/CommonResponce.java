package org.richardliao.job.manager;

public class CommonResponce {
    private Integer retCode;

    private Object obj;

    public CommonResponce(Integer retCode, Object obj) {
	this.retCode = retCode;
	this.obj = obj;
    }

    public Integer getRetCode() {
	return this.retCode;
    }

    public Object getObj() {
	return this.obj;
    }
}
