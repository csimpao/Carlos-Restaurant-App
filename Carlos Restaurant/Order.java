import java.util.*;

public class Order {
    private ArrayList<Appetizer> apps;
    private ArrayList<MainCourse> mains;
    private ArrayList<Dessert> des;

    public Order() {
        apps = new ArrayList<Appetizer>();
        mains = new ArrayList<MainCourse>();
        des = new ArrayList<Dessert>();
    }

    public Item order(Item menuItem) throws FoodException {
        String type = menuItem.getType();

        if (type.equals(Appetizer.FOODTYPE)) 
        {
            apps.add((Appetizer) menuItem);
            System.out.println(Appetizer.FOODTYPE + " has been added");
            return menuItem;
        }
        else if (type.equals(MainCourse.FOODTYPE)) 
        {
            mains.add((MainCourse) menuItem);
            System.out.println(MainCourse.FOODTYPE + " has been added");
            return menuItem;
        }
        else if (type.equals(Dessert.FOODTYPE)) 
        {
            des.add((Dessert) menuItem);
            System.out.println(Dessert.FOODTYPE + " has been added");
            return menuItem;
        }
        else 
        {
            throw new FoodException("Item doesn't exist");
        }
    }

    public void printAppetizers() {
        for (int i = 0; i < apps.size(); i++) {
            apps.get(i).foodInfo();
        }
    }

    public void printMains() {
        for (int i = 0; i < mains.size(); i++) {
            mains.get(i).foodInfo();
        }
    }

    public void printDesserts() {
        for (int i = 0; i < des.size(); i++) {
            des.get(i).foodInfo();
        }
    }
}
