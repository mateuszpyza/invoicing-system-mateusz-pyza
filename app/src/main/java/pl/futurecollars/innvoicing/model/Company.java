package pl.futurecollars.innvoicing.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
  private String taxIdentificationNumber;
  private String address;
  private String name;

}
