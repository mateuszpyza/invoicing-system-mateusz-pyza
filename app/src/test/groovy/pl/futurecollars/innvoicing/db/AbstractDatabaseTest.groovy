package pl.futurecollars.innvoicing.db


import pl.futurecollars.innvoicing.model.Company
import pl.futurecollars.innvoicing.model.Invoice
import pl.futurecollars.innvoicing.model.InvoiceEntry
import pl.futurecollars.innvoicing.model.Vat
import spock.lang.Specification

import java.time.LocalDateTime

abstract class AbstractDatabaseTest extends Specification {

    Database database

    abstract Database initDatabase()

   void set() {
        database = initDatabase()
    }


    /*
    def "should save invoices returning sequential id, invoice should have id set to correct value, get by id returns saved invoice"() {
        when:
        def ids = invoices.collect({ database.save(it) })

        then:
        ids == (1..invoices.size()).collect()
        ids.forEach({ assert database.getById(it).isPresent() })
        ids.forEach({ assert database.getById(it).get().getId() == it })
        ids.forEach({ assert database.getById(it).get() == invoices.get(it - 1) })
    }*/


    def "getAll should return proper amount of invoices"() {
        given:
        (1..5).collect({ database.save(new Invoice(LocalDateTime.now()
                ,new Company("TaxIdentificationNumber"+it.toString(),"SellersCity"+it.toString(),"Seller")
                ,new Company("TaxIdentificationNumber"+it.toString(),"BuyersCity"+it.toString(),"Buyer")
                ,List.of(new InvoiceEntry("ExampleProduct",new BigDecimal(1000),new BigDecimal(Vat.VAT8.getRate()),Vat.VAT8))))})
        when:
        def invoices = database.getAll()
        then:
        invoices.size() == 5
    }

    //def "getById() should return Optional.empty when invoice with given not found"(){
   //    expect:
   //     database.getById("nonExistingId" ).isEmpty()
    //}

}
