package Food_Delivety_App;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class FoodDeliveryApp {
    private final JFrame frame;
    private final DefaultListModel<String> cartModel;
    private  JList<String> cartList;
    private final JLabel totalLabel;
    private HashMap<String,Integer> priceMap;
    private int totalPrice = 0;

    public FoodDeliveryApp(){
    frame = new JFrame("Food delivery App");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,500);
    frame.setLayout(new BorderLayout());

    JPanel menuPanel = new JPanel(new GridLayout(2,3,10,10));
    priceMap = new HashMap<>();

    addFoodItem(menuPanel,"Pizza",30);
    addFoodItem(menuPanel,"Burger",25);
    addFoodItem(menuPanel,"Salad",18);


    frame.add(menuPanel,BorderLayout.CENTER);

    JPanel cartPanel = new JPanel(new BorderLayout());
    cartModel = new DefaultListModel<>();
    cartList = new JList<>(cartModel);
    cartPanel.add(new JLabel("Basket"),BorderLayout.NORTH);
    cartPanel.add(new JScrollPane(cartList),BorderLayout.CENTER);

    JButton orderButton = new JButton("Place on Order");
    orderButton.addActionListener((e -> placeOrder()));
    cartPanel.add(orderButton,BorderLayout.SOUTH);

    frame.add(cartPanel,BorderLayout.EAST);

    totalLabel = new JLabel("Total: 0 BYN",SwingConstants.CENTER);
    totalLabel.setFont(new Font("Arial",Font.BOLD,18));
    frame.add(totalLabel,BorderLayout.SOUTH);

    frame.setVisible(true);
    }

    private void addFoodItem(JPanel panel,String name ,int price){
        JButton button = new JButton(name + "-" + price + "BYN");
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.addActionListener(e -> addToCart(name,price));
        panel.add(button);
        priceMap.put(name,price);
    }
    private void addToCart(String name,int price){
        cartModel.addElement(name + " - " + price + "BYN");
        totalPrice += price;
        updateTotal();
    }
    private void placeOrder(){
        if (cartModel.isEmpty()){
            JOptionPane.showMessageDialog(frame,"The Basket  is empty","ERROR",JOptionPane.ERROR_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(frame,"The order was placed for the amount of"
                    + totalPrice + "BYN!","Success",JOptionPane.INFORMATION_MESSAGE);
            cartModel.clear();
            totalPrice = 0;
            updateTotal();
        }
    }
    private void updateTotal(){
        totalLabel.setText("Total" + totalPrice + "BYN");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FoodDeliveryApp::new);
    }
}
