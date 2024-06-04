import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Show the splash screen
        Splash splash = new Splash();
        splash.setVisible(true);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splash.setVisible(false);




        ResMediator mediator = new ResApp();
         mediator.loadUsersFromFile();
        Login loginScreen = new Login(mediator);
        loginScreen.setVisible(true);

        Menu menu1 = new Menu("Breakfast", "a complit menu", 7,1);
        Menu menu2 = new Menu("Lunch", "a complit menu", 14,2);
        Menu menu3 = new Menu("Dinner", "a complit menu", 17,3);
        mediator.addMenu(menu1);
        mediator.addMenu(menu2);
        mediator.addMenu(menu3);


    }
}
