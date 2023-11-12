import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenGUI extends JFrame {
    private User loggedUser;
    private JPanel sidePanel = new JPanel(new FlowLayout());
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel topMainPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    private JPanel bottomMainPanel = new JPanel(new GridBagLayout());
    public MainScreenGUI(User loggedUser) {
        this.loggedUser = new User(loggedUser);

        this.setTitle("Graid");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.addComponents();
        this.setVisible(true);
    }

    private void addComponents() {
        // TODO: basic layout components
        topMainPanel.setPreferredSize(new Dimension((int)(this.getWidth() * 0.8), (int)(this.getHeight() * 0.05)));
        topMainPanel.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        bottomMainPanel.setBorder(BorderFactory.createDashedBorder(Color.GREEN));

        mainPanel.add(topMainPanel, BorderLayout.NORTH);
        mainPanel.add(bottomMainPanel, BorderLayout.CENTER);

        sidePanel.setPreferredSize(new Dimension((int)(this.getWidth() * 0.2), this.getHeight()));
        sidePanel.setBorder(BorderFactory.createDashedBorder(Color.RED));

        mainPanel.setBorder(BorderFactory.createDashedBorder(Color.BLUE));

        this.add(sidePanel, BorderLayout.WEST);
        this.add(mainPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new GridBagLayout());

        JButton scheduleButton = new JButton("Schedule");
        scheduleButton.setFont(new Font("Lato", Font.PLAIN, 16));
        JButton assignmentsButton = new JButton("Assignments");
        assignmentsButton.setFont(new Font("Lato", Font.PLAIN, 16));
        JButton testsButton = new JButton("Tests");
        testsButton.setFont(new Font("Lato", Font.PLAIN, 16));
        JButton gradesButton = new JButton("Grades");
        gradesButton.setFont(new Font("Lato", Font.PLAIN, 16));

        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // schedule
                MainScreen.showSchedule(e, loggedUser.getTypeOfUser(), MainScreenGUI.this);
            }
        });

        assignmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // assignments
                MainScreen.showAssignments(e, loggedUser.getTypeOfUser(), MainScreenGUI.this);
            }
        });

        testsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // tests
                MainScreen.showTests(e, loggedUser.getTypeOfUser(), MainScreenGUI.this);
            }
        });

        gradesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // grades
                MainScreen.showGrades(e, loggedUser.getTypeOfUser(), MainScreenGUI.this);
            }
        });

        buttonsPanel.add(scheduleButton, CustomLayoutManager.createGridBagConstraints(0, 0, new Insets(100, 0, 10, 0)));
        buttonsPanel.add(assignmentsButton, CustomLayoutManager.createGridBagConstraints(0, 1, new Insets(0, 0, 10, 0)));
        buttonsPanel.add(testsButton, CustomLayoutManager.createGridBagConstraints(0, 2, new Insets(0, 0, 10, 0)));
        buttonsPanel.add(gradesButton, CustomLayoutManager.createGridBagConstraints(0, 3));

        sidePanel.add(buttonsPanel);

        JPanel helloPanel = new JPanel(new GridBagLayout());

        JLabel helloLabel = new JLabel("Hello, " + loggedUser.getFirstName() + "!");
        helloLabel.setFont(new Font("Lato", Font.PLAIN, 16));
        JButton logoutButton = new JButton("Log out");
        logoutButton.setFont(new Font("Lato", Font.PLAIN, 16));

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(MainScreenGUI.this, "Are you sure?", "Log out?", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    loggedUser = null;
                    MainScreenGUI.this.dispose();
                    SwingUtilities.invokeLater(() -> new LoginScreenGUI());
                }
            }
        });

        helloPanel.add(helloLabel, CustomLayoutManager.createGridBagConstraints(0, 0, new Insets(0, 0, 0, 20)));
        helloPanel.add(logoutButton, CustomLayoutManager.createGridBagConstraints(1, 0));

        topMainPanel.add(helloPanel);

        // initialize schedule as default view
        switch(loggedUser.getTypeOfUser()) {
            case Student:
            case Parent:
                this.studentParentSchedule();
                break;
            case Teacher:
                this.teacherSchedule();
                break;
        }
    }

    public void studentParentSchedule() {
        bottomMainPanel.removeAll();

        JLabel label = new JLabel("Student/Parent Schedule");
        bottomMainPanel.add(label);

        bottomMainPanel.revalidate();
        bottomMainPanel.repaint();
    }
    public void teacherSchedule() {
        bottomMainPanel.removeAll();

        JLabel label = new JLabel("Teacher Schedule");
        bottomMainPanel.add(label);

        bottomMainPanel.revalidate();
        bottomMainPanel.repaint();
    }

    public void studentParentAssignments() {
        bottomMainPanel.removeAll();

        JLabel label = new JLabel("Student/Parent Assignments");
        bottomMainPanel.add(label);

        bottomMainPanel.revalidate();
        bottomMainPanel.repaint();
    }
    public void teacherAssignments() {
        bottomMainPanel.removeAll();

        JLabel label = new JLabel("Teacher Assignments");
        bottomMainPanel.add(label);

        bottomMainPanel.revalidate();
        bottomMainPanel.repaint();
    }

    public void studentParentTests() {
        bottomMainPanel.removeAll();

        JLabel label = new JLabel("Student/Parent Tests");
        bottomMainPanel.add(label);

        bottomMainPanel.revalidate();
        bottomMainPanel.repaint();
    }
    public void teacherTests() {
        bottomMainPanel.removeAll();

        JLabel label = new JLabel("Teacher Tests");
        bottomMainPanel.add(label);

        bottomMainPanel.revalidate();
        bottomMainPanel.repaint();
    }

    public void studentParentGrades() {
        bottomMainPanel.removeAll();

        JLabel label = new JLabel("Student/Parent Grades");
        bottomMainPanel.add(label);

        bottomMainPanel.revalidate();
        bottomMainPanel.repaint();
    }
    public void teacherGrades() {
        bottomMainPanel.removeAll();

        JLabel label = new JLabel("Teacher Grades");
        bottomMainPanel.add(label);

        bottomMainPanel.revalidate();
        bottomMainPanel.repaint();
    }
}
