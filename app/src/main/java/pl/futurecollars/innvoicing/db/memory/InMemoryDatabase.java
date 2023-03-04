package pl.futurecollars.innvoicing.db.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import pl.futurecollars.innvoicing.db.Database;
import pl.futurecollars.innvoicing.model.Invoice;


public class InMemoryDatabase implements Database {

  private static final Map<Integer, Invoice> invoices = new HashMap<>();
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
  public void update(int id, Invoice updatedInvoice) {
    if (invoices.containsKey(id)) {
      Objects.requireNonNull(invoices.put(id, updatedInvoice));
    }
  }

  @Override
  public void delete(int id) {
    invoices.remove(id);
  }
}
