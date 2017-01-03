package top.guyi.springboot_rabbitmq;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRabbitMQ implements CommandLineRunner{

	@Resource
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitMQ.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		rabbitTemplate.convertAndSend("my-topic","my-queue","测试消息发送-topic");
	}
	
}
