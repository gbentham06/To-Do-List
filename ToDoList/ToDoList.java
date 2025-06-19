
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
        private ArrayList<Task> tasks;
        private Scanner sc;
        
        public ToDoList(){
                tasks = new ArrayList<>();
                sc = new Scanner(System.in);
        }

        public void run(){
                int choice = 0;

                while (choice != 5) { 
                        displayMenu();
                        System.out.print("Enter your choice (1,2,3,4): ");
                        choice = sc.nextInt();
                        sc.nextLine();

                        switch (choice){
                                case 1:
                                        addTask();
                                        break;
                                case 2:
                                        viewTasks();
                                        break;
                                case 3:
                                        completeTask();
                                        break;
                                case 4:
                                        deleteTask();
                                        break;
                                case 5:
                                        System.out.println("Quitting...");
                                default:
                                        System.out.println("Invalid choice");
                        }
                }

                sc.close();
        }
        
        private void displayMenu() {
                System.out.println("--- To-Do List Menu ---");
                System.out.println("1. Add Task");
                System.out.println("2. View Tasks");
                System.out.println("3. Mark Task as Completed");
                System.out.println("4. Delete Task");
                System.out.println("5. Exit");
                System.out.println("-----------------------");

        }

        private void addTask(){

                // Description
                System.out.println("Please Enter Task:");
                String description = sc.nextLine();

                // Deadline
                LocalDate newDeadline = null;
                System.out.print("Enter deadline (YYYY-MM-DD, leave blank for no due date): ");
                String dueDateString = sc.nextLine();

                if (!dueDateString.trim().isEmpty()) {
                        try {
                                newDeadline = LocalDate.parse(dueDateString.trim());
                        } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Due date will not be set for this task.");
                        }
                }

                // Priority
                Task.Priority newPriority = Task.Priority.VERY_LOW;
                System.out.print("Enter priority (LOW, MEDIUM, HIGH, leave blank for default LOW): ");

                String priorityString = sc.nextLine();
                if (!priorityString.trim().isEmpty()) { 
                        try {
                                
                                newPriority = Task.Priority.valueOf(priorityString.trim().toUpperCase());
                        } catch (IllegalArgumentException e) {
                                System.out.println("Invalid priority. Defaulting to LOW.");
                        }           
                }

                // Done :)
                tasks.add(new Task(description, newDeadline, newPriority));
                System.out.println("Task added successfully!");
        }

        private void viewTasks(){
                if (!tasks.isEmpty()){
                        for (int i = 0; i < tasks.size(); i++) {
                                System.out.print(i+1);
                                System.out.println(". " + tasks.get(i));
                        }
                } else {
                        System.out.println("There are no tasks to view");
                }
        }

        private void completeTask(){
                viewTasks();
                System.out.println("Enter number of task to mark complete");
                int tasknum = sc.nextInt();
                sc.nextLine();
                if (tasknum <= tasks.size() && tasknum > 0){
                        tasks.get(tasknum-1).markComplete();
                        System.out.println("Task marked as complete");
                } else {
                        System.out.println("This task does not exist");
                }
        }

        private void deleteTask(){
                viewTasks();
                System.out.println("Enter number of task to delete");
                int tasknum = sc.nextInt();
                sc.nextLine();
                if (tasknum <= tasks.size() && tasknum > 0){
                        tasks.remove(tasknum-1);
                        System.out.println("Task deleted");
                } else {
                        System.out.println("This task does not exist");
                }
        }

        public static void main(String[] args) {
            ToDoList project = new ToDoList();
            project.run();
        }
}

