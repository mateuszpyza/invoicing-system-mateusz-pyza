package pl.futurecollars.innvoicing.db;

import java.util.List;
import java.util.Optional;
import pl.futurecollars.innvoicing.model.Invoice;

public interface Database {
  String save(Invoice invoice);

  Optional<Invoice> getById(int id);

  List<Invoice> getAll();

  void update(int id, Invoice updatedInvoice);

  void delete(int id);


}
