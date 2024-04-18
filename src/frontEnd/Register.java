package frontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Register extends JFrame implements ActionListener{
    public Register(){
        JFrame frame = new JFrame("Register");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panelMain = new JPanel(new GridLayout(3, 1));
        JPanel panelUsr = new JPanel(new FlowLayout());
        JLabel usr = new JLabel("User Name:");
        JTextField textFieldU = new JTextField(20);
        panelUsr.add(usr);
        panelUsr.add(textFieldU);

        JPanel panelPaw = new JPanel(new FlowLayout());
        JLabel paw = new JLabel("Password:");
        JTextField textFieldP = new JTextField(20);
        panelPaw.add(paw);
        panelPaw.add(textFieldP);

        panelUsr.add(usr, textFieldU);  panelPaw.add(paw, textFieldP);
//        JLabel label = new JLabel("Register");
        JPanel panelButton = new JPanel(new FlowLayout());
        panelButton.add(new JButton("Register"));
        panelButton.add(new JButton("back"));
        panelMain.add(panelUsr);
        panelMain.add(panelPaw);
        panelMain.add(panelButton);
        frame.add(panelMain);
        frame.setVisible(true);
        frame.setSize(600, 500);
        frame.setLocation(300, 200);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public static void main(String[] args) {
        LoginUi loginUi = new LoginUi();
    }
}
