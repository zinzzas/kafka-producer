package pe.producer.pub;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pe.producer.pub.order.Reader.OrderReader;
import pe.producer.pub.order.controller.OrderController;

@SpringBootTest
public class MockTest {

  @Mock
  List mockList;

  @Mock
  OrderReader orderReader;

  @Test
  void mock_test() throws IOException {

    OrderController mock = mock(OrderController.class);

    given(orderReader.sendPurchaseTicketQue())
        .willReturn("mock_test");

    when(mockList.get(0)).thenReturn("mock_test");

    verifyNoInteractions(mockList);
  }
}
