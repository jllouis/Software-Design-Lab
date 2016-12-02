/**
 * Created by lael on 10/15/16.
 */

import java.util.Scanner;


public class GroceryStoreTest {

    static final int SIZE = 100; // the default size of the list

    /**
     * adds an item onto the list
     * @param list the list which the item will be added on to
     * @param item the item that will be added onto the list
     */
    void add(String[] list, String item) {
        for (int i = 0; i < list.length; i++)
            if (list[i] == null) {
                list[i] = item;
                break;
            }
    }

    /**
     * inserts one of more quantities of a particular item into the list
     * @param list the list which the items will be added on to
     * @param item the item(s) that will be added
     * @param quantity the number of time the item will be added to the list
     */
    private void add(String[] list, String item, int quantity) {
        for (int i = 0, inserted = 0; i < list.length && inserted < quantity; i++)
            if (list[i] == null) {
                list[i] = item;
                inserted++;
            }
    }

    /**
     * returns the index of the item in the list, if it exists
     * @param list the array containing the items to be searched
     * @param key the string of the array
     * @return the index of the first occurrence of the item in the list
     */
    int search(String[] list, String key) {
        for (int i = 0; i < list.length; i++)
            if (list[i] == key)
                return i;

        return -1;
    }

    /**
     * erases all occurrences of a certain item from the list
     * @param list the array containing the items to be deleted
     * @param key the string of the items
     */
    void eraseAll(String[] list, String key) {
        for (int i = 0; i < list.length; i++)
            if (list[i] == key)
                list[i] = null;
    }

    /**
     * removes one occurrence of an item from the list
     * @param list the array containing the items to be deleted
     * @param key the string of the item
     */
    void removeOne(String[] list, String key) {
        for (int i = 0; i < list.length; i++)
            if (list[i] == key) {
                list[i] = null;
                break;
            }
    }

    /**
     * Initializes the array of the store items
     * @return returns the initialized array containing the initial items of the store
     */
    private String[] init() {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome\nPlease enter the size of the list: ");
        String[] items = new String[input.nextInt()];

        if (items.length < 1)
            items = new String[SIZE];

        System.out.print("How many items do you want in your grocery store? ");

        int i = input.nextInt();
        input.nextLine(); // 'clears' the buffer

        for (int j = 0; j < i; j++) {
            System.out.print("Enter name of item "+(j+1)+": ");
            items[j] = input.nextLine();
        }

        return items;
    }

    /**
     * prints items that are in the list
     * @param list the list that contains the items that are to be printed
     */
    private void print(String[] list)
    {
        System.out.print("Items in store: ");
        for (String s : list) {
            if (s != null)
                System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        GroceryStoreTest myStore = new GroceryStoreTest();
        String[] items = myStore.init(); // initializing
        myStore.print(items);

        //adding one item to the store
        myStore.add(items, "box");
        myStore.print(items);

        //adding multiple items to the store
        myStore.add(items, "pencil", 10);
        myStore.add(items, "knives", 6);
        myStore.print(items);

        //searching for knives
        System.out.println("The first knife is in cell #"+myStore.search(items, "knives"));

        //removing one item from the store
        myStore.removeOne(items, "pencil");
        myStore.print(items);

        //removing all knives from the store
        myStore.eraseAll(items, "knives");
        myStore.print(items);

    }
}