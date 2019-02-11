package com.kafka.reader.publisher;

import com.kafka.reader.model.EventModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EventPublisher {

    private final @NonNull
    Source source;


    @Scheduled(fixedRate = 2000)
    public void publishExternally() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("type", "test");
        EventModel eventModel = new EventModel();
        eventModel.setId(System.currentTimeMillis());
        eventModel.setContent("content");
        source.output().send(new GenericMessage<>(eventModel.toJson(), headers));

    }

}
