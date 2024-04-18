package frontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginUi extends JFrame{
    private JLabel username = new JLabel("UserName:");
    private JLabel password = new JLabel("PassWord:");
    private JTextField user = new JTextField(20);
    private JPasswordField pass = new JPasswordField(20);
    JFrame frame = new JFrame("Welcome to Java Cool!");
    JPanel panelMain = new JPanel(new GridLayout(4, 1));
    JPanel panelUser = new JPanel(new FlowLayout());
    JPanel panelPass = new JPanel(new FlowLayout());
    ImageIcon icon = new ImageIcon("pics/图片1.png");
    JLabel labelPic = new JLabel(icon);
    JButton buttonLogin = new JButton("Login");
    JButton buttonRegis = new JButton("Register");
    JPanel panelNull = new JPanel();
    JPanel panelButton = new JPanel(new GridLayout(1, 3));


    public LoginUi(){
        buttonLogin.setPreferredSize(new Dimension(100, 50));
        buttonRegis.setPreferredSize(new Dimension(100, 50));
        panelUser.add(username);    panelUser.add(user);
        panelPass.add(password);    panelPass.add(pass);
        frame.setSize(600, 500);
        frame.setLocation(480, 200);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        panelButton.add(buttonLogin);
        panelButton.add(panelNull);
        panelButton.add(buttonRegis);
        panelMain.add(labelPic);  panelMain.add(panelUser);
        panelMain.add(panelPass);   panelMain.add(panelButton);
        frame.add(panelMain);

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonLogin &&
                        user.getText().equals("manager0520") && pass.getText().equals("123456")){
                    JOptionPane.showMessageDialog(null,"Login successfully!");
                    try {
                        new Init();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.setVisible(false);
                }else if (e.getSource() == buttonLogin &&
                        !user.getText().equals("manager0520") || !pass.equals("123456")){
                    JOptionPane.showMessageDialog(null, "username doesn't exist or password is wrong!");
                }

            }
        });
        buttonRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Register();
            }
        });
    }


    public static void main(String[] args) {
        new LoginUi();
    }



}