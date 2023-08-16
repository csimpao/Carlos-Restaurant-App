public class Dessert extends Item {
    public static final String FOODTYPE = "DESSERT";
    public Dessert(int num, String name, double price, String type, String descrip) {
        super(num, name, price, type, descrip);
    }

    public String getType() {
        return FOODTYPE;
    }

    public void foodInfo() {
        super.foodInfo();
    }
}
