package frontEnd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Init {
    private JFrame frame;
    private JPanel navPanel;
    private JButton personalCenterBtn;
    private JPanel mainPanel;
    private JScrollPane questionListScrollPane;
    private JList<String> questionList;
    private JPanel infoPanel;
    private JTextArea textArea;
    private JLabel accuracyLabel;
    private JScrollPane rankingScrollPane;
    private JTable rankingTable;
    private JButton startQuizBtn;
    private JButton exitBtn;
    private int indexOfProblem;
    public Init() throws Exception {
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

    private void createMainPanel() throws Exception {
        mainPanel = new JPanel(new BorderLayout());

        // 创建题目列表面板
        createQuestionListPanel();
        questionList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = questionList.locationToIndex(e.getPoint());
                    if (index != -1) {
                        System.out.println("Double clicked on item at index: " + index);
                        indexOfProblem = index+1;
                        System.out.println(indexOfProblem);
                    }
                }
            }
        });


        mainPanel.add(questionList, BorderLayout.WEST);

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
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
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



    private void createInfoPanel() throws Exception {
        infoPanel = new JPanel(new BorderLayout());
        textArea = new JTextArea();
        textArea.setSize(300, 400);
        // 创建正确率标签
        accuracyLabel = new JLabel("Accuracy：80%");
        textArea.setText("Welcome"+"\n"+ "to"+"\n"
                +"Java"+"\n"+"Cool!");
        Font font = new Font("Arial", Font.PLAIN, 100);
        textArea.setFont(font);
        textArea.setEditable(false);
        infoPanel.add(textArea, BorderLayout.CENTER);

    }


    //返回题号
    public int startQuiz() throws Exception {
        // 获取选中题目的索引
        int selectedIndex = questionList.getSelectedIndex();

        // 检查是否有题目被选中
        if (selectedIndex != -1) {
            // 返回选中题目的索引
            return selectedIndex + 1;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) throws Exception {
        new Init();
    }
}