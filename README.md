# FolderCabinetImplementation

Poni¿ej przekazujemy zadanie z proœb¹ o analizê poni¿szego kodu
i samodzielne zaimplementowanie metod **findFolderByName**, **findFolderBySize**, **count** w klasie **FolderCabinet** - najchêtniej unikaj¹c powielania kodu i umieszczaj¹c ca³¹ logikê w klasie **FolderCabinet**. Z uwzglêdnieniem w analizie i implementacji interfejsu **MultiFolder**!

```
interface Cabinet {
// zwraca dowolny element o podanej nazwie
Optional<Folder> findFolderByName(String name);

// zwraca wszystkie foldery podanego rozmiaru SMALL/MEDIUM/LARGE
List<Folder> findFoldersBySize(String size);

//zwraca liczbê wszystkich obiektów tworz¹cych strukturê
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
**Attention!!! findFolderBySize(String size) and findFolderByName(String name) methods are CASE SENSITIVE!!!**

In the resources directory, there is schema of test object content.