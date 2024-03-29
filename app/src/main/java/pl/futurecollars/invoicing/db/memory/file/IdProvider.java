package pl.futurecollars.invoicing.db.memory.file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import pl.futurecollars.invoicing.utils.FilesService;

public class IdProvider {

  private final Path idFilePath;
  private final FilesService filesService;

  private int nextId = 1;

  public IdProvider(Path idFilePath, FilesService filesService) {
    this.idFilePath = idFilePath;
    this.filesService = filesService;

    try {
      List<String> lines = filesService.readAllLines(idFilePath);
      if (lines.isEmpty()) {
        filesService.writeToFile(idFilePath, "1");
      } else {
        nextId = Integer.parseInt(lines.get(0));
      }
    } catch (IOException ex) {
      throw new RuntimeException("Failed to initialize id database", ex);
    }

  }

  public int getNextIdAndIncrement() {
    try {
      filesService.writeToFile(idFilePath, String.valueOf(nextId + 1));
      return nextId++;
    } catch (IOException ex) {
      throw new RuntimeException("Failed to read id file", ex);
    }
  }

}



