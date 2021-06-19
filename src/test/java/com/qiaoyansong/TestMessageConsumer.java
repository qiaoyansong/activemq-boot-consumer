package com.qiaoyansong;

import com.qiaoyansong.service.MessageConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：Qiao Yansong
 * @date ：Created in 2021/6/19 17:34
 * description：
 */
@SpringBootTest
public class TestMessageConsumer {

    @Autowired
    private MessageConsumer consumer;

    @Test
    public void testConsumeWithReceive(){
        consumer.consumeWithReceive();
    }

}
