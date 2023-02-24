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

   /* def "getAll should return proper amount of invoices"() {
        given:
        (1..5).collect({ database.save(createInvoice(it)) })
        when:
        def invoices = database.getAll()
        then:
        invoices.size() == 1
    }
*/
    def "getById() should return Optional.empty when invoice with given not found"(){
        expect:
        database.getById("nonExistingId").isEmpty()
    }

}
