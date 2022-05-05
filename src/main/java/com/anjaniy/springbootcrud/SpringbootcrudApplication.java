package com.anjaniy.springbootcrud;

import com.anjaniy.springbootcrud.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class SpringbootcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcrudApplication.class, args);
	}

}
