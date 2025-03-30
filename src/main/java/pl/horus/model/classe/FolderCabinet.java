package pl.horus.model.classe;

import pl.horus.model.interfaces.Cabinet;
import pl.horus.model.interfaces.Folder;

import java.util.List;
import java.util.Optional;

public class FolderCabinet implements Cabinet {
    private List<Folder> folders;

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return folders.stream()
                .filter(folder -> folder.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return folders.stream()
                .filter(folder -> folder.getSize().equalsIgnoreCase(size))
                .toList();
    }

    @Override
    public int count() {
        return folders.size();
    }
}
