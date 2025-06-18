
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

                while (choice != 4) { 
                        displayMenu();
                        System.out.print("Enter your choice (1,2,3,4): ");
                        choice = sc.nextInt();

                        switch (choice){
                                case 1:
                                        addTask();
                                        break;
                                case 2:
                                        viewTasks();
                                        break;
                                case 3:
                                        break;
                                case 4:
                                        break;
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
                System.out.println("4. Exit");
                System.out.println("-----------------------");

        }

        private void addTask(){

                // Description
                System.out.println("Please Enter Task:");
                String description = sc.nextLine();
                System.out.println("Please Enter Deadline:");

                // Deadline
                LocalDate newDeadline = null;
                System.out.print("Enter due date (YYYY-MM-DD, leave blank for no due date): ");
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
                        
                }
        }
}

