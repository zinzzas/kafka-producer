package pe.producer.pub.order.controller;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.producer.pub.order.Reader.OrderReader;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
  private final OrderReader orderReader;

  @GetMapping("/purchase/tickets")
  public ResponseEntity sendPurchaseTickets() throws IOException {
    orderReader.sendPurchaseTicketQue();
    return new ResponseEntity(HttpStatus.OK);
  }
}
