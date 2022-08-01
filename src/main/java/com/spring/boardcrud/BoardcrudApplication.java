package com.spring.boardcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing //JPA auditing 기능 사용 위해 메인에 붙이는 어노테이션
@SpringBootApplication
public class BoardcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardcrudApplication.class, args);
	}

	@Bean //PutMapping 사용 위해 빈 등록
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
