package com.jonathanmeraz.didemo;

import com.jonathanmeraz.didemo.controllers.MyController;
import com.jonathanmeraz.didemo.examplebeans.FakeDataSource;
import com.jonathanmeraz.didemo.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUser());

		System.out.println(ctx.getBean(FakeJmsBroker.class).getUser() + " " + ctx.getBean(FakeJmsBroker.class).getPassword());
	}
}
