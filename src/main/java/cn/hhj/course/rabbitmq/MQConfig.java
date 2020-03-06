package cn.hhj.course.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: SoFakeHuang
 * @Date: 2019/7/5 3:22
 * @Version 1.0
 */
@Configuration
public class MQConfig {

    public static final String ELECTIVE_QUEUE = "elective.queue";

    @Bean
    public Queue electiveQueue(){
        return new Queue(ELECTIVE_QUEUE, true);
    }

}
