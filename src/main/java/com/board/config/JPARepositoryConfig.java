package com.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@Configuration
@EnableJpaRepositories(basePackages = {"com.board.instance"}, entityManagerFactoryRef = "emf")
@EnableSpringDataWebSupport
public class JPARepositoryConfig {

}
