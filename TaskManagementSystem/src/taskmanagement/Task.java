package taskmanagement;

import java.util.Date;

public class Task {
	private String name;
	private String description;
	private Date dueDate;
	
	public Task(String name, String description, Date dueDate) {
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
}

