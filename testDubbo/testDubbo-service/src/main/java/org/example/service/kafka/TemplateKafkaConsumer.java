package org.example.service.kafka;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.kafka.api.consume.ConsumeConfig;
import com.sf.kafka.api.consume.ConsumeOptionalConfig;
import com.sf.kafka.api.consume.ConsumeOptionalConfig.AutoOffsetReset;
import com.sf.kafka.api.consume.KafkaConsumerRegister;
import com.sf.kafka.exception.KafkaException;

/**
 * 消费者
 * @author 698533
 *
 */
@Component
public class TemplateKafkaConsumer implements InitializingBean {
    @Autowired
    private KafkaConf kafkaConf;

    @Autowired
    private TemplateKafkaConListener templateKafkaConListener;

    @Override
    public void afterPropertiesSet() throws Exception {
        initKafkaConfig();
    }

    public void initKafkaConfig() throws KafkaException {
        ConsumeOptionalConfig optionalConfig = new ConsumeOptionalConfig();
        optionalConfig.setMessageGroupSize(kafkaConf.getMessageGroupSize());
        optionalConfig.setAutoOffsetReset(AutoOffsetReset.BEGIN);
        ConsumeConfig pickupConsumeConfig = getConsumeConfig(kafkaConf.getConsume_topic_sgs_resource());
        KafkaConsumerRegister.registerStringConsumer(pickupConsumeConfig, templateKafkaConListener, optionalConfig);
    }

    private ConsumeConfig getConsumeConfig(String topicName) {
        return new ConsumeConfig(kafkaConf.getSystemIdToken(), kafkaConf.getConSystemUrl(), kafkaConf.getConClusterName(), topicName, kafkaConf.getConsumeThreadCount());
    }

}

