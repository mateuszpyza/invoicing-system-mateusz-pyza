package pl.futurecollars.innvoicing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Company {
  private String taxIdentificationNumber;
  private String address;
  private String name;

}
