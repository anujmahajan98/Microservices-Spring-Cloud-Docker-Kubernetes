package com.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorld {

	private MessageSource messageSource;

	public HelloWorld(MessageSource theSource){
		this.messageSource = theSource;
	}
	
	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Hello World !!!";
	}

	@GetMapping("/helloWorldBean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}

	@GetMapping("/helloWorldBean/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@GetMapping(path = "/hello-i18n")
	public String helloWorldInternational() {
		Locale locale= LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

}
