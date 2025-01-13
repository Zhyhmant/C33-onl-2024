package DeliveryApp;



import java.util.List;

public class order {
    private List<MenuItem> items;
    private double totalPrice;
    private String status;

    public order(List<MenuItem> items) {
        this.items = items;
        this.status = "Оформлен";
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        double totalPrice = 0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public List<MenuItem> getItems(){
        return items;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Items:\n");
        for (MenuItem item : items) {
            sb.append("\t- " ).append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
        }
        sb.append("Total: $" ).append(totalPrice).append("\n");
        sb.append("Status: " ).append(status);
        return sb.toString();
    }
}

