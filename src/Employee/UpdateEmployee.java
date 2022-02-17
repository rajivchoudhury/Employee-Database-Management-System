package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
// import javax.swing.text.AttributeSet;
// import javax.swing.text.BadLocationException;
// import javax.swing.text.PlainDocument;

// class JTextFieldLimit extends PlainDocument {
//     private int limit;
//     JTextFieldLimit(int limit) {
//       super();
//       this.limit = limit;
//     }
  
//     JTextFieldLimit(int limit, boolean upper) {
//       super();
//       this.limit = limit;
//     }
  
//     public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
//       if (str == null)
//         return;
  
//       if ((getLength() + str.length()) <= limit) {
//         super.insertString(offset, str, attr);
//       }
//     }
//   }  

class SearchEmployee implements ActionListener{
    JFrame frame;
    JLabel imageLabel;
    JTextField nameField, ageField, addressField, fnameField, dobField, phoneField, emailField, eduField, jpField, aadhaarField, empIdField;
    JButton submitButton, cancelButton;

    public SearchEmployee(ResultSet rSet){
        frame = new JFrame("Update Employee");

        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("src/Employee/Icons/add_employee.jpg");
        Image image = imageIcon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon finalImageIcon = new ImageIcon(image);
        imageLabel = new JLabel(finalImageIcon);
        imageLabel.setBounds(0, 0, 900, 700);
        frame.add(imageLabel);

        JLabel heading = new JLabel("New Employee Details");
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("serif", Font.ITALIC, 25));
        heading.setBounds(340, 30, 300, 30);
        imageLabel.add(heading);

        JLabel label = new JLabel("Name: ");
        label.setFont(new Font("serif", Font.PLAIN, 20));
        label.setBounds(50, 100, 120, 30);
        imageLabel.add(label);

        label = new JLabel("Age: ");
        label.setFont(new Font("serif", Font.PLAIN, 20));
        label.setBounds(50, 150, 120, 30);
        imageLabel.add(label);

        label = new JLabel("Address: ");
        label.setFont(new Font("serif", Font.PLAIN, 20));
        label.setBounds(50, 200, 120, 30);
        imageLabel.add(label);

        label = new JLabel("Email Id: ");
        label.setFont(new Font("serif", Font.PLAIN, 20));
        label.setBounds(50, 250, 120, 30);
        imageLabel.add(label);

        label = new JLabel("Job Position: ");
        label.setFont(new Font("serif", Font.PLAIN, 20));
        label.setBounds(50, 300, 120, 30);
        imageLabel.add(label);

        label = new JLabel("Employee ID: ");
        label.setFont(new Font("serif", Font.PLAIN, 20));
        label.setBounds(50, 350, 120, 30);
        imageLabel.add(label);

