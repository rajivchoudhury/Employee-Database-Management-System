package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class PrintEmployee implements ActionListener{
    JFrame frame;
    JLabel label, imageLabel;
    JButton newButton, closeButton;

    public PrintEmployee(ResultSet rSet){
        frame = new JFrame("Employee Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("src/Employee/Icons/print.jpg");
        Image image = imageIcon.getImage().getScaledInstance(595, 642, Image.SCALE_DEFAULT);
        ImageIcon finalImageIcon = new ImageIcon(image);
        imageLabel = new JLabel(finalImageIcon);
        imageLabel.setBounds(0, 0, 595, 642);
        frame.add(imageLabel);

        label = new JLabel("Employee Details");
        label.setFont(new Font("serif", Font.BOLD, 25));
        label.setBounds(80, 20, 250, 40);
        imageLabel.add(label);

        label = new JLabel("Employee ID: ");
        label.setFont(new Font("serif", Font.BOLD, 17));
        label.setBounds(20, 70, 130, 30);
        imageLabel.add(label);

        label = new JLabel("Name: ");
        label.setFont(new Font("serif", Font.BOLD, 17));
        label.setBounds(20, 110, 100, 30);
        imageLabel.add(label);

        label = new JLabel("Father's Name: ");
        label.setFont(new Font("serif", Font.BOLD, 17));
        label.setBounds(20, 150, 130, 30);
        imageLabel.add(label);

        label = new JLabel("Address: ");
        label.setFont(new Font("serif", Font.BOLD, 17));
        label.setBounds(20, 190, 100, 30);
        imageLabel.add(label);

        label = new JLabel("Mobile No.: ");
        label.setFont(new Font("serif", Font.BOLD, 17));
        label.setBounds(20, 230, 100, 30);
        imageLabel.add(label);

        label = new JLabel("Email ID: ");
        label.setFont(new Font("serif", Font.BOLD, 17));
        label.setBounds(20, 270, 100, 30);
        imageLabel.add(label);

        label = new JLabel("Education: ");
        label.setFont(new Font("serif", Font.BOLD, 17));
        label.setBounds(20, 310, 100, 30);
        imageLabel.add(label);

        label = new JLabel("Job Post: ");
        label.setFont(new Font("serif", Font.BOLD, 17));
        label.setBounds(20, 350, 100, 30);
        imageLabel.add(label);

        try{
            label = new JLabel(rSet.getString("emp_id"));
            label.setFont(new Font("serif", Font.PLAIN, 15));
            label.setBounds(160, 70, 200, 30);
            imageLabel.add(label);

            label = new JLabel(rSet.getString("name"));
            label.setFont(new Font("serif", Font.PLAIN, 15));
            label.setBounds(160, 110, 200, 30);
            imageLabel.add(label);

            label = new JLabel(rSet.getString("fathers_name"));
            label.setFont(new Font("serif", Font.PLAIN, 15));
            label.setBounds(160, 150, 200, 30);
            imageLabel.add(label);

            label = new JLabel(rSet.getString("address"));
            label.setFont(new Font("serif", Font.PLAIN, 15));
            label.setBounds(160, 190, 200, 30);
            imageLabel.add(label);

            label = new JLabel(rSet.getString("phone"));
            label.setFont(new Font("serif", Font.PLAIN, 15));
            label.setBounds(160, 230, 200, 30);
            imageLabel.add(label);

            label = new JLabel(rSet.getString("email"));
            label.setFont(new Font("serif", Font.PLAIN, 15));
            label.setBounds(160, 270, 200, 30);
            imageLabel.add(label);

            label = new JLabel(rSet.getString("education"));
            label.setFont(new Font("serif", Font.PLAIN, 15));
            label.setBounds(160, 310, 200, 30);
            imageLabel.add(label);

            label = new JLabel(rSet.getString("job_post"));
            label.setFont(new Font("serif", Font.PLAIN, 15));
            label.setBounds(160, 350, 200, 30);
            imageLabel.add(label);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        newButton = new JButton("New Search");
        newButton.setForeground(Color.WHITE);
        newButton.setBackground(Color.BLACK);
        newButton.setOpaque(true);
        newButton.setBorderPainted(false);
        newButton.addActionListener(this);
        newButton.setBounds(70, 500, 160, 30);
        imageLabel.add(newButton);

        closeButton = new JButton("Close");
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(Color.BLACK);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(this);
        closeButton.setBounds(280, 500, 160, 30);
        imageLabel.add(closeButton);

        frame.setVisible(true);
        frame.setSize(595, 642);
        frame.setLocation(200, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newButton){
            frame.setVisible(false);
            new ViewEmployee();
        }
        if(e.getSource() == closeButton){
            System.exit(0);
        }
    }
}
