package pl.futurecollars.innvoicing.service;

import java.util.List;
import java.util.Optional;
import pl.futurecollars.innvoicing.db.Database;
import pl.futurecollars.innvoicing.model.Invoice;

public  class InvoiceService {

  private static  Database database;

  public InvoiceService(Database database) {
    InvoiceService.database = database;
  }


  public int save(Invoice invoice){
    return database.save(invoice);
  }
  public  List<Invoice> getAll (){
    return database.getAll();
  }
  public Optional<Invoice> getById(int id) {
    return database.getById(id);
  }
  public int update(int id, Invoice updatedInvoice) {
    return database.update(id,updatedInvoice);
  }

}
