package DeliveryApp;

import java.util.*;

public class DeliveryApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Restaurant> restaurants = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        initRestaurants();
        System.out.println("Добро пожаловать в приложение доставки еды!");

        login();
        while (true) {
            displayMainMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showRestaurants();
                    placeOrder();
                    break;
                case "2":
                    currentUser.viewOrderHistory();
                    break;
                case "0":
                    System.out.println("Спасибо за использование нашего приложения!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }
    }
    //Метод для вывода основного меню
    private static void displayMainMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1 - Сделать заказ");
        System.out.println("2 - Посмотреть историю заказов");
        System.out.println("0 - Выход");
        System.out.print("> ");
    }
    public static void login() {
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        currentUser = new User(name);
        System.out.println("Добро пожаловать, " + currentUser.getName() + "!");
    }
    private static void initRestaurants(){
        List<MenuItem> menu1 = Arrays.asList(
                new MenuItem("Бургер", "Сочная котлета, сыр, овощи", 8.99),
                new MenuItem("Картофель фри", "Хрустящая картошка", 3.99),
                new MenuItem("Кола", "Холодный напиток", 2.99)
        );
        List<MenuItem> menu2 = Arrays.asList(
                new MenuItem("Пицца Маргарита", "Соус, сыр", 10.99),
                new MenuItem("Пепперони", "Соус, сыр, пепперони", 12.99),
                new MenuItem("Салат Цезарь", "Салат, курица, сыр", 8.99)

        );
        restaurants.add(new Restaurant("Burger House", menu1));
        restaurants.add(new Restaurant("Pizza Place", menu2));

    }

    private static void showRestaurants() {
        System.out.println("\n--- Рестораны ---");
        for (int i = 0; i < restaurants.size(); i++){
            System.out.println((i + 1) + ". " + restaurants.get(i).getName());
        }
        System.out.println("Выберите номер ресторана, чтобы просмотреть меню");
        int restaurantChoice;

        while (true){
            try {
                String restaurantInput = scanner.nextLine();
                restaurantChoice = Integer.parseInt(restaurantInput) -1 ;
                if (restaurantChoice >=0 && restaurantChoice < restaurants.size()){
                    showMenu(restaurants.get(restaurantChoice));
                    break;
                } else {
                    System.out.println("Неверный ввод. Попробуйте еще раз.");
                }
            }catch (NumberFormatException e) {
                System.out.println("Некорректный ввод! Пожалуйста, введите целое число.");
            }

        }


    }

    private static void showMenu(Restaurant restaurant){
        System.out.println("\n--- Меню ресторана: " + restaurant.getName() + " ---");
        List<MenuItem> menu = restaurant.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }
    private static void placeOrder() {
        System.out.println("Выберите номера позиций через запятую, чтобы добавить в заказ (например: 1,2,3):");
        String orderInput = scanner.nextLine();
        String[] itemIndexes = orderInput.split(",");
        List<MenuItem> items = new ArrayList<>();

        try {
            for(String index : itemIndexes){
                int indexItem = Integer.parseInt(index.trim()) - 1 ;
                for (Restaurant restaurant : restaurants){
                    if (indexItem >= 0 && indexItem < restaurant.getMenu().size()){
                        items.add(restaurant.getMenu().get(indexItem));
                        break;
                    }
                }
            }
        } catch (NumberFormatException e){
            System.out.println("Некорректный ввод! Пожалуйста, введите целые числа через запятую.");
            return;
        }
        if(items.isEmpty()){
            System.out.println("Некорректный ввод, заказ пустой. Попробуйте еще раз");
            return;
        }

        order order = new order(items);
        currentUser.placeOrder(order);
        System.out.println("Заказ успешно оформлен!");
        System.out.println(order);
    }

}

