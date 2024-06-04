public class Menu {
    private String name;
    private String description;
    private double price;
private int MenuNumber;

    public Menu(String name, String description, double price, int menuNumber) {
        this.name = name;
        this.description = description;
        this.price = price;
        MenuNumber = menuNumber;
    }

    public void setMenuNumber(int platNumber) {
        MenuNumber = platNumber;
    }

    public int getMenuNumber() {
        return MenuNumber ;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}



