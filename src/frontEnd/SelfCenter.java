package frontEnd;

import javax.swing.*;
import java.awt.*;

public class SelfCenter extends JFrame {
    private JFrame frame = new JFrame("Self Center");
    private JPanel mainPanel = new JPanel(new GridLayout(4, 1));
    private JPanel panelUser = new JPanel(new FlowLayout());
    private JPanel panelEmail = new JPanel(new FlowLayout());
    private JLabel userName = new JLabel("User Name:");
    private JTextField u = new JTextField(20);
    private JLabel eMail = new JLabel("E-mail: ");
    private JTextField uText = new JTextField(20);
    private JTextField uEmail = new JTextField(20);

    public SelfCenter(){
        frame.setSize(600, 500);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(SelfCenter::new);
    }
}