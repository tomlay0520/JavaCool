package frontEnd;

import main.java.Backend.Submit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Saving extends JFrame {
    private static JTextArea textArea;
    private JTextArea questionArea;
    private JTextArea resultArea;
    public String result = "";

    public static String answer = "";

    public static String getTextArea(){
        return textArea.getText();
    }
    public Saving() {
        setTitle("做题界面");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
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



        // 按钮面板
        JPanel buttonPanel = new JPanel();
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
        buttonPanel.add(submitButton);

        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

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