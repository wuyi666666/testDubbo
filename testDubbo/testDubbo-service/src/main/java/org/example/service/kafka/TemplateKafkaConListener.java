package org.example.service.kafka;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sf.kafka.api.consume.IStringMessageConsumeListener;
import com.sf.kafka.api.consume.KafkaConsumeRetryException;

/**
 * kafka消费逻辑方法
 * @author 698533
 *
 */
@Component
public class TemplateKafkaConListener implements IStringMessageConsumeListener {

    @Override
    public void onMessage(List<String> messages) throws KafkaConsumeRetryException {
        try {
            for (String jsonStr : messages) {
            	//逻辑处理
            }
        } catch (Exception ex) {
           	//异常处理
        }
    }

}
