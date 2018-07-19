package com.jia.jms;

import com.jia.ApplicationTests;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Destination;

/**
 * @Auther: jia
 * @Date: 2018/7/19 14:31
 * @Description:
 */
public class ProducerTest extends ApplicationTests{

    @Autowired
    Producer producer;

    @Test
    public void sendMessage() {
        Destination destination = new ActiveMQQueue("test.queue");

        for(int i=0; i<100; i++){
            producer.sendMessage(destination, "my name is jia!");
        }
    }
}