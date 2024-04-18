package frontEnd;

import main.java.Backend.Submit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Saving extends JFrame {
    private JFrame frame = new JFrame();
    private static JTextArea textArea;
    private JTextArea questionArea;
    private JTextArea resultArea;
    public String result = "";
    private JButton back = new JButton("Back");

    public static String answer = "";

    public static String getTextArea(){
        return textArea.getText();
    }
    public Saving() {
        setTitle("做题界面");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(380, 100);
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // 左侧面板，文本编辑区域
        JPanel leftPanel = new JPanel(new BorderLayout());
        textArea = new JTextArea();
        leftPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // 右侧面板，题目和结果显示区域
        JPanel rightPanel = new JPanel(new BorderLayout());
        questionArea = new JTextArea("请编写hello world!的程序" +"\n"+
                " 输出案例:  hello world! ");
        questionArea.setEditable(false);
        resultArea = new JTextArea("结果显示区域");
        questionArea.setEditable(false);
        rightPanel.add(new JScrollPane(questionArea), BorderLayout.NORTH);
        rightPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton submitButton = new JButton("提交");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer = Saving.getTextArea();
                System.out.println(answer);
                System.out.println(Saving.timeReturner());
                String code = "public class Main {"+"\n" +
                        "    public static void main(String[] args) {"+"\n"  +
                        "        System.out.println(\"Hello World!\");"+"\n" +
                        "    }"+"\n"  +
                        "}";
                System.out.println(answer.trim().equals(code.trim()));
                result = Submit.go(Saving.timeReturner(), 1, answer);
                resultArea.setText(result);
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose(); // 关闭当前页面
                    new Init(); // 打开新页面
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonPanel.add(submitButton);
        buttonPanel.add(back);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    //时间
    public static long timeReturner(){
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis;
    }

    //用户的作答
    public  String answerReturner(){
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(util.FileHelper.getDataPath());
        Saving saving = new Saving();
        String code = "public class Main {"+"\n" +
                "    public static void main(String[] args) {"+"\n"  +
                "        System.out.println(\"Hello World!\");"+"\n" +
                "    }"+"\n"  +
                "}";
        System.out.println(code);
        System.out.println(saving.answerReturner().equals(code));
        System.out.println();
        System.out.println(Submit.go(Saving.timeReturner(),1,code));
    }
}