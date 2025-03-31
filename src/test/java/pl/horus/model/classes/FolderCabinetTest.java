package pl.horus.model.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.horus.model.interfaces.Folder;
import pl.horus.model.interfaces.MultiFolder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class FolderCabinetTest {

private FolderCabinet folderCabinet1;
private FolderCabinet folderCabinet2;
private FolderCabinet folderCabinet3;

private Folder fileContainer1;
private Folder fileContainer2;
private Folder fileContainer3;
private Folder fileContainer4;
private Folder fileContainer5;
private Folder fileContainer6;
private Folder fileContainer7;

private MultiFolder folderContainer1;
private MultiFolder folderContainer2;
private MultiFolder folderContainer3;
private MultiFolder folderContainer4;
private MultiFolder folderContainer5;

    @BeforeEach
    public void setUp() {
        fileContainer1 = new FileContainer("FirstFileContainer", "SMALL");
        fileContainer2 = new FileContainer("SecondFileContainer", "SMALL");
        fileContainer3 = new FileContainer("ThirdFileContainer", "SMALL");
        fileContainer4 = new FileContainer("FourthFileContainer", "SMALL");
        fileContainer5 = new FileContainer("FifthFileContainer", "SMALL");
        fileContainer6 = new FileContainer("SixthFileContainer", "SMALL");
        fileContainer7 = new FileContainer("SeventhFileContainer", "SMALL");

        folderContainer1 = new FolderContainer(List.of(fileContainer2), "FirstFolderContainer", "MEDIUM");
        folderContainer2 = new FolderContainer(List.of(fileContainer4), "SecondFolderContainer", "MEDIUM");
        folderContainer3 = new FolderContainer(List.of(fileContainer5,fileContainer6,fileContainer7), "ThirdFolderContainer", "LARGE");
        folderContainer4 = new FolderContainer(List.of(fileContainer3, folderContainer2, folderContainer3), "FourthFolderContainer", "LARGE");
        folderContainer5 = new FolderContainer(List.of(fileContainer1,folderContainer1, folderContainer4), "FifthFolderContainer", "LARGE");

        folderCabinet1 = new FolderCabinet(Arrays.asList(fileContainer1));

        folderCabinet2 = new FolderCabinet(Arrays.asList(folderContainer2));

        folderCabinet3 = new FolderCabinet(Arrays.asList(fileContainer1, folderContainer1, folderContainer4));

    }


    @Test
    void findFolderByName_non_nested_folder_case_sensitive() {
        Optional<Folder> foundFolder = folderCabinet1.findFolderByName("FirstFileContainer");
        assertTrue(foundFolder.isPresent());
        assertEquals("FirstFileContainer", foundFolder.get().getName());

        Optional<Folder> notFoundFolder = folderCabinet1.findFolderByName("firstFileCONTAINER");
        assertFalse(notFoundFolder.isPresent());
    }

    @Test
    void findFolderByName_single_nested_folder_case_sensitive() {
        Optional<Folder> foundFolder = folderCabinet2.findFolderByName("FourthFileContainer");
        assertTrue(foundFolder.isPresent());
        assertEquals("FourthFileContainer", foundFolder.get().getName());

        Optional<Folder> notFoundFolder = folderCabinet2.findFolderByName("FOURTHFILECONTAINER");
        assertFalse(notFoundFolder.isPresent());
    }

    @Test
    void findFolderByName_double_nested_folder_case_sensitive() {
        Optional<Folder> foundFolder = folderCabinet3.findFolderByName("SeventhFileContainer");
        assertTrue(foundFolder.isPresent());
        assertEquals("SeventhFileContainer", foundFolder.get().getName());

        Optional<Folder> notFoundFolder = folderCabinet1.findFolderByName("seventhfilecontaine");
        assertFalse(notFoundFolder.isPresent());
    }
    @Test
    void findFoldersBySize_non_nested_folder_case_sensitive() {
        List<Folder> foundFolders = folderCabinet1.findFoldersBySize("SMALL");
        assertTrue(foundFolders.stream().allMatch(folder -> folder.getSize().equalsIgnoreCase("SMALL")));
        assertEquals(1, foundFolders.size());

        List<Folder> nonExistentFolders = folderCabinet1.findFoldersBySize("sMaLl");
        assertFalse(nonExistentFolders.size() == 1);
    }

    @Test
    void findFoldersBySize_single_nested_folder_case_sensitive() {
        List<Folder> foundFolders = folderCabinet2.findFoldersBySize("SMALL");
        assertTrue(foundFolders.stream().allMatch(folder -> folder.getSize().equalsIgnoreCase("SMALL")));
        assertEquals(1, foundFolders.size());

        List<Folder> nonExistentFolders = folderCabinet1.findFoldersBySize("small");
        assertFalse(nonExistentFolders.size() == 1);
    }

    @Test
    void findFoldersBySize_double_nested_folder_case_sensitive() {
        List<Folder> foundFolders = folderCabinet3.findFoldersBySize("SMALL");
        assertTrue(foundFolders.stream().allMatch(folder -> folder.getSize().equalsIgnoreCase("SMALL")));
        assertEquals(7, foundFolders.size());

        List<Folder> nonExistentFolders = folderCabinet1.findFoldersBySize("sMaLl");
        assertFalse(nonExistentFolders.size() == 1);
    }

    @Test
    void count_non_nested_folder() {
        int counter = folderCabinet1.count();
        assertEquals(1,counter);

       int folderListSize = folderCabinet1.getFolders().size();
       assertFalse(folderListSize > counter);
    }

    @Test
    void count_single_nested_folder() {
        int counter = folderCabinet2.count();
        assertEquals(2,counter);

        int folderListSize = folderCabinet2.getFolders().size();
        assertFalse(folderListSize > counter);
    }

    @Test
    void count_double_nested_folder() {
        int counter = folderCabinet3.count();
        assertEquals(11,counter);

        int folderListSize = folderCabinet2.getFolders().size();
        assertFalse(folderListSize > counter);
    }
}