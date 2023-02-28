package pl.futurecollars.innvoicing.db


import pl.futurecollars.innvoicing.helpers.TestHelper

import pl.futurecollars.innvoicing.model.Invoice

import spock.lang.Specification


abstract class AbstractDatabaseTest extends Specification {

    List<Invoice> invoices = (1..12).collect({ TestHelper.invoice(it) })
    Database database

    abstract protected Database initDatabase()

    void setup() {
        database = initDatabase()
    }


    def "getAll should return proper amount of invoices"() {
        given:
        (1..12).collect({ database.save(TestHelper.invoice(it)) })
        when:
        def invoices = database.getAll()
        then:
        invoices.size() == 12

    }

    def "getById() should return Optional.empty when invoice with given id not found"() {
        expect:
        database.getById(1000).isEmpty()
    }

    def "update() should update chosen element"() {
        given:
        (1..12).collect({ database.save(TestHelper.invoice(it)) })
        def updatedInvoice = TestHelper.invoice(1)
        when:
        database.update(4, updatedInvoice)
        then:
        database.getById(4).get() == updatedInvoice
    }

    def "update() should do nothing"() {
        given:
        String textDatabase = database.getAll().toString()
        when:
        database.update(1000,TestHelper.invoice(1))
        then:
        textDatabase == database.getAll().toString()

    }

    def "delete() should remove created invoice"() {
        given:
        database.save(TestHelper.invoice(1))
        int size = database.getAll().size()
        when:
        database.delete(1)
        then:
        database.getAll().size() == size - 1
    }

    //def "delete() should return -1 when id non existing"() {
    //    expect:
    //    database.delete(10000) == -1
   // }


}