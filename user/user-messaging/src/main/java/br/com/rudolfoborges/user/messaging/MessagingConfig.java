package br.com.rudolfoborges.user.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rudolfoborges on 27/07/17.
 */
@EnableRabbit
@Configuration
@EnableFeignClients(basePackages = {"br.com.rudolfoborges.user.messaging"})
@PropertySource(ignoreResourceNotFound = false, value = "classpath:messaging-application.properties")
@PropertySource(ignoreResourceNotFound = false, value = "classpath:messaging-application-${spring.profiles.active}.properties")
public class MessagingConfig {

	@Value("${rabbit.user.exchange}")
	private String exchange;

	@Value("${rabbit.user.dlq}")
	private String dlqQueue;

	@Value("${rabbit.user.queue}")
	private String queueName;

	@Value("${spring.rabbitmq.username}")
	private String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	@Value("${spring.rabbitmq.addresses}")
	private String hostname;

	@Value("${spring.rabbitmq.virtualHost}")
	private String virtualHost;

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(hostname, 5672);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost(virtualHost);


		return connectionFactory;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {
		final RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
		rabbitAdmin.setAutoStartup(true);
		rabbitAdmin.declareExchange(exchange());
		rabbitAdmin.declareQueue(queue());
		rabbitAdmin.declareQueue(deadLetterQueue());
		rabbitAdmin.declareBinding(binding(queue(), exchange()));
		rabbitAdmin.declareBinding(deadLetterBinding(deadLetterQueue(), exchange()));

		return rabbitAdmin;
	}


	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	public Queue deadLetterQueue() {
		return new Queue(dlqQueue, true);
	}

	@Bean
	public Queue queue() {
		final Map<String, Object> args = new HashMap<>();
		args.put("x-dead-letter-exchange", exchange);
		args.put("x-dead-letter-routing-key", dlqQueue);
		return new Queue(queueName, true, false, false, args);
	}

	@Bean
	public Binding deadLetterBinding(Queue deadLetterQueue,
									 DirectExchange exchange) {
		return BindingBuilder
				.bind(deadLetterQueue)
				.to(exchange)
				.with(dlqQueue);
	}

	@Bean
	public Binding binding(Queue queue,
						   DirectExchange exchange) {
		return BindingBuilder
				.bind(queue)
				.to(exchange)
				.with(queueName);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		jackson2JsonMessageConverter.setJsonObjectMapper(objectMapper);
		return jackson2JsonMessageConverter;
	}


}
