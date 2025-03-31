package pl.horus.model.classes;

import pl.horus.model.interfaces.Cabinet;
import pl.horus.model.interfaces.Folder;
import pl.horus.model.interfaces.MultiFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FolderCabinet implements Cabinet {
    private List<Folder> folders;

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return findFolderByNameInSubdirectories(folders, name);
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        ArrayList<Folder> foundFolders = new ArrayList<>();
        return findFolderBySizeInSubdirectories(folders, size, foundFolders);
    }

    @Override
    public int count() {

        return countInSubdirectories(folders);
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    private Optional<Folder> findFolderByNameInSubdirectories(List<Folder> folders, String name) {
        for (Folder folder : folders) {
            if (folder.getName().equalsIgnoreCase(name)) {
                return Optional.of(folder);
            }
            if (folder instanceof MultiFolder) {
                Optional<Folder> foundFolder = findFolderByNameInSubdirectories(((MultiFolder) folder).getFolders(), name);
                if (foundFolder.isPresent()) {
                    return foundFolder;
                }
            }
        }
        return Optional.empty();
    }

    private List<Folder> findFolderBySizeInSubdirectories(List<Folder> folders, String size, List<Folder> foundFolders) {
        for(Folder folder : folders) {
            if(folder.getSize().equalsIgnoreCase(size)) {
                foundFolders.add(folder);
            }
            if (folder instanceof MultiFolder) {
                findFolderBySizeInSubdirectories(((MultiFolder) folder).getFolders(), size, foundFolders);
            }
        }
        return foundFolders;
    }

    private int countInSubdirectories(List<Folder> folders) {
        int counter = folders.size();
        for (Folder folder : folders) {
            if (folder instanceof MultiFolder) {
                MultiFolder multifolder = (MultiFolder) folder;
                counter += countInSubdirectories(multifolder.getFolders());
            }
        }
        return counter;
    }
}
