public abstract class PlatePurchaseTemplate {

    public void purchasePlate(User user, Menu plat, Payment paymentStrategy, double Price) {
        displayPlate(plat);
        displayUserAccount(user);
        processOrder(user, plat, paymentStrategy,Price);
    }

    public abstract String displayPlate(Menu plate);
    public abstract String displayUserAccount(User user);
    public abstract void processOrder(User user, Menu plate, Payment paymentStrategy, double Price);

}
