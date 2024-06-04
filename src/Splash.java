import javax.swing.*;
import java.awt.*;

public class Splash extends JWindow {
    public Splash() {
        JLabel splashLabel = new JLabel(
                new ImageIcon("src/img/logo.png"), SwingConstants.CENTER
        );
        getContentPane().add(splashLabel, BorderLayout.CENTER);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int width = 600;
        int height = 500;
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        setBounds(x, y, width, height);
    }


}
