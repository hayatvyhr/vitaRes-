import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ChoicePlate {
    private JButton makeOrderButton;
    private JPanel panel;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p;
    private JLabel test;
    private JLabel menu3;
    private JLabel menu2;
    private JPanel p4;
    private JTextField textField1;
    private JButton Submit;
    private JLabel label1;
    private JButton logOutButton;
    private JComboBox<Integer>  comboBox1;

    private JFrame frame;


    public ChoicePlate(ResMediator mediator, User user) {
        frame = new JFrame("plate choice");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 560));
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        comboBox1.addItem(1);
        comboBox1.addItem(2);
        comboBox1.addItem(3);
        comboBox1.addItem(4);
        comboBox1.addItem(5);
        Scanner scanner = new Scanner(System.in);

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("img/logo222.png")));

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment paymentCard = new CreditCard();
                Payment paymentPayPal = new PayPal();
                Payment paymentStrategy = null;
                PlatePurchaseTemplate ReserveOnline = new ReserveOnline();

                int text = Integer.parseInt(textField1.getText());

                Integer selectedItem = (Integer) comboBox1.getSelectedItem();

                System.out.println("Selected item from JComboBox: " + selectedItem);
                Menu matchingMenu = null;
                System.out.println("Text from JTextField: " + text);
                List<Menu> menu = mediator.getMenu();
                for (Menu p : mediator.getMenu()) {
                    if (p.getMenuNumber() == text) {
                        matchingMenu= p;
                        break;
                    }
                }
                if (matchingMenu != null) {

                    String[] paymentOptions = {"Credit Card", "PayPal"};
                    String selectedOption = (String) JOptionPane.showInputDialog(
                            frame,
                            "Select a payment method:",
                            "Payment Options",
                            JOptionPane.QUESTION_MESSAGE,
                            icon,
                            paymentOptions,
                            paymentOptions[0]
                    );
                    if (selectedOption != null) {
                        if ("Credit Card".equals(selectedOption)) {
                            paymentStrategy = paymentCard;
                            String cardNumber = JOptionPane.showInputDialog(frame, "Enter your card number:");
                            if (cardNumber == null || cardNumber.trim().isEmpty()) {
                                return;
                            }
                            else if (cardNumber != null && !cardNumber.trim().isEmpty()) {

                                ReserveOnline.purchasePlate(user, matchingMenu, paymentStrategy, matchingMenu.getPrice()* selectedItem);
                                frame.dispose();


                            } else {
                                JOptionPane.showMessageDialog(frame, "Invalid card number.");
                            }
                        } else if ("PayPal".equals(selectedOption)) {
                            paymentStrategy = paymentPayPal;
                            boolean isValidEmail = false;
                            String email;
                            while (!isValidEmail) {
                                email = JOptionPane.showInputDialog(frame, "Enter your PayPal email:");
                                if (email == null) {

                                    return;
                                }
                            isValidEmail = email.contains("@");

                            if (!isValidEmail) {
                                JOptionPane.showMessageDialog(frame, "Invalid email. Please enter a valid email ");
                            }}
                            if (isValidEmail) {
                                ReserveOnline.purchasePlate(user, matchingMenu, paymentStrategy, matchingMenu.getPrice()* selectedItem);
                                frame.dispose();


                            }
                        }

                    }


                } else {
                    JOptionPane.showMessageDialog(frame, "No matching plate found. Please try again.");
                }
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                frame.dispose();

                System.exit(0);

            }
        });


    }
    public void setVisible(boolean b) {
        frame.setVisible(true);

    }

}
