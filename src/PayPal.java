import javax.swing.*;

public class PayPal implements Payment {
    @Override
    public void pay(double amount, Runnable onComplete) {
        PaymentProgressFrame progressFrame = new PaymentProgressFrame();
        progressFrame.show();

        Thread paymentThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 100; i++) {
                    final int progress = i;
                    SwingUtilities.invokeLater(() -> progressFrame.setProgress(progress));
                    Thread.sleep(20);
                }


                Thread.sleep(500);
                SwingUtilities.invokeLater(() -> {
                    progressFrame.close();
                    onComplete.run(); // Call the callback
                });

            } catch (InterruptedException e) {
                SwingUtilities.invokeLater(() -> progressFrame.setMessage("Payment process interrupted."));
            }
        });

        paymentThread.start();
    }
}
