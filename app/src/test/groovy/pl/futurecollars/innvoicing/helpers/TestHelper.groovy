package pl.futurecollars.innvoicing.helpers

import lombok.Builder
import pl.futurecollars.innvoicing.model.Company
import pl.futurecollars.innvoicing.model.Invoice
import pl.futurecollars.innvoicing.model.InvoiceEntry
import pl.futurecollars.innvoicing.model.Vat

import java.time.LocalDate
import java.time.LocalDateTime

class TestHelper {


    static company(int id) {
        Company.builder()
                .taxIdentificationNumber(id.toString())
                .address("Chrząszczyżewoszyce " + id.toString())
                .name("buyer" + id.toString())
                .build()
    }

    static product(int id) {

        InvoiceEntry.builder()
                .description(id % 2 ? "Buyer" : "Seller" + id.toString())
                .price(new BigDecimal(1999))
                .vatValue(Vat.VAT8.getRate())
                .vatRate(Vat.VAT8)
                .build()
    }

    static invoice(id) {
        Invoice.builder()
                .date(LocalDateTime.now())
                .id(id)
                .buyer(company(id))
                .seller(company(id))
                .entries(List.of(product(id)))
                .build()
    }
}


/*
    static Invoice createInvoice(int id) {
        Company.builder()
        Company buyer = new Company(id.toString(), "Warszawa", "buyer");
        Company seller = new Company(id.toString(), "Kraków", "seller");

        List<InvoiceEntry> products = List.of(new InvoiceEntry("Kebab", new BigDecimal(1000), Vat.VAT8.getRate().multiply(new BigDecimal(1000)), Vat.VAT8));
        Invoice invoice = new Invoice(LocalDateTime.now(), buyer, seller, products);


        return Invoice.builder()
    }

 */

