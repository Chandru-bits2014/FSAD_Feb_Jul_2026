package com.bits.hook.hookdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HookdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HookdemoApplication.class, args);
		System.out.println("Welcome to Hooks..");
	}

}
