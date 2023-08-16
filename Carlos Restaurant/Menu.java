import java.util.*;
import java.io.*;
public class Menu {
    private ArrayList<Item> menuList;

    public Menu() {
        try {
            menuList = createMenu();
        } catch (IOException io) {
            System.out.println(io.getMessage());
            System.exit(1);
        }
        // foodMaps();
    }

    private ArrayList<Item> createMenu() throws IOException {
        ArrayList<Item> newMenu = new ArrayList<Item>();
        Scanner sc = new Scanner(new File("menuinfo.txt"));

        while (sc.hasNextLine()) {
            String type = sc.nextLine();
            if (type.equals(Appetizer.FOODTYPE)) {
                int appNum = Integer.parseInt(sc.nextLine());
                String appName = sc.nextLine();
                double appPrice = Double.parseDouble(sc.nextLine());
                int descripLines = Integer.parseInt(sc.nextLine());
                String appDescription = "";
                for (int i = 0; i < descripLines; i++) {
                    appDescription += sc.nextLine() + "\n";
                }
                newMenu.add(new Appetizer(appNum, appName, appPrice, type, appDescription));

            } else if (type.equals(MainCourse.FOODTYPE)) {
                int mainNum = Integer.parseInt(sc.nextLine());
                String mainName = sc.nextLine();
                double mainPrice = Double.parseDouble(sc.nextLine());
                int descripLines = Integer.parseInt(sc.nextLine());
                String mainDescription = "";
                for (int i = 0; i < descripLines; i++) {
                    mainDescription += sc.nextLine() + "\n";
                }
                newMenu.add(new MainCourse(mainNum, mainName, mainPrice, type, mainDescription));

            } else if (type.equals(Dessert.FOODTYPE)) {
                int dessertNum = Integer.parseInt(sc.nextLine());
                String dessertName = sc.nextLine();
                double dessertPrice = Double.parseDouble(sc.nextLine());
                int descripLines = Integer.parseInt(sc.nextLine());
                String dessertDescription = "";
                for (int i = 0; i < descripLines; i++) {
                    dessertDescription += sc.nextLine() + "\n";
                }
                newMenu.add(new Dessert(dessertNum, dessertName, dessertPrice, type, dessertDescription));
            }
        }
        return newMenu;
    }

    public void printMenu() {
        for (int i = 0; i < menuList.size(); i++) {
            menuList.get(i).foodInfo();
        }
    }

    public Item orderItem(int option) throws NullPointerException {
        if (option < 1 || option > menuList.size()) {
            throw new NullPointerException("Item Not Available");
        }
        return menuList.get(option-1);
    }

    
}
