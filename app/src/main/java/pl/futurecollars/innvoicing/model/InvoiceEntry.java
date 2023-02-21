package pl.futurecollars.innvoicing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEntry {
  private String description;
  private double price;
  private double vatValue;
  private Vat vatRate;

}
