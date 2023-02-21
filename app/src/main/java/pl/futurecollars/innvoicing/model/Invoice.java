package pl.futurecollars.innvoicing.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Invoice {

  private Long id;
  private LocalDateTime date;
  private String creatorName;
  private String destinationCompanyName;
  private List<InvoiceEntry> entries;


}
