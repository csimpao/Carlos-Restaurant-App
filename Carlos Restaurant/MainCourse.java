public class MainCourse extends Item {
    public static final String FOODTYPE = "MAIN";
    public MainCourse(int num, String name, double price, String type, String descrip) {
        super(num, name, price, type, descrip);
    }

    public String getType() {
        return FOODTYPE;
    }

    public void foodInfo() {
        super.foodInfo();
    }
}
