package edu.uaslp.objetos.taskslist;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(){

    }

    public TaskNotFoundException(String message){
        super(message);
    }
}
