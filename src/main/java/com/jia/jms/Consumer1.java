package com.jia.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: jia
 * @Date: 2018/7/19 14:29
 * @Description: 消息消费类
 */
@Component
public class Consumer1 {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "test.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer1收到的报文为:" + text);
    }
}
