package org.sample.app;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.google.common.cache.CacheBuilder;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("org.sample")
@EntityScan("org.sample")
@EnableJpaRepositories("org.sample")
@EnableCaching
public class SpringbootCacheGuavaApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCacheGuavaApp.class, args);
	}

/*	@Bean
	public CacheManager cacheManager() {
		GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
		guavaCacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(24, TimeUnit.HOURS));
		return new ConcurrentMapCacheManager("ticketsCache");
	}*/

}
