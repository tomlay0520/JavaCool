import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Init {
    private JFrame frame;
    private JPanel navPanel;
    private JButton personalCenterBtn;
    private JPanel mainPanel;
    private JScrollPane questionListScrollPane;
    private JList<String> questionList;
    private JPanel infoPanel;
    private JLabel accuracyLabel;
    private JScrollPane rankingScrollPane;
    private JTable rankingTable;
    private JButton startQuizBtn;
    private JButton exitBtn;

    public Init() {
        // 创建主窗
        frame = new JFrame("Initial Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // 创建导航栏
        createNavPanel();

        // 创建主要内容面板
        createMainPanel();

        // 将导航栏和主要内容面板添加到主窗口中
        frame.add(navPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        // 设置窗口可见
        frame.setVisible(true);
        frame.setLocation(400, 120);
    }

    private void createNavPanel() {
        navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // 添加个人中心按钮
        personalCenterBtn = new JButton("Self Center");
        navPanel.add(personalCenterBtn);
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new BorderLayout());

        // 创建题目列表面板
        createQuestionListPanel();
        mainPanel.add(questionListScrollPane, BorderLayout.WEST);

        // 创建信息面板
        createInfoPanel();
        mainPanel.add(infoPanel, BorderLayout.CENTER);

        // 创建开始做题和退出按钮
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startQuizBtn = new JButton("开始做题");
        exitBtn = new JButton("退出");

        // 为开始做题按钮添加事件监听器
        startQuizBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Saving();
                frame.dispose();
                try {
                    System.out.println(startQuiz());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        buttonPanel.add(startQuizBtn);
        buttonPanel.add(exitBtn);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createQuestionListPanel() {
        // 模拟题目数据
        String[] questions = {"Question 1 创建你的第一个java程序Hello World!- Easy", "Question 2 - Medium", "Question 3 - Hard", "Question 4 - Easy", "Question 5 - Medium"};

        questionList = new JList<>(questions);
        questionListScrollPane = new JScrollPane(questionList);
        questionListScrollPane.setPreferredSize(new Dimension(200, 0));
    }

    private void createInfoPanel() {
        infoPanel = new JPanel(new BorderLayout());

        // 创建正确率标签
        accuracyLabel = new JLabel("Accuracy：80%");
        infoPanel.add(accuracyLabel, BorderLayout.NORTH);

        // 创建排名表格
        String[] columnNames = {"Rank", "Username", "Score"};
        Object[][] data = {
                {1, "User1", 95},
                {2, "User2", 90},
                {3, "User3", 85},
                {4, "User4", 80},
                {5, "User5", 75},
                {6, "User6", 70},
                {7, "User7", 60},
                {8, "User8", 55},
                {9, "User9", 50},
                {10, "User10", 45},
                {11, "User11", 35},
                {12, "User12", 30},
                {13, "User13", 25},
                {14, "User14", 20},
                {15, "User15", 5}
        };
        rankingTable = new JTable(data, columnNames);
        rankingScrollPane = new JScrollPane(rankingTable);
        infoPanel.add(rankingScrollPane, BorderLayout.CENTER);
    }


     //返回题号
    private int startQuiz() throws Exception {
        // 获取选中题目的索引
        int selectedIndex = questionList.getSelectedIndex();

        // 检查是否有题目被选中
        if (selectedIndex != -1) {
            // 返回选中题目的索引
            return selectedIndex + 1;
        } else {
            // 提示用户选择一个题目
            JOptionPane.showMessageDialog(frame, "请选择一个题目", "错误", JOptionPane.ERROR_MESSAGE);
            // 抛出异常，提示用户没有选择题目
            throw new Exception("you didn't select a problem");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Init::new);
    }
}