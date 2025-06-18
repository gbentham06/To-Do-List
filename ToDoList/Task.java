
import java.time.LocalDate;

public class Task {

    private String desc;
    private Boolean complete;
    private LocalDate deadline;
    public enum Priority {
        VERY_LOW,
        LOW,
        MEDIUM,
        HIGH,
        VERY_HIGH
    }

    private Priority priority;

    public Task(String desc, LocalDate deadline, Priority priority){
        this.desc = desc;
        this.complete = false;
        this.deadline = deadline;
        this.priority = priority;
    }

    public Boolean getStatus(){
        return complete;
    }

    public String getDesc(){
        return desc;
    }
    
    public void markComplete(){
        this.complete = true;
    }

    public void setDesc(String newsdesc){
        this.desc = newsdesc;
    }

    @Override
    public String toString() {
        return (complete ? "[X] " : "[ ] ") + desc;
    }

    
    

}
