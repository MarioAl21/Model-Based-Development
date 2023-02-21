import java.util.ArrayList;
//import java.util.List;

public class Menu {
    private final ArrayList<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void print() {
        int index = 0;
        while(index <= items.size() - 1) 
            System.out.println((index + 1) + ". " + items.get(index ++).name());
        System.out.println("Selection: ");
    }

    public MenuItem select(int selection) {
        return items.get(selection - 1);
    }
}
