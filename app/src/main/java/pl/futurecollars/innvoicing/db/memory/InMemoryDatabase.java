package pl.futurecollars.innvoicing.db.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.LinkedTransferQueue;
import lombok.Getter;
import lombok.Setter;
import pl.futurecollars.innvoicing.db.Database;
import pl.futurecollars.innvoicing.model.Invoice;


public class InMemoryDatabase implements Database {

  private static Map<Integer, Invoice> invoices = new HashMap<>();
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
  public int update(int id, Invoice updatedInvoice) {
    if (invoices.containsKey(id)) {
      return Objects.requireNonNull(invoices.put(id, updatedInvoice)).getId();
    }
    return -1;
  }

  @Override
  public int delete(int id) {
    if(invoices.containsKey(id)){
     return invoices.remove(id).getId();
    }
    return -1;

  }
}
