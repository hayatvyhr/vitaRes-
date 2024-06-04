import java.util.List;

public interface ResMediator {

        public void addUser(User user);
        public void addMenu(Menu plate);

        public void processOrder(User user, Menu plate, Payment paymentStrategy, double Price);

        public List<Menu> getMenu();

        public User[] getUsers();

        void loadUsersFromFile();
        void saveUserToFile(User user);
}
