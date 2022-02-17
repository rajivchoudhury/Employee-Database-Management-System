package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Details implements ActionListener {
    JFrame frame;
    JLabel heading;
    JButton addButton, viewButton, removeButton, updateButton, closeButton;

    Details(){
        frame = new JFrame("Employee Details");

        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("src/Employee/Icons/details.jpg");
        Image im = imageIcon.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon finalImageIcon = new ImageIcon(im);
        JLabel imageLabel = new JLabel(finalImageIcon);
        imageLabel.setBounds(0, 0, 700,500);
        frame.add(imageLabel);

        heading = new JLabel("Employee Details");
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setBounds(430, 20, 200, 40);
        heading.setForeground(Color.BLACK);
        imageLabel.add(heading);

        addButton = new JButton("Add");
        addButton.setBounds(420, 80, 100, 40);
        addButton.setFont(new Font("serif",Font.BOLD,15));
        addButton.addActionListener(this);
        imageLabel.add(addButton);
        
        viewButton = new JButton("View");
        viewButton.setBounds(530, 80, 100, 40);
        viewButton.setFont(new Font("serif",Font.BOLD,15));
        viewButton.addActionListener(this);
        imageLabel.add(viewButton);
        
        removeButton = new JButton("Remove");
        removeButton.setBounds(420, 140, 100, 40);
        removeButton.setFont(new Font("serif",Font.BOLD,15));
        removeButton.addActionListener(this);
        imageLabel.add(removeButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(530, 140, 100, 40);
        updateButton.setFont(new Font("serif",Font.BOLD,15));
        updateButton.addActionListener(this);
        imageLabel.add(updateButton);

        closeButton = new JButton("Close");
        closeButton.setBounds(420, 200, 210, 40);
        closeButton.setFont(new Font("serif",Font.BOLD,15));
        closeButton.addActionListener(this);
        imageLabel.add(closeButton);
        
        frame.setVisible(true);
        frame.setSize(700, 500);
        frame.setLocation(100, 80);
    }

    public static void main(String[] args) {
        new Details();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            frame.setVisible(false);
            new AddEmployee();
        }
        if(e.getSource() == viewButton){
            frame.setVisible(false);
            new ViewEmployee();
        }
        if(e.getSource() == removeButton){
            frame.setVisible(false);
            new RemoveEmployee();
        }
        if(e.getSource() == updateButton){
            frame.setVisible(false);
            new UpdateEmployee();
        }
        if(e.getSource() == closeButton){
            System.exit(0);
        }
    }
}
