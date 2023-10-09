package taskmanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TaskManager {
	private ArrayList<Task> taskList = new ArrayList<>();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public void addTask(String name, String description, Date dueDate) {
		Task task = new Task(name, description, dueDate);
		taskList.add(task);
	}
	
	public void removeTask(int index) {
		if (index >= 0 && index < taskList.size()) {
			taskList.remove(index);
		}else {
			System.out.println("Invalid task index");
		}
	}
	
	public void showTaskList() {
		System.out.println("Task List:");
		System.out.println("========="); 
		for (int i=0; i<taskList.size(); i++) {
			Task task = taskList.get(i);
			System.out.println((i + 1)+"."+ task.getName()+"."+task.getDescription()+"(Due Date:"+dateFormat.format(task.getDueDate())+")");
		}
	}
	
	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nTask Management System");
			System.out.println("======================");
			System.out.println("1.Add Task");
			System.out.println("2.Remove Task");
			System.out.println("3.Show Task List");
			System.out.println("4.Exit");
			System.out.println("======================"); 
			System.out.println("Select an option: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine(); 
			System.out.println("======================"); 
			
			switch (choice) {
			
				case 1:
					System.out.println("Enter task name: ");
					String name = scanner.nextLine();
					System.out.println("Enter task description: ");
					String description = scanner.nextLine();
					System.out.println("Enter due date (yyyy-MM-dd)");
					String dueDateString = scanner.nextLine();
					System.out.println("==========================");
					try {
						Date dueDate = taskManager.dateFormat.parse(dueDateString);
						taskManager.addTask(name, description, dueDate);
					} catch (Exception e) {
						System.out.println("Invalid date format. Task not added."); 
					}
					break;
					
				case 2:
					System.out.println("Enter the index of the task to remove: ");
					int index = scanner.nextInt();
					taskManager.removeTask(index - 1);
					System.out.println("Task removed successfully.");
					break;
					
				case 3:
					taskManager.showTaskList();
					break;
					
				case 4:
					System.out.println("*********************************");
					System.out.println("Exiting the system. Thank you...!");
					System.out.println("*********************************");
					scanner.close();
					System.exit(0);
					
					default:
						System.out.println("Invalid option. Please type the correct option.");
						break;
			}
		}
	}
}
