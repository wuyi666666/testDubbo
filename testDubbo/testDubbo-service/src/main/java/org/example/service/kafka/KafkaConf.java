package org.example.service.kafka;

import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

@Service
@DisconfFile(filename = "kafka.properties")
public class KafkaConf {
    // kafka生产者配置start
    private int poolSize;

    private String proClusterName;

    private String proSystemUrl;

    private String templateTopicToken;
    
    private String templateTopic;
    // kafka生产者配置end
    private int messageGroupSize;
    
    private int consumeThreadCount;
    
    private String conClusterName;
    
    private String systemIdToken;
    
    private String conSystemUrl;
    
    private String consume_topic_sgs_resource;

    @DisconfFileItem(name = "kafaka.product.poolsize")
    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    @DisconfFileItem(name = "kafaka.product.clustername")
    public String getProClusterName() {
        return proClusterName;
    }

    public void setProClusterName(String proClusterName) {
        this.proClusterName = proClusterName;
    }
    
    @DisconfFileItem(name = "kafaka.product.systemurl")
    public String getProSystemUrl() {
        return proSystemUrl;
    }

    public void setProSystemUrl(String proSystemUrl) {
        this.proSystemUrl = proSystemUrl;
    }

    @DisconfFileItem(name = "kafaka.product.template.topicTokens")
	public String getTemplateTopicToken() {
		return templateTopicToken;
	}

	public void setTemplateTopicToken(String templateTopicToken) {
		this.templateTopicToken = templateTopicToken;
	}

	@DisconfFileItem(name = "kafaka.product.template.topic")
	public String getTemplateTopic() {
		return templateTopic;
	}

	public void setTemplateTopic(String templateTopic) {
		this.templateTopic = templateTopic;
	}

	@DisconfFileItem(name = "kafaka.consume_messageGroupSize")
	public int getMessageGroupSize() {
		return messageGroupSize;
	}

	public void setMessageGroupSize(int messageGroupSize) {
		this.messageGroupSize = messageGroupSize;
	}

	@DisconfFileItem(name = "kafaka.consume_consumeThreadCount")
	public int getConsumeThreadCount() {
		return consumeThreadCount;
	}

	public void setConsumeThreadCount(int consumeThreadCount) {
		this.consumeThreadCount = consumeThreadCount;
	}

	@DisconfFileItem(name = "kafaka.consume_clusterName")
	public String getConClusterName() {
		return conClusterName;
	}

	public void setConClusterName(String conClusterName) {
		this.conClusterName = conClusterName;
	}

	@DisconfFileItem(name = "kafaka.consume_systemIdToken")
	public String getSystemIdToken() {
		return systemIdToken;
	}

	public void setSystemIdToken(String systemIdToken) {
		this.systemIdToken = systemIdToken;
	}

	@DisconfFileItem(name = "kafaka.consume_systemUrl")
	public String getConSystemUrl() {
		return conSystemUrl;
	}

	public void setConSystemUrl(String conSystemUrl) {
		this.conSystemUrl = conSystemUrl;
	}

	@DisconfFileItem(name = "kafaka.consume_topic_sgs_resource")
	public String getConsume_topic_sgs_resource() {
		return consume_topic_sgs_resource;
	}

	public void setConsume_topic_sgs_resource(String consume_topic_sgs_resource) {
		this.consume_topic_sgs_resource = consume_topic_sgs_resource;
	}  
    
}

