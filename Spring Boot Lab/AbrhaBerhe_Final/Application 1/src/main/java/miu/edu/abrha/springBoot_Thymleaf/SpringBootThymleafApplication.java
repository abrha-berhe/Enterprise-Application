package miu.edu.abrha.springBoot_Thymleaf;

import miu.edu.abrha.springBoot_Thymleaf.model.Author;
import miu.edu.abrha.springBoot_Thymleaf.model.Book;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "miu.edu.abrha.springBoot_Thymleaf")
@EnableJpaRepositories
@EnableTransactionManagement
@EnableJms
@EnableAspectJAutoProxy
@EnableScheduling
public class SpringBootThymleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymleafApplication.class, args);



	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter(){
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("myConvertor");
		return converter;
	}



}
