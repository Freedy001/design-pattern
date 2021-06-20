package com.freedy.structPattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Freedy
 * @date 2021/6/17 22:53
 */
public class ProxyFactory implements MethodInterceptor {

    private final TrainStation station=new TrainStation();

    public TrainStation getProxyObj(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TrainStation.class);
        enhancer.setCallback(this);
        return (TrainStation)enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("BEFORE");
        Object invoke = method.invoke(station,args);
        System.out.println("AFTER");
        return invoke;
    }
}
