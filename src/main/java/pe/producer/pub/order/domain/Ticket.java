package pe.producer.pub.order.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
  private long userNo;
  private long chargeNo;
  private long prodId;
  private String productName;
  private String displayProdName;
  private String programName;
  private String frequency;
  private String epName;
  private String prodType;
  private long itemId;
  private String itemType;
  private int itemAttr;
  private String itemAttrName;
  private long packageId;
  private String packageType;
  private long packageAttr;
  private String packageAttrName;
  private String isSpeed;
  private String recurUseState;
  private String consumeDate;
  private String orgExpiryDate;
  private String expiryDate;
  private int vodDownCount;
  private int vodDownRemainTime;
  private long maxAccessCount;
  private int accessCount;
  private long remainTime;
  private int remainDay;
  private int price;
  private int status;
  private String serviceType;
  private String vodType;
  private String cmsItemId;
  private String regDate;
  private int duration;
  private String durationType;
  private String durationTypeM;
  private String durationM;
  private String pmType;
  private String chargeFlag;
  private String provideFlag;
  private String drmYn;
  private String downServYn;
  private String recurPayChangeableYn;
  private int recurNo;
  private String downloadYn;
  private int rowNum;
}
