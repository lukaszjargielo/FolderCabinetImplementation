package pl.horus.model.classes;

import pl.horus.model.interfaces.Folder;
import pl.horus.model.interfaces.MultiFolder;

import java.util.ArrayList;
import java.util.List;

public class FolderContainer implements MultiFolder {
    private List<Folder> folders;
    private String name;
    private String size;

    public FolderContainer() {
        this.folders = new ArrayList<>();
        this.name = "unnamed";
        this.size = "undefined";
    }

    public FolderContainer(List<Folder> folders, String name, String size) {
        this.folders = folders;
        this.name = name;
        this.size = size;
    }

    @Override
    public List<Folder> getFolders() {
        return this.folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
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
    }
}
