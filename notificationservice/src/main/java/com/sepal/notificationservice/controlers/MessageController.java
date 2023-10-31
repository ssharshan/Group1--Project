package com.sepal.notificationservice.controlers;

import com.rabbitmq.client.Return;
import com.sepal.notificationservice.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
private RabbitMQProducer producer;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message)
    {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message Sent to RabbitMQ..............");

    }
}