package edu.uaslp.objetos.taskslist;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskList {

    LinkedList<Task> tasklist;

    TaskList(){
        tasklist=new LinkedList<>();
    }

    public int getSize() {
        return tasklist.size();
    }

    public void add(Task task){
        tasklist.add(task);
    }

    public void remove(Task task){
        tasklist.remove(task);
    }

    public Task find(String title) throws TaskNotFoundException{
        for(Task task: tasklist){
            if(task.getTitle().equals(title)){
                return task;
            }
        }

        throw new TaskNotFoundException("Task with title '"+title+"' not found");
    }

    public void markAsDone(String title){
        Task task = find(title);

        task.setDone(true);
    }

    public void markAsNotDone(String title){
        Task task = find(title);

        task.setDone(false);
    }

    public Task getNextTask(){
        Task nextTask;

        Iterator <Task> it = tasklist.iterator();
        nextTask = it.next();

        while(it.hasNext()){
            Task actualTask = it.next();
            if(actualTask.getDueDate().isBefore(nextTask.getDueDate()) && !actualTask.isDone()){
                nextTask = actualTask;
            }
        }
        return nextTask;
    }

    public List getNextTasks(){
        LinkedList <Task> taskFound = new LinkedList<>();

        Iterator <Task> it = tasklist.iterator();

        while(it.hasNext()){
            Task actualTask = it.next();
            if(actualTask.getDueDate().isAfter(LocalDateTime.now()) && !actualTask.isDone()){
                Task task = new Task(actualTask.getTitle(),actualTask.getDescription(),actualTask.getDueDate(),actualTask.isDone());
                taskFound.add((actualTask));
            }
        }
        taskFound.sort((Task a, Task b) -> a.getDueDate().compareTo(b.getDueDate()));
        return taskFound;
    }


}
