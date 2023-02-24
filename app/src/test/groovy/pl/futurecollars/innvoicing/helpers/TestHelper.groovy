package pl.futurecollars.innvoicing.helpers

import pl.futurecollars.innvoicing.model.Company
import pl.futurecollars.innvoicing.model.Invoice
import pl.futurecollars.innvoicing.model.InvoiceEntry
import pl.futurecollars.innvoicing.model.Vat

import java.time.LocalDateTime

class TestHelper {
    static Invoice createInvoice(int id) {
        Company buyer = new Company("1", "Warszawa", "buyer");
        Company seller = new Company("2", "Kraków", "seller");

        List<InvoiceEntry> products = List.of(new InvoiceEntry("Kebab", new BigDecimal(1000), Vat.VAT8.getRate().multiply(new BigDecimal(1000)), Vat.VAT8));
        Invoice invoice = new Invoice(LocalDateTime.now(), buyer, seller, products);


        return invoice
    }
}
