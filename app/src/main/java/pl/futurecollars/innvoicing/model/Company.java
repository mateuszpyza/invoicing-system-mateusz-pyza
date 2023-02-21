package pl.futurecollars.innvoicing.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
  private int id;
  private int taxIdentificationNumber;
  private String address;

}
