import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ResApp implements ResMediator {
    private List<User> users;
    private List<Menu> menu = new ArrayList<>();

    private static final String USER_FILE_PATH = "Users.txt";


    public ResApp() {
        this.users = new ArrayList<>();
        this.menu = new ArrayList<>();
        loadUsersFromFile();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addMenu(Menu plat) {
        menu.add(plat);
    }

    @Override
    public void processOrder(User user, Menu plat, Payment paymentStrategy, double Price) {
        if (menu.contains(plat) && users.contains(user)) {
            PaymentReceipt paymentReceipt = new PaymentReceipt(user, plat, Price, paymentStrategy);
            paymentReceipt.send(); // Ensure this runs on the EDT
        } else {
            System.out.println("Sorry, we could not process your order. Please try again later.");
        }
    }

    @Override
    public List<Menu> getMenu() {
        return menu;

    }


    @Override
    public User[] getUsers() {
        return users.toArray(new User[users.size()]);
    }

    @Override
    public void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    User user = new User(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users from file: " + e.getMessage());
        }
    }






    public void saveUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH, true))) {
            writer.write(user.getNom() + "," + user.getEmail() + "," + user.getAdresse() + "," + user.getTel() + "," + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}