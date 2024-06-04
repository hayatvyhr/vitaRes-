import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {
    private JPanel p;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel adresse;
    private JLabel email;
    private JLabel nom;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signupButton;
    private JLabel icon;
    private JPanel p1;
    private JButton loginButton;
    private JLabel tel;
    private JLabel pass;
    private JLabel confirme;
    private  JFrame frame;

    public SignUp(ResMediator mediator) {
        frame = new JFrame("Signup");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 320));
        frame.setResizable(false);
        frame.add(p);
        frame.pack();
        frame.setLocationRelativeTo(null);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String email = textField2.getText();
                String address = textField3.getText();
                String phone = textField4.getText();
                String password = new String(passwordField1.getPassword());
                String confirmPassword = new String(passwordField2.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.");
                    return;
                }
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Invalid email format.");
                    return;
                }

                User newUser = new User(name, email, address, phone, password);
                mediator.addUser(newUser);
                mediator.saveUserToFile(newUser);

                JOptionPane.showMessageDialog(null, "User registered successfully.");
                Login loginScreen = new Login(mediator);
                loginScreen.setVisible(true);
                frame.dispose();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Login loginScreen = new Login(mediator);
                loginScreen.setVisible(true);
            }
        });
    }
    public void setVisible(boolean b) {
        frame.setVisible(true);

    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
