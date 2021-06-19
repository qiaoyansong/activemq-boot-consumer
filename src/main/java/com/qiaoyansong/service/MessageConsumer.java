package com.qiaoyansong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author ：Qiao Yansong
 * @date ：Created in 2021/6/19 17:30
 * description：
 */
@Service
public class MessageConsumer {

    @Autowired
    private JmsMessagingTemplate template;

    @Value("${queueName}")
    private String queueName;

    /**
     * 使用Receive接收消息 在测试类中调用
     */
    public void consumeWithReceive(){
        String s = template.receiveAndConvert(queueName, String.class);
        System.out.println("收到的消息为" + s);
    }

    /**
     * 使用监听器获取消息 对于这个也是只需要启动主启动类即可
     */
    @JmsListener(destination = "${queueName}")
    public void consumeWithListener(Message message) throws JMSException {
        if(message != null && message instanceof TextMessage){
            TextMessage text = (TextMessage) message;
            System.out.println("接收到的消息为" + text.getText());
        }
    }
}
