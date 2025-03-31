package pl.horus.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.horus.model.interfaces.Folder;
import pl.horus.model.interfaces.MultiFolder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class FolderContainer implements MultiFolder {
    private List<Folder> folders;
    private String name;
    private String size;

    public FolderContainer() {
        this.folders = new ArrayList<>();
        this.name = "unnamed";
        this.size = "undefined";
    }
}
