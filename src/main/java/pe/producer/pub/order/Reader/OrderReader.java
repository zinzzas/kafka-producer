package pe.producer.pub.order.Reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pe.producer.pub.KafkaProducer;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderReader {

  @Value(value = "${purchase.ticket.topic.name}")
  private String ticketsTopicName;

  @Value("classpath:doc/ticket.json")
  Resource ticket;

  private final KafkaProducer producer;

  public void sendPurchaseTicketQue() throws IOException {
    log.info("send purchase Start {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    // List<Ticket> ticketList = new ObjectMapper().readValue(ticket.getFile(), new TypeReference<List<Ticket>>(){});
    List<JSONObject> ticketList = new ObjectMapper().readValue(ticket.getFile(), new TypeReference<List<JSONObject>>(){});
    producer.sendMessage(ticketsTopicName, ticketList);
  }
}
