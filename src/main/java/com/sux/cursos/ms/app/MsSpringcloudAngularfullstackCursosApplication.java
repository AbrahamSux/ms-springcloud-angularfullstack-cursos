package com.sux.cursos.ms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsSpringcloudAngularfullstackCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSpringcloudAngularfullstackCursosApplication.class, args);
	}

}
