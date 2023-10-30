package com.example.cglib;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void test(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(GreetingService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!");
        GreetingService proxy = (GreetingService) enhancer.create();

        System.out.println(proxy.sayHello("makabaka"));
    }


    @org.junit.Test
    public void beanCreation() throws Exception {
        BeanGenerator beanGenerator = new BeanGenerator();

        beanGenerator.addProperty("name", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "some string value set by a cglib");

        Method getter = myBean.getClass().getMethod("getName");
        assertEquals("some string value set by a cglib", getter.invoke(myBean));
    }
}
