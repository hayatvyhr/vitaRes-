import javax.swing.*;
import java.util.Objects;


public class ReserveOnline extends PlatePurchaseTemplate {
    @Override
    public String displayPlate(Menu plate) {
        // Display plate information in a message dialog
        return "Plate Name: " + plate.getName() + "\n"
                + "Plate Description: " + plate.getDescription() + "\n"
                + "Plate Price: $" + plate.getPrice();
    }

    @Override
    public String displayUserAccount(User user) {
        // Display user account information in a message dialog
        return "User Name: " + user.getNom() + "\n"
                + "User Email: " + user.getEmail();
    }
    @Override
    public void processOrder(User user, Menu plate, Payment paymentStrategy, double price) {
        // Assuming ResMediator exists and is valid
        ResMediator mediator = new ResApp();
        mediator.addUser(user);
        mediator.addMenu(plate);
        mediator.processOrder(user, plate, paymentStrategy, price);
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("img/shipping.png")));
        String orderInfo = "<html><body style='width: 300px; font-family: Arial, sans-serif; font-size: 12px;'>"
                + "<h2 style='color: #5bc0de; font-size: 12px;'>Order Confirmation</h2>"
                + "<p style='font-size: 12px;'><strong>Order for plate:</strong> " + plate.getName() + " processed successfully!</p>"
                + "<p style='font-size: 12px;'><strong>Payment amount:</strong> $" + price + "</p>"
                +"<br>" + "<p style='font-size: 10px;'>You're going to receive your order at the provided address:</p>"+ user.getAdresse()
                +"<br>"
                + "<p>Regards, <b style='color: #5bc0de;font-size: 12px;'>VitaRes's Restaurant</b></p>"
                + "</body></html>";

        JOptionPane.showMessageDialog(
                null,
                orderInfo,
                "Order Confirmation",
                JOptionPane.INFORMATION_MESSAGE,
                icon
        );
    }


    public void purchasePlate(User user, Menu plate, Payment paymentStrategy, double price) {
        // Display the order details first
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("img/logo222.png")));
        String info ="<html><body>" +
                "<h2 style='color: #08CAD1; font-size: 20px;'>Order Details</h2>" +  // Fix the style attribute
                displayPlate(plate) +  // Include displayPlate resulty
                "\n" +
                displayUserAccount(user);  // Include displayUserAccount result
        JOptionPane.showMessageDialog(null, info, "Order Details", JOptionPane.INFORMATION_MESSAGE,icon);
        // Start the payment process
        paymentStrategy.pay(price, () -> {
            // Ensure this runs after the payment is complete
            SwingUtilities.invokeLater(() -> {
                processOrder(user, plate, paymentStrategy, price); // Process the order after payment
            });
        });
    }




}