package Employee;

import java.awt.*;
import javax.swing.*;
// import java.lang.Thread;
import java.awt.event.*;

public class FrontPage implements ActionListener{
    JFrame frame;
    JLabel id;
    JButton button;

    public FrontPage(){
        frame = new JFrame("Employee Management System");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("src/Employee/Icons/FrontPage.jpg");
        Image image = imageIcon.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon finalImageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(finalImageIcon);
        imageLabel.setBounds(0, 0, 1200, 700);
        frame.add(imageLabel);

        button = new JButton("Click here to Continue");
        button.setFont(new Font("serif", Font.PLAIN, 10));
        // button.setForeground(Color.WHITE);
        // button.setBackground(Color.black);
        // button.setOpaque(true);
        // button.setBorderPainted(false);
        button.setBounds(550, 600, 200, 50);
        button.addActionListener(this);
        imageLabel.add(button);

        id = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        id.setFont(new Font("serif", Font.ITALIC, 70));
        id.setBounds(30, 20, 1200, 70);
        id.setForeground(Color.cyan);
        imageLabel.add(id);

        // id = new JLabel();

        // id.setBounds(0, 0, 1360, 750);
        // id.setLayout(null);

        // JLabel lid = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        // lid.setBounds(80, 30, 1500, 100);
        // lid.setFont(new Font("serif", Font.PLAIN, 70));
        // lid.setForeground(Color.red);
        // id.add(lid);
        // id.add(button);
        // frame.add(id);

        // frame.getContentPane().setBackground(Color.WHITE);

        frame.setVisible(true);
        frame.setSize(1200, 700);
        frame.setLocation(20, 10);

        // while(true){
        //     lid.setVisible(false);
        //     try{
        //         Thread.sleep(500);
        //     }
        //     catch(Exception e){}
        //     lid.setVisible(true);
        //     try{
        //         Thread.sleep(500);
        //     }
        //     catch(Exception e){}
        // }
    }

    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            frame.setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new FrontPage();
    }
}
