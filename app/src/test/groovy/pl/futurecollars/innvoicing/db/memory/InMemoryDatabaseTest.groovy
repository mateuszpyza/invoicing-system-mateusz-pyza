package pl.futurecollars.innvoicing.db.memory

import pl.futurecollars.innvoicing.db.AbstractDatabaseTest
import pl.futurecollars.innvoicing.db.Database


class InMemoryDatabaseTest extends AbstractDatabaseTest {
    @Override
    protected Database initDatabase() {
        return new InMemoryDatabase()
    }
}
