package structuralDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPattern {
    public static void main(String[] args) {
        // Creating simple tasks
        Task simpleTask1 = new SimpleTask("Complete Coding");
        Task simpleTask2 = new SimpleTask("Write Documentation");

        // Creating a task list
        TaskList projectTasks = new TaskList("Project Tasks");
        projectTasks.addTask(simpleTask1);
        projectTasks.addTask(simpleTask2);

        // Nested task list
        TaskList phase1Tasks = new TaskList("Phase 1 Tasks");
        phase1Tasks.addTask(new SimpleTask("Design"));
        phase1Tasks.addTask(new SimpleTask("Implementation"));

        projectTasks.addTask(phase1Tasks);

        // Displaying tasks
        projectTasks.display();
    }
}
interface Task {
    String getTitle();
    void setTitle(String title);
    void display();
}
class SimpleTask implements Task { // leaf
    private String title;

    public SimpleTask(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Simple Task: " + title);
    }
}
class TaskList implements Task { //composite class
    private String title;
    private List<Task> tasks;

    public TaskList(String title) {
        this.title = title;
        this.tasks = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public void display() {
        System.out.println("Task List: " + title);
        System.out.println("----------------------");
        for (Task task : tasks) {
            task.display();
        }
    }
}
