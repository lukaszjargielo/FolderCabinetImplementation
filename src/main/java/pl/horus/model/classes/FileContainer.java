package pl.horus.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.horus.model.interfaces.Folder;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class FileContainer implements Folder {
    private String name;
    private String size;

    public FileContainer() {
        this.name = "unnamed";
        this.size = "undefined";
    }

 /*   public FileContainer(String name, String size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }*/
}
