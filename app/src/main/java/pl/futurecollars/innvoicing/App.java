/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package pl.futurecollars.innvoicing;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import pl.futurecollars.innvoicing.db.Database;
import pl.futurecollars.innvoicing.db.memory.InMemoryDatabase;
import pl.futurecollars.innvoicing.model.Company;
import pl.futurecollars.innvoicing.model.Invoice;
import pl.futurecollars.innvoicing.model.InvoiceEntry;
import pl.futurecollars.innvoicing.model.Vat;
import pl.futurecollars.innvoicing.service.InvoiceService;

public class App {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {

    Database db = new InMemoryDatabase();
    InvoiceService service = new InvoiceService(db);

    Company buyer = new Company("1", "1", "Warszawa");
    Company seller = new Company("2", "2", "Kraków");


    List<InvoiceEntry> products1 = List.of(new InvoiceEntry("Kebab", new BigDecimal(1000), Vat.VAT8.getRate().multiply(new BigDecimal(1000)), Vat.VAT8));

    Invoice invoice1 = new Invoice(LocalDateTime.now(), buyer, seller, products1);

    List<InvoiceEntry> products2 = List.of(new InvoiceEntry("Kapusta", new BigDecimal(1000), Vat.VAT8.getRate().multiply(new BigDecimal(1000)), Vat.VAT8));
    Invoice invoice2 = new Invoice(LocalDateTime.now(), buyer, seller, products2);

    List<InvoiceEntry> products3 = List.of(new InvoiceEntry("Pyra", new BigDecimal(1000), Vat.VAT8.getRate().multiply(new BigDecimal(1000)), Vat.VAT8));
    Invoice invoice3 = new Invoice(LocalDateTime.now(), buyer, seller, products2);


    int id = service.save(invoice1);
     id = service.save(invoice2);
    service.getAll().forEach(System.out::println);
    //System.out.println(service.getById(1));
    //System.out.println(service.getById(2));



    System.out.println(service.update(1,invoice3));
    service.getAll().forEach(System.out::println);
    System.out.println(service.update(1,invoice1));
    service.getAll().forEach(System.out::println);
    System.out.println(service.update(1,invoice3));
    service.getAll().forEach(System.out::println);




  }
}
