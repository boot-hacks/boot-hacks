package io.pivotal.boothacks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BootHacksProperties.class)
public class BootHacksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootHacksApplication.class, args);
	}

}
