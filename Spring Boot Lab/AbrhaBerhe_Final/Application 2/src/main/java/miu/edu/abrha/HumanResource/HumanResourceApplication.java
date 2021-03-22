package miu.edu.abrha.HumanResource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.jms.ConnectionFactory;

@EnableJms
@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = {
		"miu.edu.abrha.springBoot_Thymleaf.model" ,
		"miu.edu.abrha.HumanResource.Receiver",
		"miu.edu.abrha.HumanResource.Service"} ) //miu.edu.abrha.springBoot_Thymleaf.model.Receipt2
public class HumanResourceApplication {
	public static void main(String[] args) {
		SpringApplication.run(HumanResourceApplication.class, args);
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("myConvertor");
		return converter;
	}



//	@Bean
//	public MessageConverter convertor(){
//		return new MappingJackson2MessageConverter();
//	}

}
