import javax.swing.*;
import java.util.Objects;

public class PaymentReceipt {
    private User user;
    private Menu plat;
    private double amount;
    private Payment paymentStrategy;

    public PaymentReceipt(User user, Menu plat, double amount, Payment paymentStrategy) {
        this.user = user;
        this.plat = plat;
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void send() {
        // Determine the payment method
        String paymentMethod = paymentStrategy instanceof CreditCard ? "Credit Card" :
                paymentStrategy instanceof PayPal ? "PayPal" : "Unknown";

        // Build the receipt message
        String message = "<html>"
                + "<body style='font-family: sans-serif; color: #333;'>"
                + "<h1 style='color: #5bc0de; margin-bottom: 24px;'>Payment Confirmation</h1>"
                + "<p style='font-size: 10px;'>Dear <span >" + user.getNom() + "</span></p>  "
                +"<br>"
                + "<p style='font-size: 10px;>Thanks for your payment of $" + amount
                + " for: <b>" + plat.getName() + "</b>.</p>"
                + "<p style='font-size: 10px;>Payment method: <i><span style='color: #5bc0de;'>" + paymentMethod + "</span></i></p>"
                +"<br>"
                + "<p>Regards, <b style='color: #5bc0de;font-size: 12px;'>VitaRes's Restaurant</b></p>"
                + "</body>"
                + "</html>";


        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("img/imgg.png")));
        JOptionPane.showMessageDialog(null, message, "Payment Confirmation", JOptionPane.INFORMATION_MESSAGE,icon);
    }
}

