package com.cyberquote.BMA.BMAEngineClient.Controller;

import com.cyberquote.BMA.BMAEngineClient.Model.DataResult;
import com.cyberquote.BMA.BMAEngineClient.Model.MessageSpider;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/crawlerAPI")
public class CrawlerAPI {

    @Autowired
    private Queue queue;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/run/{LinkName}/{page}")
    public DataResult runSpider(@PathVariable String LinkName , @PathVariable String page ){

        final MessageSpider message = new MessageSpider(LinkName, page);

        String result = (String) rabbitTemplate.convertSendAndReceive(queue.getName(), message);
        DataResult dataResult = new DataResult();

        ObjectMapper mapper = new ObjectMapper();
        try {
             dataResult = mapper.readValue(result, DataResult.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataResult;
    }


}
