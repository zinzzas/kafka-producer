package pe.producer.pub;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class KafkaProducerTest {

  @Value(value = "${kafka.test.topic.name}")
  private String testTopicName;

  @Autowired
  private KafkaProducer kafkaProducer;

  @DisplayName("Kafka Producer 메시지 전송")
  @Test
  public void sendMessageQue() throws JSONException {
    List<JSONObject> jsonObjects = new ArrayList<>();
    JSONObject obj = new JSONObject();
    obj.put("1", "메시지 1번 전송");
    obj.put("2", "메시지 2번 전송");
    obj.put("3", "메시지 3번 전송");
    jsonObjects.add(obj);

    kafkaProducer.sendMessage(testTopicName, jsonObjects);
  }
}
