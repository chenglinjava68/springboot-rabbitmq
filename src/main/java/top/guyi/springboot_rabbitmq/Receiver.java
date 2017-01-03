package top.guyi.springboot_rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@RabbitListener(queues="my-queue")
public class Receiver{

	@RabbitHandler
	public void receiveMessage(String message){
		System.out.println("接受到："+message);
	}

	@Bean
	public Queue testQueue(){
		return new Queue("my-queue");
	}
	
	@Bean
	public TopicExchange topicExchange(){
		return new TopicExchange("my-topic");
	}
	
	@Bean
    Binding binding(Queue queueBar, TopicExchange exchange) {
        Binding binding = BindingBuilder.bind(queueBar).to(exchange).with("my-queue");
        return binding;
    }
}
