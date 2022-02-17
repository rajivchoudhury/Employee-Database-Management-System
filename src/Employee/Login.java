package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login implements ActionListener{
    
    JFrame f;
    JLabel userLabel, passwordLabel;
    JTextField username;
    JPasswordField passwordField;
    JButton loginButton, cancelButton;

    Login(){
        f = new JFrame("Login");

        f.setBackground(Color.WHITE);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userLabel = new JLabel("UserName:");
        userLabel.setBounds(20, 20, 120, 30);
        userLabel.setFont(new Font("serif", Font.PLAIN, 25));
        f.add(userLabel);

        username = new JTextField();
        username.setBounds(150, 20, 200, 30);
        f.add(username);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 70, 120, 30);
        passwordLabel.setFont(new Font("serif", Font.PLAIN, 25));
        f.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 200, 30);
        f.add(passwordField);

        ImageIcon imageIcon = new ImageIcon("src/Employee/Icons/login.jpg");
        Image im = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon finalImageIcon = new ImageIcon(im);
        JLabel imageLabel = new JLabel(finalImageIcon);
        imageLabel.setBounds(370, 20, 150, 150);
        f.add(imageLabel);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLACK);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setBounds(20, 120, 100, 30);
        f.add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        cancelButton.setBounds(150, 120, 100, 30);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setOpaque(true);
        cancelButton.setBorderPainted(false);
        f.add(cancelButton);

        f.setVisible(true);
        f.setSize(600, 300);
        f.setLocation(100, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton){
            System.exit(0);
        }

        else if(e.getSource() == loginButton){
            try{
                ConnectionToDB connect = new ConnectionToDB();
                String uname = username.getText();
                String pw = new String(passwordField.getPassword());

                String query = "select * from loginUser where username='"+ uname + "' and password='" + pw + "'";
                ResultSet resultSet = connect.statement.executeQuery(query);
                if(resultSet.next()){
                    new Details();
                    f.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    f.setVisible(false);
                    new Login();
                }
            }
            catch(Exception ev){
                ev.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
