package com.cyberquote.BMA.SpiderEngine1;

import com.cyberquote.BMA.SpiderEngine1.Model.DataResult;
import com.cyberquote.BMA.SpiderEngine1.Model.MessageSpider;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cyberquote.BMA.SpiderEngine1.CrawlerEngine.CoreCrawling;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    @Autowired
    private CoreCrawling coreCrawling;

    @Autowired
    DataResult result;


    //private CountDownLatch latch = new CountDownLatch(1);
    @RabbitListener(queues = "queue-engine-spider")
    public String receiveMessage(final MessageSpider messageSpider){
        String result = coreCrawling.processCrawling(messageSpider);
        System.out.println(result);
        //latch.countDown();
        return result;

    }

    /*
    public CountDownLatch getLatch() {
        return latch;
    }*/
}