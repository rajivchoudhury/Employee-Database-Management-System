package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewEmployee implements ActionListener{
    JFrame frame;
    JLabel imageLabel;
    JTextField inputField;
    JButton submitButton, cancelButton;

    public ViewEmployee(){
        frame = new JFrame("View Employee");
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
                    new PrintEmployee(rSet);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Employee ID");
                    new ViewEmployee();
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
        new ViewEmployee();
    }
}
