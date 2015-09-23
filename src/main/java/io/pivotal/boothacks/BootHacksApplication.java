package io.pivotal.boothacks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
@EnableConfigurationProperties(BootHacksProperties.class)
public class BootHacksApplication {

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("mymessages");
		return messageSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootHacksApplication.class, args);
	}
}
