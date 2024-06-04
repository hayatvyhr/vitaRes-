import javax.swing.*;
import java.awt.*;

public class PaymentProgressFrame {
    private JFrame frame;
    private JLabel message;
    private JPanel p1;
    private JProgressBar progressBar1;

    public PaymentProgressFrame() {
        frame = new JFrame("Processing Payment");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(450, 450));
        frame.setResizable(false);
        frame.setUndecorated(true);

        message.setText("Processing payment...");
        progressBar1.setStringPainted(true);
        frame.add(p1);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }

    public void setProgress(int value) {
        progressBar1.setValue(value);
    }

    public void setMessage(String msg) {
        message.setText(msg);
    }
}
