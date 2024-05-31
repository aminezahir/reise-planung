package Gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.masai.TicketDao;
import com.masai.TicketDaoImpl;

public class reisegui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblStatus;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    reisegui frame = new reisegui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public reisegui() {
        setTitle("Reise Planung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter UserName");
        lblNewLabel.setBounds(45, 33, 117, 16);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Enter Password");
        lblNewLabel_1.setBounds(45, 113, 117, 16);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBounds(79, 183, 117, 29);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = textField_1.getText();
                TicketDao dao = new TicketDaoImpl();
                String loginResult = dao.adminLogin(username, password);
                if (loginResult.equals("Welcome admin")) {
                    lblStatus.setText("Login successful: " + loginResult);
                } else {
                    lblStatus.setText("Login failed: " + loginResult);
                }
            }
        });

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.setBounds(255, 183, 117, 29);
        contentPane.add(btnNewButton_1);

        textField = new JTextField();
        textField.setBounds(194, 28, 130, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(194, 108, 130, 26);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        lblStatus = new JLabel("");
        lblStatus.setBounds(45, 220, 400, 16);
        contentPane.add(lblStatus);
    }
}
