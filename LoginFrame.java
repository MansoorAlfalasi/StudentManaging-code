import javax.swing.*;
//imports the swing GUI allowing us to the methods in the swing class.

public class LoginFrame extends JFrame {
    // Extends JFrame meaning that it get everything that a normal windown includes such as the exit button, slide show button. and more.

    //Constructor used to be a refrence for when its called in the main class

    public LoginFrame() {

        //sets a window title called Login and the size of the window and the Closeoperation code.

        setTitle("Login");
        setSize(250, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 2 text feilds for the username and for the password set. and an action button that allows the user to log in.

        JTextField user = new JTextField(10);
        JPasswordField pass = new JPasswordField(10);
        JButton login = new JButton("Login");

        // Jpanel is called to create a panel where the labels are stored/orginized.

        JPanel panel = new JPanel();

        //Adds labels to the Jpanel and orginizes the panel in the matter they were added, where username is on top and password is below, and log in below that.

        panel.add(new JLabel("Username:"));
        panel.add(user);
        panel.add(new JLabel("Password:"));
        panel.add(pass);
        panel.add(login);

        //ActionListener method runs the code below

        login.addActionListener(e ->{

            // Simple If statement used to "login" using proper username and password set, while closing the tab when the dispose method is used
            //  and opening the StudentManagerFrame class

            if (user.getText().equals("Hamida") && String.valueOf(pass.getPassword()).equals("0001")) {
                new StudentManagerFrame();
                dispose();
            } 
            else {

                //If the "If" statement doesnt run the JOptionPane method is used to display the message "wrong login". 

                JOptionPane.showMessageDialog(this, "Wrong login");
            }
        }
    );

    //Places the panels in the window and makes the login window appear on screen using the add() method and the setVisible() method from the swing class

        add(panel);
        setVisible(true);
    }
}

    



