package DeliveryApp;


import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<order> orders;

    public User(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(order order) {
        orders.add(order);
    }

    public void viewOrderHistory() {
        if (orders.isEmpty()) {
            System.out.println("У вас пока нет заказов.");
        } else {
            System.out.println("--- История заказов ---");
            for (int i = 0; i < orders.size(); i++) {
                System.out.println("Заказ №" + (i + 1));
                System.out.println(orders.get(i));
            }
        }
    }
}

