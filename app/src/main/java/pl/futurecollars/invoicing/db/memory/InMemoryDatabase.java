package pl.futurecollars.invoicing.db.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.model.Invoice;

@Repository
public class InMemoryDatabase implements Database {

  private final Map<Integer, Invoice> invoices = new HashMap<>();
  private int nextId = 1;

  @Override
  public int save(Invoice invoice) {
    invoice.setId(nextId);
    invoices.put(nextId, invoice);

    return nextId++;
  }

  @Override
  public Optional<Invoice> getById(int id) {
    return Optional.ofNullable(invoices.get(id));
  }

  @Override
  public List<Invoice> getAll() {
    return new ArrayList<>(invoices.values());
  }

  @Override
  public Optional<Invoice> update(int id, Invoice updatedInvoice) {

    updatedInvoice.setId(id);

    return Optional.ofNullable(invoices.put(id, updatedInvoice));
  }

  @Override
  public Optional<Invoice> delete(int id) {
    return Optional.ofNullable(invoices.remove(id));
  }
}
