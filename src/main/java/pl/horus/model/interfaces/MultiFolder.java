package pl.horus.model.interfaces;

import java.util.List;

public interface MultiFolder extends Folder{
    List<Folder> getFolders();
}