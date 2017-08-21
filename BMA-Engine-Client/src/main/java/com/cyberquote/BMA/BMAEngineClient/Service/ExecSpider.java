package com.cyberquote.BMA.BMAEngineClient.Service;

import com.cyberquote.BMA.BMAEngineClient.Model.DataResult;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExecSpider {

    @Autowired
    private Queue queue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void exec(String link){
        String result = (String) rabbitTemplate.convertSendAndReceive(queue.getName(), link);
        System.out.println("Start Crawler : " +link + "Result "+ result);
    }
}
