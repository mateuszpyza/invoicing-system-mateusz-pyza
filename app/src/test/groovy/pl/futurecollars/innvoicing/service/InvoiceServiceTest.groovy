package pl.futurecollars.innvoicing.service


import pl.futurecollars.innvoicing.db.memory.InMemoryDatabase
import pl.futurecollars.innvoicing.helpers.TestHelper
import spock.lang.Specification

class InvoiceServiceTest extends Specification {

    InMemoryDatabase inMemoryDatabase = new InMemoryDatabase()
    InvoiceService service = new InvoiceService(inMemoryDatabase)

    def "getAll should return proper amount of invoices"() {
        given:
        (1..12).collect({ service.save(TestHelper.invoice(it)) })
        when:
        def invoices = service.getAll()
        then:
        invoices.size() == 12

    }


    def "getById() should return Optional.empty when invoice with given id not found"() {
        expect:
        service.getById(10000).isEmpty()
    }

    def "update() should update chosen element"() {
        given:
        (1..12).collect({ service.save(TestHelper.invoice(it)) })
        def updatedInvoice = TestHelper.invoice(1)
        when:
        service.update(4, updatedInvoice)
        then:
        service.getById(4).get() == updatedInvoice
    }

    def "delete() should remove created invoice"() {
        given:
        service.save(TestHelper.invoice(1))
        int size = service.getAll().size()
        when:
        service.delete(1)
        then:
        service.getAll().size() == size - 1
    }


    def "update() should do nothing"() {
        given:
        String textDatabase = service.getAll().toString()
        when:
        service.update(1000, TestHelper.invoice(1))
        then:
        textDatabase == service.getAll().toString()

    }
}
