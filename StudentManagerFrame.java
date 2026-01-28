import java.util.ArrayList;
import javax.swing.*;
// these two imports are used to us the arraylist class, while the .swing method is used to create the GUI which lets us use panels, windows, buttons, etc.

// Extends JFrame meaning that it get everything that a normal windown includes such as the exit button, slide show button. and more.
public class StudentManagerFrame extends JFrame {


    // ArrayList to store information added from frame, taking reference from Student class
    private ArrayList<Student> students; 

    public StudentManagerFrame() {
        //Creates the student list and where we going to storethe students information
        students = new ArrayList<>();

        // Created a Title on top of the screen with a set size and a default closeOperation.

        setTitle("Student Manager");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //JButton creates a new button named as theyre respective uses require.

    
        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Students");
        JButton deleteBtn = new JButton("Delete Student");


        // These lines create use to the buttons and refers these methods from the class.

        addBtn.addActionListener(e -> addStudent());
        viewBtn.addActionListener(e -> viewStudents());
        deleteBtn.addActionListener(e -> deleteStudent());

        // Jpanel creates a panel to hold in these buttons in.
        JPanel panel = new JPanel();

        //These add the Jbutton/Actions we have created before into the panels
        
        panel.add(addBtn);
        panel.add(viewBtn);
        panel.add(deleteBtn);
        
        //without these next 2 lines of code nothing would show if we run the code.

        add(panel);
        setVisible(true);
    }

    //This method is called when we click the add student button we have created which allows us to input an ID, Name, and Age, Using the JOptionPane... opens a window
    //Where the user can write/store the persons respective information, and the creates a new student object which gets added to the students array list.
    

    public void addStudent() {
        String id = JOptionPane.showInputDialog("Enter ID:");
        String name = JOptionPane.showInputDialog("Enter Name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));

        students.add(new Student(id, name, age));
    }

    //This method is simple, it shows all students info stored in the array list "student"

    public void viewStudents() {
        if (students.size() == 0) {
            JOptionPane.showMessageDialog(this, "No students found.");
            return;
        }

        //This for loop is needed to create spacing between each person and their info.

        String output = "";
        for (Student s : students) {
            output += s.toString() + "\n";
        } 

        // Displays what the the for loop has created.

        JOptionPane.showMessageDialog(this, output);
    }

    //This method i have created delets a certain student by their ID.

    public void deleteStudent() {

        // This line creats a window where a message pops up where the user enters a certain ID which is stored in the variable "id".

        String id = JOptionPane.showInputDialog("Enter ID to delete:");

        //This loops through the list comparing each number until it gets into the ID needed to be removed and activates the if statement to remove ".remove() java method"
        //the object from the arraylist

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                JOptionPane.showMessageDialog(this, "Student removed.");
           return;
            }
        }
        
        // If the certain id is not found the message "Student not found." Displays.

        JOptionPane.showMessageDialog(this, "Student not found.");
    }
}
