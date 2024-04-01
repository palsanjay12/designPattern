//package Practice.behavioural.command;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CommandDesignPatternUndoRedu {
//}
//
//interface Cmd{
//    void execute();
//}
//class Info{
//
//    List<String> information;
//    int index;
//
//    public Info(){
//        index=-1;
//        information= new ArrayList<>();
//    }
//    public void add(String info){
//        System.out.println("adding new information");
//        information.add(info);
//        index++;
//    }
//}
//class Undo implements Cmd {
//    Info info;
//    private Undo(Info info){
//        this.info=info;
//    }
//
//    @Override
//    public void execute() {
//        System.out.println("Executing undo command...");
//        if(info.index==0)
//    }
//}
//class Redo implements Cmd {
//    Info info;
//    private Redo(Info info){
//        this.info=info;
//    }
//
//    @Override
//    public void execute() {
//        System.out.println("Executing redo command...");
//    }
//}
