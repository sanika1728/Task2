package com.Records;
import java.util.*;

public class Student 
{
	static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) 
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    
    public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
	
	public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();  

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    public static void viewStudents()
    {
        if (students.isEmpty())
        {
            System.out.println("No student records found.");
            return;
        }
        for (Student s : students)
        {
            System.out.println(s);
        }
    }

    public static void updateStudent()
    {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();

        for (Student s : students)
        {
            if (s.getId() == id)
            {
                sc.nextLine(); 
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                System.out.println("Student deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
	 public static void main(String[] args) {
	        int choice;
	        do {
	            System.out.println("\n=== Student Record Management System ===");
	            System.out.println("1. Add Student");
	            System.out.println("2. View Students");
	            System.out.println("3. Update Student");
	            System.out.println("4. Delete Student");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1: addStudent(); break;
	                case 2: viewStudents(); break;
	                case 3: updateStudent(); break;
	                case 4: deleteStudent(); break;
	                default: System.out.println("Invalid choice!");
	            }
	        } while (choice != 4);
	    }

	    
	}