        try{
            nameField = new JTextField(rSet.getString("name"));
            nameField.setBounds(180, 100, 200, 30);
            nameField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            imageLabel.add(nameField);

            ageField = new JTextField(rSet.getInt("age"));
            ageField.setBounds(180, 150, 200, 30);
            ageField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            imageLabel.add(ageField);
            
            ageField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                        ageField.setEditable(true);
                    }
                    else if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                        ageField.setEditable(true);
                    }
                    else {
                        ageField.setEditable(false);
                    }
                }
            });
            ageField.setDocument(new JTextFieldLimit(3));

            addressField = new JTextField(rSet.getString("address"));
            addressField.setBounds(180, 200, 200, 30);
            addressField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            imageLabel.add(addressField);

            emailField = new JTextField(rSet.getString("email"));
            emailField.setBounds(180, 250, 200, 30);
            emailField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            imageLabel.add(emailField);

            jpField = new JTextField(rSet.getString("job_post"));
            jpField.setBounds(180, 300, 200, 30);
            jpField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            imageLabel.add(jpField);

            empIdField = new JTextField(rSet.getInt("emp_id"));
            empIdField.setBounds(180, 350, 200, 30);
            empIdField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            empIdField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                        empIdField.setEditable(true);
                    }
                    else if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                        empIdField.setEditable(true);
                    }
                    else {
                        empIdField.setEditable(false);
                    }
                }
            });
            empIdField.setDocument(new JTextFieldLimit(5));
            imageLabel.add(empIdField);

            label = new JLabel("Father's Name: ");
            label.setFont(new Font("serif", Font.PLAIN, 20));
            label.setBounds(500, 100, 140, 30);
            imageLabel.add(label);

            label = new JLabel("Date Of Birth: ");
            label.setFont(new Font("serif", Font.PLAIN, 20));
            label.setBounds(500, 150, 140, 30);
            imageLabel.add(label);

            label = new JLabel("Phone: ");
            label.setFont(new Font("serif", Font.PLAIN, 20));
            label.setBounds(500, 200, 140, 30);
            imageLabel.add(label);

            label = new JLabel("Education: ");
            label.setFont(new Font("serif", Font.PLAIN, 20));
            label.setBounds(500, 250, 140, 30);
            imageLabel.add(label);

            label = new JLabel("Aadhaar No.: ");
            label.setFont(new Font("serif", Font.PLAIN, 20));
            label.setBounds(500, 300, 140, 30);
            imageLabel.add(label);

            fnameField = new JTextField(rSet.getString("fathers_name"));
            fnameField.setBounds(650, 100, 200, 30);
            fnameField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            imageLabel.add(fnameField);

            dobField = new JTextField(rSet.getString("dob"));
            dobField.setBounds(650, 150, 200, 30);
            dobField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            imageLabel.add(dobField);

            phoneField = new JTextField(rSet.getString("phone"));
            phoneField.setBounds(650, 200, 200, 30);
            phoneField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            phoneField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                        phoneField.setEditable(true);
                    }
                    else if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                        phoneField.setEditable(true);
                    }
                    else {
                        phoneField.setEditable(false);
                    }
                }
            });
            phoneField.setDocument(new JTextFieldLimit(10));
            imageLabel.add(phoneField);

            eduField = new JTextField(rSet.getString("education"));
            eduField.setBounds(650, 250, 200, 30);
            eduField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            imageLabel.add(eduField);

            aadhaarField = new JTextField(rSet.getString("aadhaar_no"));
            aadhaarField.setBounds(650, 300, 200, 30);
            aadhaarField.setFont(new Font("sans-serif", Font.PLAIN, 18));
            aadhaarField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                        aadhaarField.setEditable(true);
                    }
                    else if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                        aadhaarField.setEditable(true);
                    }
                    else {
                        aadhaarField.setEditable(false);
                    }
                }
            });
            aadhaarField.setDocument(new JTextFieldLimit(12));
            imageLabel.add(aadhaarField);
        }
        catch(Exception ev){
            ev.printStackTrace();
        }
        
        submitButton = new JButton("Update");
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.BLACK);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.setBounds(300, 500, 100, 50);
        submitButton.addActionListener(this);
        imageLabel.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setOpaque(true);
        cancelButton.setBorderPainted(false);
        cancelButton.setBounds(430, 500, 100, 50);
        cancelButton.addActionListener(this);
        imageLabel.add(cancelButton);

        frame.setVisible(true);
        frame.setSize(900, 700);
        frame.setLocation(50, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton){
            frame.setVisible(false);
            new Details();
        }
        if(e.getSource() == submitButton){
            try{
                ConnectionToDB connect = new ConnectionToDB();
                String query = "insert into EmployeeDetails values ('"+nameField.getText()+"','"+fnameField.getText()+"','"+ageField.getText()+"','"+dobField.getText()+"','"+addressField.getText()+"','"+phoneField.getText()+"','"+emailField.getText()+"','"+eduField.getText()+"','"+jpField.getText()+"','"+aadhaarField.getText()+"','"+empIdField.getText()+"')";
                try{
                    connect.statement.executeUpdate("create table EmployeeDetails (name varchar(100), fathers_name varchar(100), age integer, dob varchar(100), address varchar(100), phone bigint, email varchar(100), education varchar(100), job_post varchar(100), aadhaar_no bigint, emp_id integer)");
                    connect.statement.executeUpdate(query);
                }
                catch(SQLSyntaxErrorException ev){
                    if(ev.getLocalizedMessage().equals("Table 'employeedetails' already exists")){
                        connect.statement.executeUpdate(query);
                    }
                }
                JOptionPane.showMessageDialog(null, "Succesfully Added");
                frame.setVisible(false);
                new Details();
            }
            catch(Exception ev){
                ev.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error Adding Employee");
                frame.setVisible(false);
                new AddEmployee();
            }
        }
    }
}

public class UpdateEmployee implements ActionListener{
    JFrame frame;
    JLabel imageLabel;
    JTextField inputField;
    JButton submitButton, cancelButton;

    public UpdateEmployee(){
        frame = new JFrame("Search Employee");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("src/Employee/Icons/view.jpg");
        Image image = imageIcon.getImage().getScaledInstance(500, 270, Image.SCALE_DEFAULT);
        ImageIcon finalImageIcon = new ImageIcon(image);
        imageLabel = new JLabel(finalImageIcon);
        imageLabel.setBounds(0, 0, 500, 270);
        frame.add(imageLabel);

        JLabel label = new JLabel("Employee ID");
        label.setFont(new Font("sans-serif", Font.BOLD, 30));
        label.setBounds(10, 20, 250, 30);
        label.setForeground(Color.WHITE);
        imageLabel.add(label);

        inputField = new JTextField();
        inputField.setBounds(270, 20, 200, 30);
        imageLabel.add(inputField);

        submitButton = new JButton("Search");
        submitButton.addActionListener(this);
        submitButton.setBounds(270, 170, 80, 30);
        imageLabel.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        cancelButton.setBounds(390, 170, 80, 30);
        imageLabel.add(cancelButton);

        frame.setVisible(true);
        frame.setSize(500, 270);
        frame.setLocation(250, 260);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton){
            String empId = inputField.getText();
            ResultSet rSet;
            try{
                ConnectionToDB connect = new ConnectionToDB();
                rSet = connect.statement.executeQuery("select * from EmployeeDetails where emp_id="+empId);
                if(rSet.next()){
                    frame.setVisible(false);
                    new SearchEmployee(rSet);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Employee ID");
                    new UpdateEmployee();
                }
            }
            catch(Exception ev){
                ev.printStackTrace();
            }
        }
        if(e.getSource() == cancelButton){
            frame.setVisible(false);
            new Details();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee();
    }
}
