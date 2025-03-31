package pl.horus.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.horus.model.interfaces.Folder;

@Getter
@Setter
@AllArgsConstructor

public class FileContainer implements Folder {
    private String name;
    private String size;

    public FileContainer() {
        this.name = "unnamed";
        this.size = "undefined";
    }
}
