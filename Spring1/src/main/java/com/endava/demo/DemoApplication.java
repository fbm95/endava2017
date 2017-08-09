package com.endava.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppConfig.class);

		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		helloWorld.setMessage("Hello World!");
		helloWorld.getMessage();

		GoodbyeWorld goodbyeWorld = ctx.getBean(GoodbyeWorld.class);
//		goodbyeWorld.sayGoodbye("bye");
		goodbyeWorld.getGoodbye();

		ctx.close();
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("merge");
	}
}
