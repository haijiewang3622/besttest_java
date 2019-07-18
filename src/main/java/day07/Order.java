package day07;

public class Order {
    int order_id;
    int order_amount;
    int order_user_id;
    String order_user_name;
    int order_merchant_id;
    String order_merchant_name;

    public int getOrder_id(Integer s2) {
        return order_id;
    }

    public int setOrder_id(int order_id) {
        this.order_id = order_id;
        return order_id;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public int getOrder_user_id() {
        return order_user_id;
    }

    public void setOrder_user_id(int order_user_id) {
        this.order_user_id = order_user_id;
    }

    public String getOrder_user_name() {
        return order_user_name;
    }

    public void setOrder_user_name(String order_user_name) {
        this.order_user_name = order_user_name;
    }

    public int getOrder_merchant_id() {
        return order_merchant_id;
    }

    public void setOrder_merchant_id(int order_merchant_id) {
        this.order_merchant_id = order_merchant_id;
    }

    public String getOrder_merchant_name() {
        return order_merchant_name;
    }

    public void setOrder_merchant_name(String order_merchant_name) {
        this.order_merchant_name = order_merchant_name;
    }

    public Order() {
    }

    public Order(int order_id) {
        this.order_id = order_id;
    }

    public Order(int order_id, int order_amount, int order_user_id, String order_user_name, int order_merchant_id, String order_merchant_name) {
        this.order_id = order_id;
        this.order_amount = order_amount;
        this.order_user_id = order_user_id;
        this.order_user_name = order_user_name;
        this.order_merchant_id = order_merchant_id;
        this.order_merchant_name = order_merchant_name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_amount=" + order_amount +
                ", order_user_id=" + order_user_id +
                ", order_user_name='" + order_user_name + '\'' +
                ", order_merchant_id=" + order_merchant_id +
                ", order_merchant_name='" + order_merchant_name + '\'' +
                '}';
    }
}
