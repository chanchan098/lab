package com.example.javaproxy;

import java.lang.reflect.Proxy;

public class Test {
    @org.junit.Test
    public void test(){
        GreetingService greetingService = new GreetingServiceImpl();
        MInvocationHandler handler = new MInvocationHandler(greetingService);

        GreetingService proxy = (GreetingService) Proxy.newProxyInstance(GreetingService.class.getClassLoader(), new Class[]{GreetingService.class}, handler);
        proxy.sayHello();
    }
}
