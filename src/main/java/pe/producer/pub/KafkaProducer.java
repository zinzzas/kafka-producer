package pe.producer.pub;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaProducer {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public int sendMessage(String topic, List<JSONObject> obj) {
    int failCount = 0;
    try {
      for (JSONObject dto : obj) {
        Message<JSONObject> message = MessageBuilder
            .withPayload(dto)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .build();
        kafkaTemplate.send(message);
      }
    } catch (Exception e) {
      failCount++;
    }
    return failCount;
  }
}
