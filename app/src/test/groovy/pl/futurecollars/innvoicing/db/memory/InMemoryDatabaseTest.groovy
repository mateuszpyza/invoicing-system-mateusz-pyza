package pl.futurecollars.innvoicing.db.memory

import pl.futurecollars.innvoicing.db.Database
import pl.futurecollars.innvoicing.model.Company
import pl.futurecollars.innvoicing.model.Invoice
import pl.futurecollars.innvoicing.model.InvoiceEntry
import pl.futurecollars.innvoicing.model.Vat
import spock.lang.Specification

import java.time.LocalDateTime

class InMemoryDatabaseTest extends Specification {
    def "Save"() {
        given:
        Database exampleDatabase= new InMemoryDatabase()
        Invoice exampleInvoice = new Invoice(LocalDateTime.now(),new Company("TaxIdentificationNumber","SellersCity","Seller")
                ,new Company("TaxIdentificationNumber","BuyersCity","Buyer")
                ,List.of(new InvoiceEntry("ExampleProduct",new BigDecimal(1000),new BigDecimal(Vat.VAT8.getRate()),Vat.VAT8)))

        when:
        exampleDatabase.save(List.of(exampleInvoice) )

        then:
        exampleDatabase.getAll() == List.of(exampleInvoice)

    }

    def "GetById"() {
        given:
        Database exampleDatabase= new InMemoryDatabase()
        Invoice exampleInvoice = new Invoice(LocalDateTime.now(),new Company("TaxIdentificationNumber","SellersCity","Seller")
                ,new Company("TaxIdentificationNumber","BuyersCity","Buyer")
                ,List.of(new InvoiceEntry("ExampleProduct",new BigDecimal(1000),new BigDecimal(Vat.VAT8.getRate()),Vat.VAT8)))
        exampleDatabase.save(exampleInvoice)
        when:
        Optional result = exampleDatabase.getById(1)
        then:
        result.get() == exampleInvoice

    }

    def "GetAll"() {
        given:
        Database exampleDatabase= new InMemoryDatabase()
        Invoice ExampleInvoice = new Invoice(LocalDateTime.now(),new Company("TaxIdentificationNumber","SellersCity","Seller")
                ,new Company("TaxIdentificationNumber","BuyersCity","Buyer")
                ,List.of(new InvoiceEntry("ExampleProduct",new BigDecimal(1000),new BigDecimal(Vat.VAT8.getRate()),Vat.VAT8)))

        when:
        exampleDatabase.save(List.of(ExampleInvoice))

        then:
        exampleDatabase.getAll() == List.of(ExampleInvoice)

    }

    def "Update"() {
        given:
        Database exampleDatabase= new InMemoryDatabase()
        Invoice exampleInvoice1 = new Invoice(LocalDateTime.now(),new Company("TaxIdentificationNumber","SellersCity","Seller")
                ,new Company("TaxIdentificationNumber","BuyersCity","Buyer")
                ,List.of(new InvoiceEntry("ExampleProduct",new BigDecimal(1000),new BigDecimal(Vat.VAT8.getRate()),Vat.VAT8)))

        Invoice exampleInvoice2 = new Invoice(LocalDateTime.now(),new Company("TaxIdentificationNumber2","SellersCity2","Seller2")
                ,new Company("TaxIdentificationNumber2","BuyersCity2","Buyer2")
                ,List.of(new InvoiceEntry("ExampleProduct2",new BigDecimal(10002),new BigDecimal(Vat.VAT8.getRate()),Vat.VAT8)))
        exampleDatabase.save(List.of(exampleInvoice1))
        when:
        exampleDatabase.update(1,exampleInvoice2)

        then:
        exampleDatabase.getAll() == List.of(exampleInvoice2)

    }

    def "Delete"() {
        given:
        Database exampleDatabase= new InMemoryDatabase()
        Invoice exampleInvoice = new Invoice(LocalDateTime.now(),new Company("TaxIdentificationNumber","SellersCity","Seller")
                ,new Company("TaxIdentificationNumber","BuyersCity","Buyer")
                ,List.of(new InvoiceEntry("ExampleProduct",new BigDecimal(1000),new BigDecimal(Vat.VAT8.getRate()),Vat.VAT8)))
        exampleDatabase.save(List.of(exampleInvoice))
        when:
        exampleDatabase.delete(1)
        then:
        exampleDatabase.getAll().isEmpty()

    }




}
