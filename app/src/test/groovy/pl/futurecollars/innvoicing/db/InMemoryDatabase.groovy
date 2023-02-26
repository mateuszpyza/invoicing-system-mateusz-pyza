package pl.futurecollars.innvoicing.db

class InMemoryDatabase extends AbstractDatabaseTest{

    @Override
    Database initDatabase() {
        return new InMemoryDatabase()
    }
}
