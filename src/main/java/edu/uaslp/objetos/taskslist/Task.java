package edu.uaslp.objetos.taskslist;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Task {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean done;

    public Task(){

    }
    public Task(String title, String description, LocalDateTime dueDate, boolean done) {
      this.description = description;
      this.title = title;
      this.dueDate = dueDate;
      this.done = done;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) throws TaskListException{
        LocalDateTime now = LocalDateTime.now();
        if(dueDate.isBefore(now)){
            throw new TaskListException("Due date is set in the past");
        }

        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
