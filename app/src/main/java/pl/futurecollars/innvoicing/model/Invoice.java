package pl.futurecollars.innvoicing.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Invoice {

  private int id;
  private LocalDateTime date;
  private Company seller;
  private Company buyer;
  private List<InvoiceEntry> entries;

  public Invoice(LocalDateTime date, Company seller, Company buyer, List<InvoiceEntry> entries) {
    this.date = date;
    this.seller = seller;
    this.buyer = buyer;
    this.entries = entries;
  }
}
