package com.kafka.reader.receiver;

import com.kafka.reader.model.EventModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventReceiver {

    @StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'test'")
    public void handle(EventModel model) {
        log.info("recv : " + model.toString());

    }
}
