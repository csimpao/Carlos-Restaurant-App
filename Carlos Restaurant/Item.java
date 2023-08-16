abstract public class Item {
    private String itemName;
    private int itemNum;
    private double price;
    private String itemType;
    private String foodDescription;

    public Item() {
        itemName = "";
        itemNum = 0;
        price = 0.00;
        itemType = "ITEM";
        foodDescription = "";
    }

    public Item(int itemNum, String itemName, double price, String itemType, String foodDescription) {
        this.itemType = itemType;
        this.setItemNum(itemNum);
        this.setItemName(itemName);
        this.setPrice(price);
        this.setDescription(foodDescription);
    }

    public int getItemNum() {
        return this.itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.foodDescription;
    }

    public void setDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    abstract public String getType();

    public void foodInfo() {
        System.out.print(this.itemNum + ". " + this.itemType + ": " + this.itemName + " - $" + this.price);
        System.out.print("\n" + this.foodDescription + "\n");
    }
}
