package com.endava.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodbyeWorld implements InitializingBean, DisposableBean {

    @Autowired
    private HelloWorld helloWorld;

    public void sayGoodbye(String message){
        helloWorld.setMessage(message);
    }

    public void getGoodbye(){
        helloWorld.getMessage();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---------------after goodbyeWorld bean has properties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("---------------after goodbyeWorld bean is destroyed");
    }
}
