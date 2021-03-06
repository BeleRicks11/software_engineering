package it.unipr.fava_pellegrini;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

/**
 * Client Class - Person Subclass
 * Each Client has the name attribute, the surname, the username,
 * the password, the hashed password generated from the last one and a boolean value
 * showing the status of the client, if logged or not
 *
 * @author Daniele Pellegrini <daniele.pellegrini@studenti.unipr.it> - 285240
 * @author Riccardo Fava <riccardo.fava@studenti.unipr.it> - 287516
 */
public class Client extends Person {
    private boolean logged;
    private ArrayList<Bottle> purchases;

    /**
     * This constructor generates an empty Client Object
     * It can be used to create an unRegistered Client
     */
    public Client () {
    }

    /**
     * This constructor generates a Client object from its parameters.
     * When called, the constructor generates an empty cart for this client.
     *
     * @param name     the name of the member to be created
     * @param surname  the surname of the member to be created
     * @param username the username of the member to be created
     * @param password the password of the member to be created
     */
    Client(String name, String surname, String username, String password) {
        super(name, surname, username, password);
        this.logged = false;
        this.purchases = new  ArrayList<>();
    }

    public ArrayList<Bottle> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Bottle> purchases) {
        this.purchases = purchases;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    /**
     * Register the client to the Winehouse Store
     *
     * @param store the Winehouse the client wants to register to
     */
    public void registration(@NotNull Winehouse store) {
        store.addUser(Client.this);
    }

    /**
     * Sign in the client to the Winehouse Store
     * Use a temporary client because the checkPassword inserted as parameter is not hashed
     *
     * @param store         the Winehouse the client wants to sign in to
     * @param checkUsername the username credential chosen yo sign in
     * @param checkPassword the password credential chosen to sign in
     */
    public void login(Winehouse store, String checkUsername, String checkPassword){
        Client tempClient = new Client("Client", "Testing", checkUsername, checkPassword);
        boolean found = false;
        for (Person p : store.getUsers()) {
            if (p.getUsername().equals(checkUsername) && p.getPassword().equals(tempClient.getPassword())) {
                found = true;
                setLogged(true);
            }
        }
        if (found){
            System.out.println("Login Successful!");
        }
        else System.out.println("Bad Login. The username or password you have entered is invalid. Retry!");
    }

    /**
     * Search the wine the client choose in the store.
     *
     * @param store     the Winehouse store the client wants to search into
     * @param wine_name the name of the wine searched
     * @param wine_year the year of the wine searched
     *
     * @return a String with the information about the wine searched. If the wine
     * is not present in the store informs the client about it
     */
    public void searchWine(Winehouse store, String wine_name, int wine_year) {
        store.searchWine(wine_name, wine_year);
    }

    /**
     * Buy a bottle a number of bottles of a wine available in the store
     *
     * @param store   the Winehouse Store the client wants to make the request
     * @param buyWine the wine to buy
     * @param bottles the quantity of bottle to buy
     */
    public void buyWine(Winehouse store, Wine buyWine, int bottles){
        store.sellWine(Client.this, buyWine, bottles);
    }

    /**
     * Turn on the notification about the availability of the wine, so to be
     * notified when there's enough bottles to buy
     *
     * @param store the Winehouse Store
     * @param buyWine the wine requested
     * @param bottles the amount of bottles requested
     */
    public void askNotification(Winehouse store, Wine buyWine, int bottles){
        if (this.isLogged()) {
            Order newOrder = new Order(Client.this, buyWine, bottles);
            store.addOrder(newOrder);
            newOrder.setNotification(true);
            System.out.println("The notification request has been processed. You'll be warned when the bottle comes back in stock.\n");
            System.out.println("The System will send the notification to the client:\n" + newOrder.getBuyer().toString() + "\n");
            System.out.println("The bottles requested in the notification are:\n" + newOrder.getOrderBottle().toString() + "\n" );
        }
        else System.out.println("Please sign in to ask for notification");
    }

    /**
     * Add a new purchase to the purchases list
     *
     * @param buyWine the wine to buy
     * @param buyAmount the quantity of bottle to buy
     *
     */
    public void addPurchase(Wine buyWine, int buyAmount){
        Bottle newBottle = new  Bottle(buyWine, buyAmount);
        this.purchases.add(newBottle);
    }
}
