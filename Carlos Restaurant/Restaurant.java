import java.util.*;
public class Restaurant {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Order newOrder = new Order();
        Receipt newReceipt = new Receipt();
        ArrayList<Item> itemsList = new ArrayList<Item>();
        Map<Integer, ArrayList<Item>> customerList = new HashMap<Integer, ArrayList<Item>>();
        Scanner sc = new Scanner(System.in);
        int people = 0;
        System.out.print(">");
        System.out.print("Welcome! How can I help you? ");
        while (sc.hasNextLine()) {
            String orderAction = sc.nextLine();
            if (orderAction == null || orderAction.equalsIgnoreCase("")) 
            {
                System.out.print("\n>");
				continue;
            } 
            else if (orderAction.equalsIgnoreCase("MENU")) 
            {
                menu.printMenu();
            } 
            else if (orderAction.equalsIgnoreCase("ORDER")) 
            {
                System.out.print("How many people? ");
                while (true) {
                    try {
                        people = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.print("Please enter in a valid number of customers: ");
                        sc.next();
                        continue;
                    }
                }
                
                int currPeople = 1;
                String answer = "";
                while (currPeople <= people) {
                    System.out.println("Customer #" + (currPeople));
                    System.out.print("What item number? ");
                    int itemNum = 0;
                    
            
                    try {
                        itemNum = sc.nextInt();
                        sc.nextLine();
                        Item item = menu.orderItem(itemNum);
                        Item orderedItem = newOrder.order(item);
                        if (customerList.get(currPeople) == null) {
                            customerList.put(currPeople, new ArrayList<Item>());
                        }
                        
                        itemsList.add(orderedItem);
                        customerList.get(currPeople).add(orderedItem);
                        
                    } catch (NullPointerException nu) {
                        System.out.println(nu.getMessage());
                    } catch (FoodException food) {
                        System.out.println(food.getMessage());
                    } catch (InputMismatchException input) {
                        System.out.println("Please enter in a valid number");
                        sc.next();
                        continue;
                    }
                    
                    System.out.print("Want more? ");
                    answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("YES")) {
                        continue;
                    } else if (answer.equalsIgnoreCase("NO")){
                        currPeople++;
                        continue;
                    }
                }
            }
            else if (orderAction.equalsIgnoreCase("APPETIZERS")) 
            {
                newOrder.printAppetizers();
            }
            else if (orderAction.equalsIgnoreCase("MAINS")) 
            {
                newOrder.printMains();
            }
            else if (orderAction.equalsIgnoreCase("DESSERTS")) 
            {
                newOrder.printDesserts();
            }
            else if (orderAction.equalsIgnoreCase("BILL")) 
            {
                if (people > 1) {
                    newReceipt.getSplitBill(itemsList, people);
                } else if (people == 1) {
                    newReceipt.getTotalBill(itemsList);
                }

                System.out.println("Thank you for ordering. Have a good day! :)\n");
                return;
            }
            else if (orderAction.equalsIgnoreCase("ITEMS")) 
            {
                if (people > 1) {
                    for (Integer num : customerList.keySet()) {
                        System.out.println("\nCustomer " + num + "'s Order: ");
                        ArrayList<Item> itemList = customerList.get(num);
                        for (int i = 0; i < itemList.size(); i++) {
                            itemList.get(i).foodInfo();
                        }
                    }
                } else if (people == 1) {
                    System.out.println("\nCustomer's Order: ");
                    for (int i = 0; i < itemsList.size(); i++) {
                        itemsList.get(i).foodInfo();
                    }
                }
            }
        }
    }
}