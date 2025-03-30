# FolderCabinetImplementation

Poni�ej przekazujemy zadanie z pro�b� o analiz� poni�szego kodu
i samodzielne zaimplementowanie metod **findFolderByName**, **findFolderBySize**, **count** w klasie **FolderCabinet** - najch�tniej unikaj�c powielania kodu i umieszczaj�c ca�� logik� w klasie **FolderCabinet**. Z uwzgl�dnieniem w analizie i implementacji interfejsu **MultiFolder**!

```
interface Cabinet {
// zwraca dowolny element o podanej nazwie
Optional<Folder> findFolderByName(String name);

// zwraca wszystkie foldery podanego rozmiaru SMALL/MEDIUM/LARGE
List<Folder> findFoldersBySize(String size);

//zwraca liczb� wszystkich obiekt�w tworz�cych struktur�
int count();
}
```

```
public class FileCabinet implements Cabinet {
private List<Folder> folders;
}
```
```
interface Folder {
String getName();
String getSize();
}
```
```
interface MultiFolder extends Folder {
List<Folder> getFolders();
}
```
