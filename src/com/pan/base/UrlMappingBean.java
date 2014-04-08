package com.pan.base;

/**
 * Created with IntelliJ IDEA.
 * User: chenyehui
 * Date: 14-4-8
 * Time: 下午10:20
 * To change this template use File | Settings | File Templates.
 */
public class UrlMappingBean {
    private Object object;

    private String methodName;

    public UrlMappingBean(Object object) {
        this.object = object;
    }

    public UrlMappingBean(Object object, String methodName) {
        this.object = object;
        this.methodName = methodName;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
