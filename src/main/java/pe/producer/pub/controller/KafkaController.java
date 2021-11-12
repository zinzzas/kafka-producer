package pe.producer.pub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.producer.pub.KafkaProducer;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
public class KafkaController {
  private final KafkaProducer kafkaProducer;

  @GetMapping("/send")
  public ResponseEntity sendMessage() {
    kafkaProducer.sendMessageQue();
    return new ResponseEntity(HttpStatus.OK);
  }
}
