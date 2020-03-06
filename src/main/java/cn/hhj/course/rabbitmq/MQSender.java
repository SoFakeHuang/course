package cn.hhj.course.rabbitmq;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: SoFakeHuang
 * @Date: 2019/7/5 3:28
 * @Version 1.0
 */
@Service
public class MQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendElectiveMessage(ElectiveMessage message) {
        String context = beanToString(message);
        amqpTemplate.convertAndSend(MQConfig.ELECTIVE_QUEUE, context);
    }

    public static <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }
}
