import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Login {
    private  JFrame frame;
    private JPanel p;
    private JPanel p1;
    private JPanel p2;
    private JLabel icon;
    private JLabel welcome;
    private JLabel Email;
    private JLabel login;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton signupButton;
    private JPanel p3;

    public Login(ResMediator mediator) {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550, 470));
        frame.setResizable(false);
        frame.add(p);
        frame.pack();
        frame.setLocationRelativeTo(null);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredEmail = textField1.getText();
                String enteredPassword = new String(passwordField1.getPassword());

                boolean loginSuccess = false;
                User loggedInUser = null;
                for (User user : mediator.getUsers()) {
                    if (user.getEmail().equals(enteredEmail) && user.getPassword().equals(enteredPassword)) {
                        loginSuccess = true;
                        loggedInUser = user;
                        break;
                    }
                }

                if (loginSuccess) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    frame.dispose();

                    new ChoicePlate(mediator, loggedInUser);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid email or password. Please try again.");
                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp signUp = new SignUp(mediator);
                signUp.setVisible(true);
                frame.dispose();
            }
        });
    }

    public void setVisible(boolean b) {
        frame.setVisible(true);

    }
}
