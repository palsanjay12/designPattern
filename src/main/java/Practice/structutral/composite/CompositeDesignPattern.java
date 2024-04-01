package Practice.structutral.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPattern {
    public static void main(String[] args) {
        FileSystem file1= new File("file1.txt");
        FileSystem file2= new File("file2.txt");
        Dir dir1= new Dir("Dir1");
        dir1.add(file1);
        Dir dir2= new Dir("Dir2");
        dir2.add(file2);
        dir1.add(dir2);
        dir1.ls();
    }
}
interface FileSystem{
    void ls();
}
class File implements FileSystem{
    String name;
    public File(String name){
        this.name=name;
    }
    @Override
    public void ls() {
        System.out.println("FIle:"+ name);
    }
}
class Dir implements FileSystem{
    String name;
    List<FileSystem> list;
    public Dir(String name){
        this.name=name;
        list= new ArrayList<>();
    }
    public void add(FileSystem fileSystem){
        list.add(fileSystem);
    }
    public void remove(FileSystem fileSystem){
        list.remove(fileSystem);
    }
    @Override
    public void ls() {
        System.out.println("Dir:"+ name);
        list.forEach(file->file.ls());
    }
}