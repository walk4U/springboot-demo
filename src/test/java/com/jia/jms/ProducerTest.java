package com.jia.jms;

import com.jia.ApplicationTests;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Auther: jia
 * @Date: 2018/7/19 14:31
 * @Description:
 */
public class ProducerTest extends ApplicationTests{

    @Autowired
    Producer producer;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Test
    public void sendMessage() {
        for(int i=0; i<10; i++){
            producer.sendMessage(queue, i + " : my name is queue!");
            producer.sendMessage(topic, i + " : my name is topic!");
        }
    }
}