package Practice.behavioural.command;

public class CommandDesignPattern {
    public static void main(String[] args) {
        FileSystemReceiver fileSystemReceiver= new FileSystemReceiverImpl();
        Command command= new OpenFileCommand(fileSystemReceiver);
        FileInvoker fileInvoker=new FileInvoker(command);
        fileInvoker.execute();
        command= new WriteFileCommand(fileSystemReceiver);
        fileInvoker= new FileInvoker(command);
        fileInvoker.execute();
        command= new CloseFileCommand(fileSystemReceiver);
        fileInvoker= new FileInvoker(command);
        fileInvoker.execute();
    }
}
interface Command {

    void execute();
}
class OpenFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public OpenFileCommand(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
    @Override
    public void execute() {
        //open command is forwarding request to openFile method
        this.fileSystem.openFile();
    }

}
class WriteFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public WriteFileCommand(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
    @Override
    public void execute() {
        this.fileSystem.writeFile();
    }

}
class FileInvoker {

    public Command command;

    public FileInvoker(Command c){
        this.command=c;
    }

    public void execute(){
        this.command.execute();
    }
}
class CloseFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public CloseFileCommand(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
    @Override
    public void execute() {
        this.fileSystem.closeFile();
    }

}
interface FileSystemReceiver {

    void openFile();
    void writeFile();
    void closeFile();
}
class FileSystemReceiverImpl implements FileSystemReceiver {

    @Override
    public void openFile() {
        System.out.println("Opening file in Windows OS");

    }

    @Override
    public void writeFile() {
        System.out.println("Writing file in Windows OS");
    }

    @Override
    public void closeFile() {
        System.out.println("Closing file in Windows OS");
    }

}