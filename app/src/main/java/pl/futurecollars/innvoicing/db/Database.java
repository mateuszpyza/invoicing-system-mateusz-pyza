package pl.futurecollars.innvoicing.db;

import java.util.List;
import java.util.Optional;
import pl.futurecollars.innvoicing.model.Invoice;

public interface Database {
  int save(Invoice invoice);

  Optional<Invoice> getById(int id);

  List<Invoice> getAll();

  int update(int id, Invoice updatedInvoice);

  int delete(int id);


}
