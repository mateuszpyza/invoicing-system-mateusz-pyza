package pl.futurecollars.innvoicing.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public enum Vat {
  VAT23(23),
  VAT8(8),
  VAT5(5),
  VAT(0);


  private final BigDecimal rate;

  Vat(int rate) {
    this.rate = BigDecimal.valueOf(rate);
  }
}
