package com.example.SpringbootWEBAPI;

import com.example.SpringbootWEBAPI.config.CORS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringbootWEBAPI {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWEBAPI.class, args);
	}

}
