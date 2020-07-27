package org.example.service.kafka;

/*
* Copyright 2015-2020 SF-Express Tech Company. 
*/

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.kafka.api.produce.IKafkaProducer;
import com.sf.kafka.api.produce.ProduceConfig;
import com.sf.kafka.api.produce.ProducerPool;

/**
 * kafka 生产者
 * @author 698533
 *
 */
@Component
public class TemplateKafkaProduce implements InitializingBean, DisposableBean {
    private IKafkaProducer kafkaProducer;

    @Autowired
    private KafkaConf kafkaConf;

    @Override
    public void afterPropertiesSet() throws Exception {
        int poolSize = kafkaConf.getPoolSize();
        String systemUrl = kafkaConf.getProSystemUrl();
        String clusterName = kafkaConf.getProClusterName();
        String topicTokens = kafkaConf.getTemplateTopicToken();
        ProduceConfig produceConfig = new ProduceConfig(poolSize, systemUrl, clusterName, topicTokens);
        kafkaProducer = new ProducerPool(produceConfig);
    }

    @Override
    public void destroy() throws Exception {
        if (kafkaProducer != null) {
            kafkaProducer.close();
        }
    }

    /**
     * 发送消息
     * 
     * @param message
     */
    public void sendSingleString(String message) {
        String topic = kafkaConf.getTemplateTopic();
        sendSingleString(topic, message);
    }

    private void sendSingleString(String topic, String message) {
        kafkaProducer.sendString(topic, message);
    }

}

