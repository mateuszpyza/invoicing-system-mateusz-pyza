package pl.futurecollars.invoicing.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.memory.InMemoryDatabase;
import pl.futurecollars.invoicing.db.memory.file.FileBasedDatabase;
import pl.futurecollars.invoicing.db.memory.file.IdProvider;
import pl.futurecollars.invoicing.service.InvoiceService;
import pl.futurecollars.invoicing.utils.FilesService;
import pl.futurecollars.invoicing.utils.JsonService;

public class Config {

  public static final String DATABASE_LOCATION = "db/invoices.txt";
  public static final String ID_FILE_LOCATION = "db/id.txt";
  private static final String INVOICES_FILE_NAME = "invoices.json";

  @Bean
  public JsonService jsonService() {
    return new JsonService();
  }

  @Bean
  public FilesService fileService() {
    return new FilesService();
  }

  @Bean
  public InMemoryDatabase inMemoryDatabase() {
    return new InMemoryDatabase();
  }

  @Bean
  public InvoiceService invoiceService(@Qualifier("fileBasedDatabase") Database database) {
    return new InvoiceService(database);
  }

  @Bean
  public IdProvider idProvider(FilesService filesService) throws IOException {
    Path idFilePath = Files.createTempFile(DATABASE_LOCATION, ID_FILE_LOCATION);
    return new IdProvider(idFilePath, filesService);
  }

  @Bean
  public Database fileBasedDatabase(IdProvider idService, FilesService filesService, JsonService jsonService) throws IOException {
    Path databaseFilePath = Files.createTempFile(DATABASE_LOCATION, INVOICES_FILE_NAME);
    return new FileBasedDatabase(databaseFilePath, idService, filesService, jsonService);
  }
}

