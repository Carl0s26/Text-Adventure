//! Carlos STATUS -- no
// * Ethan STATUS -- no
//? Sebastian STATUS -- Sigo chambeando


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Text_Adventure {

    //*DONE!!!!!!!!!!

    public static void pause(Integer time) {
        try{
            Thread.sleep(time);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!

    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!

    public static void deletefile(File filename){
        try {
            FileWriter deleteContent = new FileWriter(filename, false);
            deleteContent.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!
    public static class Foes {
        int min_strength;
        int max_strength;
        int agility;
        int health;
        String Monster_name;
        
    
        Foes(String Monster_name, int min_strength,int max_strength, int agility, int health) {
            this.min_strength = min_strength;
            this.max_strength = max_strength;
            this.agility = agility;
            this.health = health;
            this.Monster_name = Monster_name;
        }
        public int getHealth() {
            return health;
        }
        public int getAgility() {
            return agility;
        }
        public int getMinStrength(){
            return min_strength;
        }
        public int getMaxStrength(){
            return max_strength;
        }
        public String getMonster_name(){
            return Monster_name;
        }
    
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!
    public static class InventoryObject {
        int prize;
        String identification_number;
        String object_name;

        public InventoryObject(){

        }
    
        public InventoryObject(String object_name, String identification_number, int prize) {
            this.identification_number = identification_number;
            this.prize = prize;
            this.object_name = object_name;
        }

        public String getidentification_number() {
            return identification_number;
        }
        public int getprize() {
            return prize;
        }
        public String getobject_name() {
            return object_name;
        }
        public void setName(String object_name){
            this.object_name = object_name;
        }
    }
    

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!

    public static boolean archery(Integer Speed) {
        Scanner scan = new Scanner(System.in);
        String inpt = "0";
        boolean increasing = true;
        clear();
        int number = 0;
        try{
            while(true){
                for (var i = 0; i < number; i++) {
                    System.out.print(" ");
                }
                System.out.print("o");
                System.out.println("");
                System.out.println("             /\\");
                System.out.println("            |  |");
                System.out.println("             \\/");
                //System.out.println(number);
                pause(Speed);

                if (increasing) {
                    number++;
                } else {
                    number--;
                }

                if (number == 30) {
                    increasing = false;
                } else if (number == 0) {
                    increasing = true;
                }

                clear();

                if (System.in.available() > 0) {
                    inpt = scan.nextLine();
                }

                if  (inpt.equals("")){
                    return (number <= 16 && number >= 11);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally {
            
        }
        return false;
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!

    public static void menu(ArrayList<InventoryObject> AllObjects) {
        debugFunction("Choose an object to buy and type 12 or 'enter' to exit my shop");
        for (int i = 0; i < 11; i++) {
            System.out.println("[" + AllObjects.get(i).identification_number +  "] " + AllObjects.get(i).getobject_name() + ": " + AllObjects.get(i).getprize() + " coins");
        }
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    

    //*DONE!!!!!!!!!!
    static Boolean debugMode = true;

    static void debugFunction(String message){
        if(debugMode){
            System.out.println(message);
        }
        else {
            slowPrint(message);
        }
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    //*DONE!!!!!!!!!!
    // the function for the user to buy objects
    public static int shop(ArrayList<InventoryObject> AllObjects, List<InventoryObject> UserInventory, InventoryObject Small_Health_Potion, 
    InventoryObject Medium_Health_Potion, InventoryObject Big_Health_Potion, InventoryObject Strength_token,
    InventoryObject Speedy_Pills, InventoryObject Mysterious_Potion, InventoryObject Lucky_Clover, InventoryObject Dodge_Tonic, 
    InventoryObject Cactus_Sword, InventoryObject Soap, InventoryObject Bow, int Player_coins, ArrayList <String> Weapons, File gui, String name, 
    int Player_Health, int agility, int Player_luck, int Player_Strength, int Dodges){

        String buyer_Choice = ""; 
        Scanner scan = new Scanner(System.in);
        boolean While = true;
        deletefile(gui);
        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
        debugFunction("Hello fellow traveler");
        debugFunction("Welcome to my shop");
        menu(AllObjects);

        do {
            String user_choice = scan.nextLine();
        switch (user_choice) {
            case "1":
                if (Player_coins >= Small_Health_Potion.getprize()) {
                    Player_coins -= Small_Health_Potion.getprize();
                    UserInventory.add(Small_Health_Potion);
                    clear();
                    debugFunction("You successfully bought the item: " + Small_Health_Potion.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                    

                }
                else{
                    clear();
                    debugFunction("You don't have enougth coins");
                    menu(AllObjects);
                }
                break;
            case "2":
                if (Player_coins >= Medium_Health_Potion.getprize()) {
                    Player_coins -= Medium_Health_Potion.getprize();
                    UserInventory.add(Medium_Health_Potion);
                    clear();
                    debugFunction("You successfully bought the item: " + Medium_Health_Potion.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                }
                else{
                    clear();
                    debugFunction("You don't have enougth coins");
                    menu(AllObjects);
                }
                break;
            case "3":
                if (Player_coins >= Big_Health_Potion.getprize()) {
                    Player_coins -= Big_Health_Potion.getprize();
                    UserInventory.add(Big_Health_Potion);
                    clear();
                    debugFunction("You successfully bought the item: " + Big_Health_Potion.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                }
                else{
                    clear();
                    debugFunction("You don't have enougth coins");
                    menu(AllObjects);
                }
                break;
            case "4":
                if (Player_coins >= Strength_token.getprize()) {
                    Player_coins -= Strength_token.getprize();
                    UserInventory.add(Strength_token);
                    clear();
                    debugFunction("You successfully bought the item: " + Strength_token.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                }
                else{
                    clear();
                    debugFunction("You don't have enougth coins");
                    menu(AllObjects);
                }
                break;
            case "5":
                if (Player_coins >= Speedy_Pills.getprize()) {
                    Player_coins -= Speedy_Pills.getprize();
                    UserInventory.add(Speedy_Pills);
                    clear();
                    debugFunction("You successfully bought the item: " + Speedy_Pills.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                }
                else{
                    clear();
                    debugFunction("You don't have enougth coins");
                    menu(AllObjects);
                }
                break;
            case "6":
                
                if (Player_coins >= Mysterious_Potion.getprize()) {
                    Player_coins -= Mysterious_Potion.getprize();
                    UserInventory.add(Mysterious_Potion);
                    clear();
                    debugFunction("You successfully bought the item: " + Mysterious_Potion.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                }
                else{
                    clear();
                    debugFunction("You don't have enougth coins");
                    menu(AllObjects);
                }
                break;
            case "7":
                
                if (Player_coins >= Lucky_Clover.getprize()) {
                    Player_coins -= Lucky_Clover.getprize();
                    UserInventory.add(Lucky_Clover);
                    clear();
                    debugFunction("You successfully bought the item: " + Lucky_Clover.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                }
                else{
                    clear();
                    debugFunction("You don't have enougth coins");
                    menu(AllObjects);
                }
                break;
            case "8":
                
                if (Player_coins >= Dodge_Tonic.getprize()) {
                    Player_coins -= Dodge_Tonic.getprize();
                    UserInventory.add(Dodge_Tonic);
                    clear();
                    debugFunction("You successfully bought the item: " + Dodge_Tonic.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                }
                else{
                    clear();
                    debugFunction("You don't have enougth coins");
                    menu(AllObjects);
                }
                break;
            case "9":
                if (Weapons.contains(Cactus_Sword.object_name)){
                    clear();
                    debugFunction("You've already bought this item!");
                    menu(AllObjects);
                }else{
                    if (Player_coins >= Cactus_Sword.getprize()) {
                        Player_coins -= Cactus_Sword.getprize();
                        Weapons.add(Cactus_Sword.object_name);
                        clear();
                        debugFunction("You successfully bought the item: " + Cactus_Sword.getobject_name());
                        System.out.println("");
                        debugFunction("YOU HAVE NOW UNLOCKED THE CACTUS SWORD WEAPON");
                        System.out.println("");
                        deletefile(gui);
                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                        menu(AllObjects);
                    }
                    else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }
                break;
            case "10":
                
                if (Player_coins >= Soap.getprize()) {
                    Player_coins -= Soap.getprize();
                    UserInventory.add(Soap);
                    clear();
                    debugFunction("You successfully bought the item: " + Soap.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                }
                else{
                    clear();
                    debugFunction("You don't have enougth coins");
                    menu(AllObjects);
                }
                break;
            case "11":
                if (Weapons.contains(Bow.object_name)){
                    clear();
                    debugFunction("You've already bought this item!");
                    menu(AllObjects);
                }else{
                    if (Player_coins >= Bow.getprize()) {
                        Player_coins -= Bow.getprize();
                        Weapons.add(Bow.object_name);
                        clear();
                        debugFunction("You successfully bought the item: " + Bow.getobject_name());
                        System.out.println("");
                        debugFunction("YOU HAVE NOW UNLOCKED THE BOW WEAPON");
                        System.out.println("");
                        deletefile(gui);
                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                        menu(AllObjects);
                    }
                    else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }
                
                break;
            case "1?":
                clear();
                debugFunction("Small Health Potion:");
                debugFunction("Increases health by 10 points");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y")) {
                    if (Player_coins >= Small_Health_Potion.getprize()) {
                        Player_coins -= Small_Health_Potion.getprize();
                        UserInventory.add(Small_Health_Potion);
                        clear();
                        debugFunction("You successfully bought the item: " + Small_Health_Potion.getobject_name());
                        deletefile(gui);
                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                        menu(AllObjects);
                    }else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }else{
                   clear();
                   debugFunction("Would you like to buy something else?"); 
                   menu(AllObjects);
                }

                break;
            case "2?":
                clear();
                debugFunction("Medium Health Potion:");
                debugFunction("Increases health by 15 points ");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y")) {
                    if (Player_coins >= Medium_Health_Potion.getprize()) {
                    Player_coins -= Medium_Health_Potion.getprize();
                    UserInventory.add(Medium_Health_Potion);
                    clear();
                    debugFunction("You successfully bought the item: " + Medium_Health_Potion.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                    }else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }else{
                   clear();
                   debugFunction("Would you like to buy something else?"); 
                   menu(AllObjects);
                }
                
                break;
            case "3?":
                clear();
                debugFunction("Big Health Potion:");
                debugFunction("Increases health by 25 points ");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }
                
                if (buyer_Choice.strip().toLowerCase().equals("yes") || buyer_Choice.strip().toLowerCase().equals("y")) {
                    if (Player_coins >= Big_Health_Potion.getprize()) {
                    Player_coins -= Big_Health_Potion.getprize();
                    UserInventory.add(Big_Health_Potion);
                    clear();
                    debugFunction("You successfully bought the item: " + Big_Health_Potion.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges); 
                    menu(AllObjects);
                    }else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }else{
                    clear();
                    debugFunction("Would you like to buy something else?"); 
                    menu(AllObjects);
                }
                
                break;

            case "4?":
                clear();
                debugFunction("Strength Token:");
                debugFunction("Protein packed token with the power of 1000 men");
                debugFunction("Increases strength by 1 point");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.strip().toLowerCase().equals("yes") || buyer_Choice.strip().toLowerCase().equals("y")) {
                    if (Player_coins >= Strength_token.getprize()) {
                    Player_coins -= Strength_token.getprize();
                    UserInventory.add(Strength_token);
                    clear();
                    debugFunction("You successfully bought the item: " + Strength_token.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                    }else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }else {
                    clear();
                    debugFunction("Would you like to buy something else?"); 
                    menu(AllObjects);
                }
                
                break;
            case "5?":
                clear();
                debugFunction("Speed Pills:");
                debugFunction("Sugar filled pills with the rush of the fastest rabbit.");
                debugFunction("Increases agility by 1 point");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.strip().toLowerCase().equals("yes") || buyer_Choice.strip().toLowerCase().equals("y")) {
                    if (Player_coins >= Speedy_Pills.getprize()) {
                    Player_coins -= Speedy_Pills.getprize();
                    UserInventory.add(Speedy_Pills);
                    clear();
                    debugFunction("You successfully bought the item: " + Speedy_Pills.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                    }
                    else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }
                else {
                    clear();
                   debugFunction("Would you like to buy something else?"); 
                   menu(AllObjects);
                }
                
                break;
            case "6?":
                clear();
                debugFunction("Mysterious Potion:");
                debugFunction("???");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.strip().toLowerCase().equals("yes") || buyer_Choice.strip().toLowerCase().equals("y")) {
                    if (Player_coins >= Mysterious_Potion.getprize()) {
                    Player_coins -= Mysterious_Potion.getprize();
                    UserInventory.add(Mysterious_Potion);
                    clear();
                    debugFunction("You successfully bought the item: " + Mysterious_Potion.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                    }
                    else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }
                else {
                    clear();
                    debugFunction("Would you like to buy something else?"); 
                    menu(AllObjects);
                }
                
                break;
            case "7?":
                clear();
                debugFunction("Lucky Clover:");
                debugFunction("A clover picked from the widest field");
                debugFunction("Increases your luck by 1 point.");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.strip().toLowerCase().equals("yes") || buyer_Choice.strip().toLowerCase().equals("y")) {
                    if (Player_coins >= Lucky_Clover.getprize()) {
                    Player_coins -= Lucky_Clover.getprize();
                    UserInventory.add(Lucky_Clover);
                    clear();
                    debugFunction("You successfully bought the item: " + Lucky_Clover.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                    }
                    else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }
                else {
                    clear();
                   debugFunction("Would you like to buy something else?"); 
                   menu(AllObjects);
                }
                
                break;
            case "8?":
                clear();
                debugFunction("Dodge Tonic:");
                debugFunction("A powerfull tonic with the ability to dodge attacks.");
                debugFunction("You will be able to dodge 3 attacks");
                debugFunction("Caution: Goes away after a fight");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.strip().toLowerCase().equals("yes") || buyer_Choice.strip().toLowerCase().equals("y")) {
                    if (Player_coins >= Dodge_Tonic.getprize()) {
                    Player_coins -= Dodge_Tonic.getprize();
                    UserInventory.add(Dodge_Tonic);
                    clear();
                    debugFunction("You successfully bought the item: " + Dodge_Tonic.getobject_name());
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    menu(AllObjects);
                    }
                    else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }
                else {
                    clear();
                   debugFunction("Would you like to buy something else?"); 
                   menu(AllObjects);
                }
                
                break;
            case "9?":
                clear();
                debugFunction("Cactus Sword:");
                debugFunction("A sword carved from the inside of a cactus lies with its own spikes");
                debugFunction(" BUYER BE WARE: Sword can cause damage to yourself");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.strip().toLowerCase().equals("yes") || buyer_Choice.strip().toLowerCase().equals("y")) {
                    if (Weapons.contains(Cactus_Sword.object_name)){
                        clear();
                        debugFunction("You've already bought this item!");
                        menu(AllObjects);
                    }else{
                        if (Player_coins >= Cactus_Sword.getprize()) {
                            Player_coins -= Cactus_Sword.getprize();
                            Weapons.add(Cactus_Sword.object_name);
                            clear();
                            debugFunction("You successfully bought the item: " + Cactus_Sword.getobject_name());
                            System.out.println("");
                            debugFunction("YOU HAVE NOW UNLOCKED THE CACTUS SWORD WEAPON");
                            System.out.println("");
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            menu(AllObjects);
                        }
                        else{
                            clear();
                            debugFunction("You don't have enougth coins");
                            menu(AllObjects);
                        }
                    }
                }
                else {
                    clear();
                   debugFunction("Would you like to buy something else?"); 
                   menu(AllObjects);
                }
                
                break;
            case "10?":
                clear();
                debugFunction("Soap:");
                System.out.println("Premium soap made with high quality pig fat.");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.strip().toLowerCase().equals("yes") || buyer_Choice.strip().toLowerCase().equals("y")) {
                    if (Player_coins >= Soap.getprize()) {
                        Player_coins -= Soap.getprize();
                        UserInventory.add(Soap);
                        clear();
                        debugFunction("You successfully bought the item: " + Soap.getobject_name());
                        deletefile(gui);
                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                        menu(AllObjects);
                    }
                    else{
                        clear();
                        debugFunction("You don't have enougth coins");
                        menu(AllObjects);
                    }
                }
                else {
                    clear();
                   debugFunction("Would you like to buy something else?"); 
                   menu(AllObjects);
                }
                
                break;
            case "11?":
                clear();
                debugFunction("Bow:");
                debugFunction("Hard wood, with the finnest silk in all the land");
                debugFunction("Unlocks bow weapon");
                System.out.println("Would you like to buy it?");
                buyer_Choice = scan.nextLine(); 

                while (!(buyer_Choice.toLowerCase().equals("no") || buyer_Choice.toLowerCase().equals("n") || buyer_Choice.toLowerCase().equals("yes") || buyer_Choice.toLowerCase().equals("y"))){
                    clear();
                    debugFunction("You should answer the previous question with a yes or no.");
                    debugFunction("Would you like to buy it?");
                    buyer_Choice = scan.nextLine();
                }

                if (buyer_Choice.strip().toLowerCase().equals("yes") || buyer_Choice.strip().toLowerCase().equals("y")) {
                    if (Weapons.contains(Bow.object_name)){
                        clear();
                        debugFunction("You've already bought this item!");
                        menu(AllObjects);
                    }else{
                        if (Player_coins >= Bow.getprize()) {
                            Player_coins -= Bow.getprize();
                            Weapons.add(Bow.object_name);
                            clear();
                            debugFunction("You successfully bought the item: " + Bow.getobject_name());
                            System.out.println("");
                            debugFunction("YOU HAVE NOW UNLOCKED THE BOW WEAPON");
                            System.out.println("");
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            menu(AllObjects);
                        }
                        else{
                            clear();
                            debugFunction("You don't have enougth coins");
                            menu(AllObjects);
                        }
                    }
                }
                else {
                    clear();
                   debugFunction("Would you like to buy something else?"); 
                   menu(AllObjects);
                }
                
                
                break;
            case "esc":
                clear();
                debugFunction("Thank you for shopping in my store");
                pause(2000);
                clear();
                While = false;
                break;
            case "12":
                clear();
                debugFunction("Thank you for shopping in my store");
                pause(2000);
                clear();
                While = false;
                break;
            case "exit":
                clear();
                debugFunction("Thank you for shopping in my store");
                pause(2000);
                clear();
                While = false;
                break;
            case "enter":
                clear();
                debugFunction("Thank you for shopping in my store");
                pause(2000);
                clear();
                While = false;
                break;
            case "":
                clear();
                debugFunction("Thank you for shopping in my store");
                pause(2000);
                clear();
                While = false;
                break;
            
            default:
                clear();
                debugFunction("Please enter a valid input");
                menu(AllObjects);
                break;
        }
        
        } while (While == true);
        
            return Player_coins;
        
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!

    public static void sleeping(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_coins, int Dodges){
        File gui = new File("gui.txt");
        try {
            FileWriter writer = new FileWriter(gui, true);
            writer.write("Your name: " + name + "\n");
            writer.write("\n");
            writer.write("-------------------------------------------------------\n");                             
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                                   
            writer.write("░░██████░░░░░░░░██████░░\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Health: "    + Player_Health +     "\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Agility: " + agility +  "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Luck: "      + Player_luck +       "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Strength: "  + Player_Strength +   "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Coins: "        + Player_coins +         "\n");                  
                writer.write("░░░░░░░░████████░░░░░░░░        Dodges: " + Dodges + "\n");                  
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");      
            writer.write("-------------------------------------------------------\n"); 
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    

    //*DONE!!!!!!!!!!

    public static void slowPrint(String output) {
        char[] chars = output.toCharArray();
        for (int i = 0; i < chars.length-1; i++){
            System.out.print(chars[i]);
            pause(50);
        }
        System.out.println(chars[chars.length-1]);
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // user scape must always be false when using the function
    //*DONE!!!!!!!!!! (I guess?)

    public static int Player_Health;
    public Integer Player_Strength;
    public static int deads;


    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public static List<Integer> battle_system(Foes Monster, int Player_Health, int agility,  Integer Player_Strength, int Player_luck, int Player_coins, 
    String name, boolean user_escape, List<InventoryObject> UserInventory, InventoryObject Small_Health_Potion, 
    InventoryObject Medium_Health_Potion, InventoryObject Big_Health_Potion, InventoryObject Strength_token, InventoryObject Bow, 
    InventoryObject Speedy_Pills, InventoryObject Mysterious_Potion, InventoryObject Lucky_Clover, InventoryObject Dodge_Tonic, InventoryObject Cactus_Sword, 
    InventoryObject Soap, int Dodges, ArrayList<String> Weapons, List<Integer> Player_Stats, Boolean nurse_on){

            int monster_Health = Monster.getHealth();
            int escape_probability = 0;
            int damage_dealt = 0;
            Random rand = new Random();
            File gui = new File("gui.txt");
            Scanner scan = new Scanner(System.in);
        do {
            if (nurse_on){
                if (UserInventory.size() == 0){
                    debugFunction("Do you: [1] Fight?");
                }else{
                    debugFunction("Do you: [1] Fight, [2] Inventory?");
                }
            }else{
                if (UserInventory.size() == 0){
                    debugFunction("Do you: [1] Fight, [2] Escape?");
                }else{
                    debugFunction("Do you: [1] Fight, [2] Escape, [3] Inventory?");
                }
            }
            
            
            System.out.println("");
            String user_choice = scan.nextLine();
            clear();
            
            if (nurse_on){
                if (UserInventory.size() == 0){
                    while (!user_choice.strip().toLowerCase().equals("fight") && !user_choice.strip().toLowerCase().equals("1")) {
                        clear();
                        debugFunction("You need to choose to fight");
                        debugFunction("Do you: [1] Fight?");
                        user_choice = scan.nextLine();
                        System.out.println("");
                        clear();
                    }
                
                }else{
                    while (!user_choice.strip().toLowerCase().equals("fight") && !user_choice.strip().toLowerCase().equals("1") && !user_choice.strip().toLowerCase().equals("2") && !user_choice.strip().toLowerCase().equals("inventory")) {
                        clear();
                        debugFunction("You need to choose to fight or open your inventory");
                        debugFunction("Do you: [1] Fight, [2] Inventory?");
                        user_choice = scan.nextLine();
                        System.out.println("");
                        clear();
                    }
                }
            }else{
                if (UserInventory.size() == 0){
                    while (!user_choice.strip().toLowerCase().equals("fight") && !user_choice.strip().toLowerCase().equals("escape") && !user_choice.strip().toLowerCase().equals("1") && !user_choice.strip().toLowerCase().equals("2")) {
                        clear();
                        debugFunction("You need to choose to either escape or fight");
                        debugFunction("Do you: [1] Fight, [2] Escape?");
                        user_choice = scan.nextLine();
                        System.out.println("");
                        clear();
                    }
                
                }else{
                    while (!user_choice.strip().toLowerCase().equals("fight") && !user_choice.strip().toLowerCase().equals("escape") && !user_choice.strip().toLowerCase().equals("1") && !user_choice.strip().toLowerCase().equals("2") && !user_choice.strip().toLowerCase().equals("3") && !user_choice.strip().toLowerCase().equals("inventory")) {
                        clear();
                        debugFunction("You need to choose to escape, fight or open your inventory");
                        debugFunction("Do you: [1] Fight, [2] Escape, [3] Inventory?");
                        user_choice = scan.nextLine();
                        System.out.println("");
                        clear();
                    }
                }
            }
            
            

            //! START OF FIGHT


            if (user_choice.toLowerCase().strip().equals("fight") || user_choice.toLowerCase().strip().equals("1")) {
                if (Weapons.size() < 2){
                    for (int i = 1; i <= agility; i++){
                        if (i >= 2) {
                                debugFunction("You managed to make another attack due to your high agility");
                            }
                        damage_dealt = Player_Strength;
                        damage_dealt += rand.nextInt(Player_Strength/3);
                        monster_Health -= damage_dealt;
                        debugFunction("Your attack dealt " + damage_dealt + " damage points");

                        if (damage_dealt > Player_Strength){
                            debugFunction("A CRITICAL HIT!");
                        }
                        if (monster_Health <= 0) {
                            monster_Health = 0;
                            debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                            debugFunction("You managed to kill the " + Monster.getMonster_name() );
                            deads += 1;
                            System.out.println("");
                            damage_dealt = 0;
                            break;
                        }
                        debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                    }
                }else if (Weapons.size() < 3){
                    if (Weapons.get(1).equals("Bow")){
                        String Choices = "";
                        while(!(Choices.equals("1")||(Choices.equals("2")))){
                            clear();
                            debugFunction("Which weapon do you use: [1] " + Weapons.get(0) + ", [2] " + Weapons.get(1) + "?");
                            Choices = scan.nextLine();
                        }
                        if (Choices.equals("1")) {
                            for (int i = 1; i <= agility; i++){
                                if (i >= 2) {
                                        debugFunction("You managed to make another attack due to your high agility");
                                    }
                                damage_dealt = Player_Strength;
                                damage_dealt += rand.nextInt(Player_Strength/3);
                                monster_Health -= damage_dealt;
                                debugFunction("Your attack dealt " + damage_dealt + " damage points");

                                if (damage_dealt > Player_Strength){
                                    debugFunction("A CRITICAL HIT!");
                                }
                                if (monster_Health <= 0) {
                                    monster_Health = 0;
                                    debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                                    debugFunction("You managed to kill the " + Monster.getMonster_name() );
                                    deads += 1;
                                    System.out.println("");
                                    damage_dealt = 0;
                                    break;
                                }
                                debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                            }
                        }else{
                            int speed = 80;
                            clear();
                            while (archery(speed)){
                                damage_dealt += 5;
                                monster_Health -= damage_dealt;
                                if (speed > 10){
                                    speed -= 10;
                                }else{
                                    speed /= 2;
                                }
                            }
                            clear();
                            debugFunction("You missed that arrow");
                            debugFunction("Your attack dealt " + damage_dealt + " damage points");
                            if (monster_Health <= 0) {
                                monster_Health = 0;
                                debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                                debugFunction("You managed to kill the " + Monster.getMonster_name() );
                                deads += 1;
                                System.out.println("");
                                damage_dealt = 0;
                                break;
                            }
                            debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                        }
                    }else{
                        String Choices = "";
                        while(!(Choices.equals("1")||(Choices.equals("2")))){
                            clear();
                            debugFunction("Which weapon do you use: [1] " + Weapons.get(0) + ", [2] " + Weapons.get(1) + "?");
                            Choices = scan.nextLine();
                        }
                        if (Choices.equals("1")) {
                            for (int i = 1; i <= agility; i++){
                                if (i >= 2) {
                                        debugFunction("You managed to make another attack due to your high agility");
                                    }
                                damage_dealt = Player_Strength;
                                damage_dealt += rand.nextInt(Player_Strength/3);
                                monster_Health -= damage_dealt;
                                debugFunction("Your attack dealt " + damage_dealt + " damage points");

                                if (damage_dealt > Player_Strength){
                                    debugFunction("A CRITICAL HIT!");
                                }
                                if (monster_Health <= 0) {
                                    monster_Health = 0;
                                    debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                                    debugFunction("You managed to kill the " + Monster.getMonster_name() );
                                    deads += 1;
                                    System.out.println("");
                                    damage_dealt = 0;
                                    break;
                                }
                                debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                            }
                        }else{
                            for (int i = 1; i <= agility; i++){
                                if (i >= 2) {
                                        debugFunction("You managed to make another attack due to your high agility");
                                    }
                                damage_dealt = Player_Strength + 6;
                                damage_dealt += rand.nextInt(Player_Strength/3);
                                monster_Health -= damage_dealt;
                                debugFunction("Your attack dealt " + damage_dealt + " damage points");

                                Player_Health -= (Player_Strength/4) + 3;
                                debugFunction("You cut yourself and lost" + ((Player_Strength/4) + 3) + " health points");
                                deletefile(gui);
                                damage(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                pause(1000);
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);

                                if (damage_dealt > Player_Strength){
                                    debugFunction("A CRITICAL HIT!");
                                }
                                if (monster_Health <= 0) {
                                    monster_Health = 0;
                                    debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                                    debugFunction("You managed to kill the " + Monster.getMonster_name() );
                                    deads += 1;
                                    System.out.println("");
                                    damage_dealt = 0;
                                    break;
                                }
                                debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                            }
                        }
                    }
                }else{ 
                    String Choices = "";
                    while(!(Choices.equals("1")||(Choices.equals("2")||(Choices.equals("3"))))){
                        clear();
                        if (Weapons.get(1).equals("Bow")){
                            debugFunction("Which weapon do you use: [1] " + Weapons.get(0) + ", [2] " + Weapons.get(1) + ", [3] " + Weapons.get(2) + "?");
                        }else{
                            debugFunction("Which weapon do you use: [1] " + Weapons.get(0) + ", [2] " + Weapons.get(2) + ", [3] " + Weapons.get(1) + "?");
                        }
                        Choices = scan.nextLine();
                    }
                    if (Choices.equals("1")) {
                        for (int i = 1; i <= agility; i++){
                            if (i >= 2) {
                                debugFunction("You managed to make another attack due to your high agility");
                                }
                            damage_dealt = Player_Strength;
                            damage_dealt += rand.nextInt(Player_Strength/3);
                            monster_Health -= damage_dealt;
                            debugFunction("Your attack dealt " + damage_dealt + " damage points");

                            if (damage_dealt > Player_Strength){
                                debugFunction("A CRITICAL HIT!");
                            }
                            if (monster_Health <= 0) {
                                monster_Health = 0;
                                debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                                debugFunction("You managed to kill the " + Monster.getMonster_name() );
                                deads += 1;
                                System.out.println("");
                                damage_dealt = 0;
                                break;
                            }
                            debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                        }
                    }else if (Choices.equals("2")){
                        int speed = 80;
                        clear();
                        while (archery(speed)){
                            damage_dealt += 5;
                            monster_Health -= damage_dealt;
                            if (speed > 10){
                                speed -= 10;
                            }else{
                                speed /= 2;
                            }
                        }
                        clear();
                        debugFunction("You missed that arrow");
                        debugFunction("Your attack dealt " + damage_dealt + " damage points");
                        if (monster_Health <= 0) {
                            monster_Health = 0;
                            debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                            debugFunction("You managed to kill the " + Monster.getMonster_name() );
                            deads += 1;
                            System.out.println("");
                            damage_dealt = 0;
                            break;
                        }
                        debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                    }else{
                        for (int i = 1; i <= agility; i++){
                            if (i >= 2) {
                                    debugFunction("You managed to make another attack due to your high agility");
                                }
                            damage_dealt = Player_Strength + 6;
                            damage_dealt += rand.nextInt(Player_Strength/3);
                            monster_Health -= damage_dealt;
                            debugFunction("Your attack dealt " + damage_dealt + " damage points");

                            Player_Health -= (Player_Strength/4) + 3;
                            debugFunction("You cut yourself and lost" + ((Player_Strength/4) + 3) + " health points");
                            deletefile(gui);
                            damage(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            pause(1000);
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);

                            if (damage_dealt > Player_Strength){
                                debugFunction("A CRITICAL HIT!");
                            }
                            if (monster_Health <= 0) {
                                monster_Health = 0;
                                debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                                debugFunction("You managed to kill the " + Monster.getMonster_name() );
                                deads += 1;
                                System.out.println("");
                                damage_dealt = 0;
                                break;
                            }
                            debugFunction("The " + Monster.getMonster_name() + "'s health is at: " + monster_Health);
                        }
                    }
                }
                
                if (monster_Health > 0) {
                    if(Dodges >= 1){
                        debugFunction("You dodged an attack from the monster");
                    }else{
                        System.out.println("");
                        debugFunction("The " + Monster.getMonster_name() + " managed to attack you back");
                        System.out.println("");
                        
                    }
                    for (int i = 1; i <= Monster.getAgility(); i++){
                        if(Dodges >= 1){
                            debugFunction("You dodged an attack from the monster");
                        }else{
                            if (i >= 2) {
                                debugFunction("The " + Monster.getMonster_name() + " managed to make another attack due its high agility");
                            }
                            damage_dealt = Monster.getMinStrength();
                            damage_dealt += rand.nextInt(Monster.getMaxStrength() - Monster.getMinStrength());
                            Player_Health -= damage_dealt;
                            if (damage_dealt < 2){
                                debugFunction("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage point");
                            }else{
                                debugFunction("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage points");
                            }
                            
                            deletefile(gui);
                            damage(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            pause(1000);
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            
                            debugFunction("Your health is at: " + Player_Health);
                            System.out.println("");
                            damage_dealt = 0;
                            if(nurse_on){

                            }else{
                                if (Player_Health <= 0) {
                                    Player_Health = 0;
                                    deletefile(gui);
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                }
                
            }

            //! END OF FIGHT

            // in case the user chooses inventory this code printa every item in the inventory list with their identiication number and the user then chooses the object by writting the identification number after that we just need to add what each object does in each case.

            //! START OF INVENTORY
            
            else if (user_choice.toLowerCase().strip().equals("inventory") || user_choice.toLowerCase().strip().equals("3")) {
                debugFunction("Choose an item from your inventory to use or press 'enter' to close it:");
                System.out.println("");
                for (int i = 0; i < UserInventory.size(); i++) {
                    debugFunction("[" + UserInventory.get(i).getidentification_number() + "] " + UserInventory.get(i).getobject_name());
                }
                System.out.println("");

                user_choice = scan.nextLine();

                switch (user_choice) {
                    case "1":
                    // small healing potion
                        if (UserInventory.contains(Small_Health_Potion)) {
                            clear();
                            if (Player_Health >= 91){
                                debugFunction("You can't increase your health past 100");
                            }else{
                                debugFunction("Your health has been increased by 10 points");
                                UserInventory.remove(Small_Health_Potion);
                                Player_Health += 10;
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            }
                            
                            break;
                        }
                        
                    case "2":
                    // medium healing potion  
                        if (UserInventory.contains(Medium_Health_Potion)) {
                            clear();
                            if (Player_Health >= 86){
                                debugFunction("You can't increase your health past 100");
                            }else{
                                debugFunction("Your health has been increased by 15 points");
                                UserInventory.remove(Medium_Health_Potion);
                                Player_Health += 15;
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            }
                            break;
                        }
                        
                    case "3":
                    // Big healing potion 
                        if (UserInventory.contains(Big_Health_Potion)) {
                            clear();
                            if (Player_Health >= 76){
                                debugFunction("You can't increase your health past 100");
                            }else{
                                debugFunction("Your health has been increased by 25 points");
                                UserInventory.remove(Big_Health_Potion);
                                Player_Health += 25;
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            }
                            break;
                        }
                        
                    case "4":
                    // strength object
                        if (UserInventory.contains(Strength_token)) {
                            clear();
                            debugFunction("Your strength has been increased by 1 point");
                            UserInventory.remove(Strength_token);
                            Player_Strength += 1;
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            break;
                        }

                    case "5":
                        if (UserInventory.contains(Speedy_Pills)) {
                            clear();
                            debugFunction("Your agility has been increased by 1 point");
                            UserInventory.remove(Speedy_Pills);
                            agility += 1;
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            break;
                        }
                        
                    case "6":
                        if (UserInventory.contains(Mysterious_Potion)) {
                            clear();
                            System.out.print(".");
                            pause(500);
                            System.out.print(".");
                            UserInventory.remove(Mysterious_Potion);
                            pause(500);
                            System.out.print(".");
                            Player_Health -= 50;
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            pause(500);
                            if (Player_Health <= 0) {
                                Player_Health = 0;
                                deletefile(gui);
                                throw new RuntimeException();
                            }
                            break;
                        }
                        
                    case "7":
                        if (UserInventory.contains(Lucky_Clover)) {
                            clear();
                            debugFunction("Your luck has been increased by 1 point");
                            UserInventory.remove(Lucky_Clover);
                            Player_luck += 1;
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            break;
                        }
                        
                    case "8":
                        if (UserInventory.contains(Dodge_Tonic)) {
                            clear();
                            debugFunction("Your dodges have increased by 3 points");
                            UserInventory.remove(Dodge_Tonic);
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            Dodges += 3;
                        }
                        break;

                    case "10":
                        if (UserInventory.contains(Soap)) {
                            clear();
                            debugFunction("Your inventory is slightly cleaner");
                            UserInventory.remove(Soap);
                            break;
                        }
                    case "":
                        break;
                    default:
                        while (!(user_choice.equals("1")||user_choice.equals("2")||user_choice.equals("3")||user_choice.equals("4")||user_choice.equals("5")
                        ||user_choice.equals("6")||user_choice.equals("7")||user_choice.equals("8")||user_choice.equals("9")||user_choice.equals("10")
                        ||user_choice.equals(""))){
                            clear();
                            debugFunction("You don't have that item");
                            debugFunction("Choose an item from your inventory to use or press 'enter' to close it:");
                            System.out.println("");
                            for (int i = 0; i < UserInventory.size(); i++) {
                                debugFunction("[" + UserInventory.get(i).getidentification_number() + "] " + UserInventory.get(i).getobject_name());
                            }
                            System.out.println("");
                            user_choice = scan.nextLine();
                        }
                }
            }


            //!END OF INVENTORY


            else{
                
                escape_probability = rand.nextInt(4);
                if (escape_probability <= Player_luck) {
                    debugFunction("You successfully managed to escape.");
                    user_escape = true;
                    pause(2000);
                    
                }
                else{
                    if(Dodges >= 1){
                        debugFunction("You dodged an attack from the monster");
                    }else{
                        debugFunction("The " + Monster.getMonster_name() + " attacked you while you were trying to escape");
                        if (damage_dealt < 2){
                            debugFunction("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage point");
                        }else{
                            debugFunction("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage points");
                        }
                    }
                    
                    
                    for (int i = 1; i <= Monster.getAgility(); i++){
                        
                        if (i >= 2) {
                            if(Dodges >= 1){
                                debugFunction("You dodged an attack from the monster");
                            }else{
                                debugFunction("The monster managed to make another attack due its high agility");
                                damage_dealt = Monster.getMinStrength();
                                damage_dealt += rand.nextInt(Monster.getMaxStrength() - Monster.getMinStrength());
                                Player_Health -= damage_dealt;
                                if (damage_dealt < 2){
                                    debugFunction("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage point");
                                }else{
                                    debugFunction("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage points");
                                }
                                
                                deletefile(gui);
                                damage(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                pause(1000);
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                        
                                debugFunction("Your health is at: " + Player_Health);
                                System.out.println("");
                                damage_dealt = 0;
                                if(nurse_on){

                                }else{
                                    if (Player_Health <= 0) {
                                        Player_Health = 0;
                                        deletefile(gui);
                                        throw new RuntimeException();
                                    }
                                }
                            }
                        }
                    
                        
                    }
                }
            }
            
            
        }while (user_escape == false && monster_Health != 0);
        user_escape = false;
        
        Player_Stats = new ArrayList<>();
        Player_Stats.add(Player_Health);
        Player_Stats.add(agility);
        Player_Stats.add(Player_luck);
        Player_Stats.add(Player_Strength);
        if (user_escape == true){
            Player_Stats.add(1);
        }else{
            Player_Stats.add(0);
        }
        

        return Player_Stats;
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!
    public static void idle(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_coins, int Dodges){
        File gui = new File("gui.txt");
        try {
            FileWriter writer = new FileWriter(gui, true);
            writer.write("Your name: " + name + "\n");
            writer.write("\n");
            writer.write("-------------------------------------------------------\n");                             
            writer.write("░░██████░░░░░░░░██████░░\n");                                   
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Health: "    + Player_Health +     "\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Agility: " + agility +  "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Luck: "      + Player_luck +       "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Strength: "  + Player_Strength +   "\n");                  
                writer.write("░░░░██░░░░░░░░░░░░██░░░░        Coins: "        + Player_coins +         "\n");                  
                writer.write("░░░░░░██░░░░░░░░██░░░░░░        Dodges: " + Dodges + "\n");                  
            writer.write("░░░░░░░░████████░░░░░░░░\n");      
            writer.write("-------------------------------------------------------\n"); 
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!
    public static void damage(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_coins, int Dodges){
        File gui = new File("gui.txt");
        try {
            FileWriter writer = new FileWriter(gui, true);
            writer.write("Your name: " + name + "\n");
            writer.write("\n");
            writer.write("-------------------------------------------------------\n");                             
            writer.write("░░██████░░░░░░░░██████░░\n");                                   
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Health: "    + Player_Health +     "\n");                  
                writer.write("░░░░░░░░█░░░░░░█░░░░░░░░        Agility: " + agility +  "\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Luck: "      + Player_luck +       "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Strength: "  + Player_Strength +   "\n");                  
                writer.write("░░░░░░░░████████░░░░░░░░        Coins: "        + Player_coins +         "\n");                  
                writer.write("░░░░░░░░██░░░░██░░░░░░░░        Dodges: " + Dodges + "\n");                  
            writer.write("░░░░░░░░████████░░░░░░░░\n");      
            writer.write("-------------------------------------------------------\n"); 
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!
    public static void start_screen(){
        File gui = new File("gui.txt");
        try {
            FileWriter writer = new FileWriter(gui, true);
            writer.write("                                       /\\                               \n");
            writer.write("                                  /\\  //\\\\                            \n");
            writer.write("                           /\\    //\\\\///\\\\\\        /\\                    \n");
            writer.write("                          //\\\\  ///\\" + "/" + "///\\\\\\\\  /\\  //\\\\                   \n");
            writer.write("             /\\          /  ^ \\/^ ^/^  ^  ^ \\/^ \\/  ^ \\                  \n");
            writer.write("            / ^\\    /\\  / ^   /  ^/ ^ ^ ^   ^\\ ^/  ^^  \\                 \n");
            writer.write("           /^   \\  / ^\\/ ^ ^   ^ / ^  ^    ^  \\/ ^   ^  \\       _        \n");
            writer.write("          /  ^ ^ \\/^  ^\\ ^ ^ ^   ^  ^   ^   ____  ^   ^  \\     /|\\       \n");
            writer.write("         / ^ ^  ^ \\ ^  _\\___________________|  |_____^ ^  \\   /|||\\      \n");
            writer.write("        / ^^  ^ ^ ^\\  /______________________________\\ ^ ^ \\ /|||||\\     \n");
            writer.write("       /  ^  ^^ ^ ^  /________________________________\\  ^  /|||||||\\    \n");
            writer.write("      /^ ^  ^ ^^  ^    ||___|___||||||||||||___|__|||      /|||||||||\\   \n");
            writer.write("     / ^   ^   ^    ^  ||___|___||||||||||||___|__|||          | |       \n"); 
            writer.write("    / ^ ^ ^  ^  ^  ^   ||||||||||||||||||||||||||||||oooooooooo| |ooooooo\n");
            writer.write("    ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n");
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!
    public static void village(){
        File gui = new File("gui.txt");
        try {
            FileWriter writer = new FileWriter(gui, true);
            writer.write("                                     _ \n");
            writer.write("                                    / \\ \n");
            writer.write(" _____        ______   ____________/ o \\/\\_________    ___________\n");
            writer.write("|o o o|_______|    |___|               | | # # #  |____|o o o o  |  /\\ \n");
            writer.write("|o o o|  * * *|: ::|. .|               |o| # # #  |. . |o o o o  | //\\\\ \n");
            writer.write("|o o o|* * *  |::  |. .| []  []  []  []|o| # # #  |. . |o o o o  | ((|))\n");
            writer.write("|o o o|**  ** |:  :|. .| []  []  []    |o| # # #  |. . |o o o o  | ((|))\n");
            writer.write("|_[]__|__[]___|_||_|__<|____________;;_|_|___/\\___|_.|_|____[]___|   |\n");
            writer.write("-----------------------------------------------------------------------\n");
            writer.write("  .          '      .     '      .          '       .     '     .      \n");
            writer.write("-----------------------------------------------------------------------\n");
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!
    public static void dungeons(){
        File gui = new File("gui.txt");
        try {
            FileWriter writer = new FileWriter(gui, true);
            writer.write("     __________________________________________________________  \n");
            writer.write("   / |     -_-                                             _-  |\\ \n"); 
            writer.write("  /  |_-_- _                                         -_- _-   -| \\ \n");   
            writer.write(" |   |                            _-  _--                      | \n");
            writer.write(" |   |                                                         |\n");
            writer.write(" |   |      .-'````````'.                   .-'||```||'-.      |\n");
            writer.write(" |   |    .` |           `.               .;|  ||   ||  ||.    |     \n");     
            writer.write(" |   |   /   |             \\             / ||  ||   ||  || \\   |\n");
            writer.write(" |   |  |    |              |     _-    |  ||  ||   ||  ||  |  |\n");
            writer.write(" |   |  |    |              |           |  ||  ||   ||  ||  |  |\n");
            writer.write(" |   |  |    |              |           |  ||  ||   ||  ||  |  |\n");
            writer.write(" |   |  |    |              |           |  ||  ||   ||  ||  |  |\n");
            writer.write(" |   |  |    |______________|           |__||__||___||__||__|  |  \n");
            writer.write(" |   |  |   /  __     -     |           |  ||  ||   ||  ||  |  |\n");
            writer.write(" |   |  |  / __            -|        -  |  ||  ||   ||  ||  |  |\n");
            writer.write(" |   |  | /        __-- _   |   _- _ -  |  ||  ||   ||  ||  |  |\n");
            writer.write(" |   |__|/__________________|___________|__\\/__\\/___\\/__\\/__|__|\n");
            writer.write(" |  /                                             _ -           \\ \n"); 
            writer.write(" | /   -_- _ -             _- _---                       -_-  -_ \\ \n");
            writer.write(" |/_______________________________________________________________\\ \n");
            
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //*DONE!!!!!!!!!!
    public static String village_square(Boolean searched_coins, List<InventoryObject> UserInventory){
        Scanner scan = new Scanner(System.in);
        String choice;
        clear();
        debugFunction("You find yourself in the village square");
        debugFunction("Do you:");
        debugFunction("[1] Enter the Inn");
        debugFunction("[2] Go to the Archery Minigame");
        debugFunction("[3] Enter the Items shop");
        if (searched_coins){
            debugFunction("[4] Visit the Castle");
            if (UserInventory.size() > 0){
                debugFunction("[5] Open your inventory");
                choice = scan.nextLine();
                while(!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") 
                || choice.equals("5"))){
                    clear();
                    debugFunction("Please select a valid input");
                    debugFunction("Do you:");
                    debugFunction("[1] Enter the Inn");
                    debugFunction("[2] Go the Archery Minigame");
                    debugFunction("[3] Enter the Items shop");
                    debugFunction("[4] Visit the Castle");
                    debugFunction("[5] Open your inventory");
                    choice = scan.nextLine();
                }
            }else{
                choice = scan.nextLine();
                while(!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4"))){
                    clear();
                    debugFunction("Please select a valid input");
                    debugFunction("Do you:");
                    debugFunction("[1] Enter the Inn");
                    debugFunction("[2] Go to the Archery Minigame");
                    debugFunction("[3] Enter the Items shop");
                    debugFunction("[4] Visit the Castle");
                    choice = scan.nextLine();
                }
            }
            
            
           
        }else{
            debugFunction("[4] Investigate the trail of coins");
            debugFunction("[5] Visit the Castle");
            if (UserInventory.size() > 0){
                debugFunction("[6] Open your inventory");
                choice = scan.nextLine();
                while(!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") 
                || choice.equals("5")|| choice.equals("6"))){
                    clear();
                    debugFunction("Please select a valid input");
                    debugFunction("Do you:");
                    debugFunction("[1] Enter the Inn");
                    debugFunction("[2] Go the Archery Minigame");
                    debugFunction("[3] Enter the Items shop");
                    debugFunction("[4] Investigate the trail of coins");
                    debugFunction("[5] Visit the Castle");
                    debugFunction("[6] Open your inventory");
                    choice = scan.nextLine();
                }
            }else{
                choice = scan.nextLine();
                while(!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") 
                || choice.equals("5"))){
                    clear();
                    debugFunction("Please select a valid input");
                    debugFunction("Do you:");
                    debugFunction("[1] Enter the Inn");
                    debugFunction("[2] Go the Archery Minigame");
                    debugFunction("[3] Enter the Items shop");
                    debugFunction("[4] Investigate the trail of coins");
                    debugFunction("[5] Visit the Castle");
                    choice = scan.nextLine();
                }
            }
           
        }
        
        return choice;
    }


    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //*DONE!!!!!!!!!!
    public static void title_screen() {
        System.out.println("___________.__.__  .__    .____    .__  _____           _____                .__        ");
        System.out.println("\\__    ___/|__|  | |  |   |    |   |__|/ ____\\____     /  _  \\    _________  |__| ____  ");
        System.out.println("  |    |   |  |  | |  |   |    |   |  \\   __\\/ __ \\   /  /_\\  \\  / ___\\__  \\ |  |/    \\ ");
        System.out.println("  |    |   |  |  |_|  |__ |    |___|  ||  | \\  ___/  /    |    \\/ /_/  > __ \\|  |   |  \\");
        System.out.println("  |____|   |__|____/____/ |_______ \\__||__|  \\___  > \\____|__  /\\___  (____  /__|___|  /");
        System.out.println("                                  \\/             \\/          \\//_____/     \\/        \\/ ");

    }
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void story() throws Exception{
        try{
            clear();
            Scanner scan = new Scanner(System.in);
            File gui = new File("gui.txt");
            FileWriter writer = new FileWriter(gui, true);
            Random rand = new Random();
            
            int escape_probability = 0;
            boolean user_escape = false;
            int monster_attacks = 0;
            int monster_Health = 0;
            boolean nurse_on = false;

            int Player_coins = 0;
            int Player_Health = 100;
            Integer Player_Strength = 5;
            Integer agility = 1;
            int Player_luck = 0;
            int damage_dealt = 0;
            int Dodges = 0;
            String Sword_status = "";
            
            
            // All monsters Stats
            Foes Leaf_Monster = new Foes("Leaf Monster",1, 3, 2,10);
            Foes Wolf = new Foes("Wolf",4, 8, 1, 6);
            Foes Mud_Golem = new Foes("Mud Golem",4, 8, 1, 15);
            Foes Dagger_Bandit = new Foes("Dagger Bandit",7, 12, 1, 20);
            Foes Sword_Bandit = new Foes("Sword Bandit",10, 17, 1, 25);
            Foes Bow_bandit = new Foes("Bow bandit",3, 6, 5, 30);
            Foes Bandit_Boss = new Foes("Bandit Boss",5, 20, 1, 40);
            Foes Royal_Guard = new Foes("Royal Guard", 8, 25, 2, 40);
            Foes Troll = new Foes("Troll",7, 9, 1, 50);
            Foes Ciclops = new Foes("Ciclops",10, 12, 1, 40);
            Foes Goblin = new Foes("Goblin gang",7, 12, 3, 24);
            Foes Ogre = new Foes("Ogre",12, 15, 2, 50);
            Foes Nurse = new Foes("Nurse",20, 30, 1, 60);

            // Inventory objects prizes and names

            // change the names and objects if you got good ideas for new objects or names but remeber you will also need to change them on the battle_System function

            InventoryObject Small_Health_Potion = new InventoryObject("Small Healing Potion", "1", 10 );
            InventoryObject Medium_Health_Potion = new InventoryObject("Medium Healing Potion", "2", 20 );
            InventoryObject Big_Health_Potion = new InventoryObject("Big Healing Potion", "3", 30 );
            InventoryObject Strength_token = new InventoryObject("Strength Token", "4", 30 );
            InventoryObject Speedy_Pills = new InventoryObject("Speedy Pills", "5", 40 );
            InventoryObject Mysterious_Potion = new InventoryObject("Mysterious Potion", "6", 15 );
            InventoryObject Lucky_Clover = new InventoryObject("Lucky Clover", "7", 50 );
            InventoryObject Dodge_Tonic = new InventoryObject("Dodge Tonic", "8", 20 );
            InventoryObject Cactus_Sword = new InventoryObject("Cactus Sword", "9", 20 );
            InventoryObject Soap = new InventoryObject("Soap", "10", 5 );
            InventoryObject Bow = new InventoryObject("Bow", "11", 25 );
            
            // a list with all the objects
            ArrayList<InventoryObject> AllObjects = new ArrayList<>(Arrays.asList(Small_Health_Potion,Medium_Health_Potion,Big_Health_Potion,Strength_token,
            Speedy_Pills,Mysterious_Potion,Lucky_Clover,Dodge_Tonic,Cactus_Sword,Soap, Bow));
            
            // a list with all the objects the user have
            List<InventoryObject> UserInventory = new ArrayList<>();
            ArrayList<String> Weapons = new ArrayList<>();
            List<Integer> Player_Stats = new ArrayList<>();
            
            clear();
            deletefile(gui);
            System.out.println("Please open the gui.txt file before continuing");
            System.out.println("");
            System.out.println("Press any key to continue:");
            String Choice = scan.nextLine();
            
            // ! START OF CABIN
            
            clear();
            deletefile(gui);
            start_screen();

            debugFunction("You wake up in a cabin in the middle of the woods, your head is ");
            debugFunction("bleeding and a man is treating your wounds.");
            debugFunction("The man says in a raspy voice: 'You recieved quite a beating in");
            debugFunction("those woods young one, what may your name be?");
            System.out.println("");
            System.out.print("Your name: ");
            String name = scan.nextLine();
            System.out.println("");

            debugFunction(name + "?, huh, thats a nice name");
            debugFunction("Its too dangerous to go into the forest on your own.");
            debugFunction("I have a spare wooden sword,");
            debugFunction("you should take it just in case something happens out there.");
            System.out.println("");
            debugFunction("YOU HAVE NOW UNLOCKED THE WOODEN SWORD WEAPON");
            System.out.println("");
            Sword_status = "Wooden";
            Weapons.add(Sword_status);
            
            //Weapons.add(Sword_status);
            pause(1000);
            debugFunction("Now get out of my house, I can't take care of you forever!'");
                
            pause(2000);
            clear();

            //! END OF CABIN


            //! START OF FOREST

            deletefile(gui);
            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);

            debugFunction("You get out of the house looking at the bright sun as you walk towards the forest.");
            debugFunction("You slowly walk through the forest when you encounter a leaf monster");
                
            //! First monster
            Player_Stats = battle_system(Leaf_Monster, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  
            Small_Health_Potion,  Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover, 
            Dodge_Tonic,  Cactus_Sword,  Soap, Dodges, Weapons, Player_Stats, nurse_on);
            
                Player_Health = Player_Stats.get(0);
                agility = Player_Stats.get(1);
                Player_luck = Player_Stats.get(2);
                Player_Strength = Player_Stats.get(3);
                if (Player_Stats.get(4) == 0) {
                Player_coins += (int)Leaf_Monster.getHealth()/2;
            }
            deletefile(gui);
            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);


            debugFunction("After the encounter with the Leaf Monster, " + name + " found themselves infront");
            debugFunction("of a savage wolf who came due to the commotion caused by your battle.");
            
            //! Second monster
            Player_Stats = battle_system(Wolf, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  
            Small_Health_Potion,  Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  
            Dodge_Tonic,  Cactus_Sword,  Soap, Dodges, Weapons, Player_Stats, nurse_on);
        
            Player_Health = Player_Stats.get(0);
            agility = Player_Stats.get(1);
            Player_luck = Player_Stats.get(2);
            Player_Strength = Player_Stats.get(3);
            if (Player_Stats.get(4) == 0) {
                Player_coins += (int)Wolf.getHealth()/2;
            }
            

            debugFunction("After the encounter with the wolf, " + name + " found themselves extremely tired, you take nap...");
                
            deletefile(gui);
            sleeping(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
            pause(4000);
            deletefile(gui);
            clear();
            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                
            debugFunction("You suddently woke up hearing screams in the middle of the now completely dark forest.");

            debugFunction("Do you: [1] Investigate, [2] Continue sleeping");
            String choice = scan.nextLine();
            System.out.println("");
            clear();

            while (!choice.strip().toLowerCase().equals("investigate") && !choice.strip().toLowerCase().equals("sleeping") && !choice.strip().toLowerCase().equals("1") && !choice.strip().toLowerCase().equals("2")&& !choice.strip().toLowerCase().equals("sleep")&& !choice.strip().toLowerCase().equals("continuesleeping")) {
                debugFunction("You need to choose either to escape or to fight");
                System.out.println("");
                debugFunction("Do you: [1] Investigate, [2] Continue sleeping");
                choice = scan.nextLine();
                clear();
            }

            // //! THIRD MONSTER
            if (choice.strip().toLowerCase().equals("1") || choice.strip().toLowerCase().equals("investigate")){
                debugFunction("You find a Mud Golem attacking the man that saved you earlier");
                Player_Stats = battle_system(Mud_Golem, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion,  
                Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  Cactus_Sword,  Soap, Dodges, Weapons, 
                Player_Stats, nurse_on);
            
                    Player_Health = Player_Stats.get(0);
                agility = Player_Stats.get(1);
                Player_luck = Player_Stats.get(2);
                Player_Strength = Player_Stats.get(3);
                if (Player_Stats.get(4) == 0) {
                    Player_coins += (int)Mud_Golem.getHealth()/2;
                
                    debugFunction("The man who was almost killed decides to give you an iron sword in gratitude. ");
                    Sword_status = "Iron";
                    Weapons.set(0, Sword_status);
                    System.out.println("");
                    debugFunction("YOUR WOODEN SWORD HAS BEEN UPGRADED TO AN IRON SWORD");
                    System.out.println("");
                    Player_Strength += 8;
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    debugFunction("After that match with the golem, you continue sleeping.");

                } 
                else{
                    debugFunction("After managing to escape the golem, you continue sleeping.");
                }
                
                deletefile(gui);
                sleeping(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                debugFunction("until sun rise and continue your quest.");   
                System.out.println("");
                debugFunction("SLEEPING HAS HEALED YOU BY 15 POINTS");
                Player_Health += 15;
                deletefile(gui);
                sleeping(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                System.out.println("");
            
            }else{

            deletefile(gui);
            sleeping(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
            debugFunction("You continue sleeping until sun rise and continue your quest.");
            System.out.println("");
            debugFunction("SLEEPING HAS HEALED YOU BY 15 POINTS");
            Player_Health += 15;
            deletefile(gui);
            sleeping(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
            System.out.println("");
            
            }

            // //!END OF FOREST


            //! START OF VILLAGE
            


            pause(3000);
            Boolean searched_coins = false;
            Boolean bow_broke = false;
            Boolean sword_broke = false;
            Boolean square = true;
            Boolean boss = true;
            deletefile(gui);
            village();
            clear();
            debugFunction("During your adventure, you encounter a village and decide to stay for a moment.");
            
            while(square){
                deletefile(gui);
                village();
                if (sword_broke == true && bow_broke == true && searched_coins == true && boss == true){
                    clear();
                    deletefile(gui);
                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                    debugFunction("A large man with a cape approaches you");
                    debugFunction("Man - So, youre the one who's been wrecking my crew");
                    debugFunction("Man - Well, prepare to fight, cause you've got it coming to ya!");
                    Player_Stats = battle_system(Bandit_Boss, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory, 
                    Small_Health_Potion,  Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  
                    Cactus_Sword,  Soap, Dodges, Weapons, Player_Stats, nurse_on);
                    clear();
                    boss = false;
                }
                switch (village_square(searched_coins, UserInventory)){
                    case "1":
                    if (sword_broke){
                        clear();
                        deletefile(gui);
                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                        debugFunction("Hello traveller");
                        debugFunction("Would you like to rest in one of my comfy beds?");
                        debugFunction("They recover 10 health and give a random effect");
                        debugFunction("The price is 20 coins [1] Yes, [2] No");
                        choice = scan.nextLine();
                        while (!(choice.equals("1") || choice.equals("2"))){
                            clear();
                            debugFunction("Please select a valid input");
                            debugFunction("Would you like to rest in one of my comfy beds?");
                            debugFunction("They recover 10 health and give a random effect");
                            debugFunction("The price is 20 coins [1] Yes, [2] No");
                            choice = scan.nextLine();
                        }
                        if (choice.equals("1")) {
                            if (Player_coins < 30){
                                    clear();
                                    debugFunction("Sorry, but it seems you don't have enough coins");
                                    System.out.println("");
                            }else{
                                if(Player_Health >= 91){
                                    clear();
                                    debugFunction("Im sorry, but you cant get your health past 100 im afraid");
                                    pause(2000);
                                }else{
                                    clear();
                                    debugFunction("You take a nap in the Inn");
                                    deletefile(gui);
                                    sleeping(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    pause(4000);
                                    deletefile(gui);
                                    clear();
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    System.out.println("");
                                    debugFunction("You recovered 10 health");
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    int random = rand.nextInt(1,4);
                                    if(random == 1){
                                        debugFunction("Your Strength has increased by 1 point");
                                        Player_Strength += 1;
                                        deletefile(gui);
                                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    }else if (random == 2){
                                        debugFunction("Your Luck has increased by 1 point");
                                        Player_luck += 1;
                                        deletefile(gui);
                                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    }else if (random == 3){
                                        debugFunction("Your Agility has increased by 1 point");
                                        agility += 1;
                                        deletefile(gui);
                                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    }
                                }
                            }
                            pause(2000);
                            clear();
                            debugFunction("Hope to see you again sometime");
                            pause(2000);
                        }
                    }else{
                        clear();
                        debugFunction("You find an Inn Keeper being Assaulted by a Bandit with a large sword");
                        debugFunction("Inn Keeper - Help! Somebody help!");
                        debugFunction("Do you help? [1] Yes, [2] No");
                        choice = scan.nextLine();
                        while (!(choice.equals("1") || choice.equals("2"))){
                            clear();
                            debugFunction("Please select a valid input");
                            debugFunction("Do you help? [1] Yes, [2] No");
                            choice = scan.nextLine();
                        }
                        if (choice.equals("1")) {
                            clear();
                            debugFunction("Bandit - Oh? What do we have here?");
                            debugFunction("Bandit - A hero? Well, come at me!");
                            Player_Stats = battle_system(Sword_Bandit, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  
                            Small_Health_Potion,  Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  
                            Cactus_Sword,  Soap, Dodges, Weapons, Player_Stats, nurse_on);
                            Player_Health = Player_Stats.get(0);
                            agility = Player_Stats.get(1);
                            Player_luck = Player_Stats.get(2);
                            Player_Strength = Player_Stats.get(3);
                            pause(2000);
                            if (Player_Stats.get(4) == 0){
                                Player_coins += (int)Sword_Bandit.getHealth()/2;
                                sword_broke = true;
                                clear();
                                debugFunction("Thank you so much traveler, thanks to you, my Inn is safe");
                                debugFunction("And that bandit wont be bothering me anymore");
                                debugFunction("You can pass by my Inn anytime youd like to rest");
                                pause(2000);
                            }
                        }

                    }
                    break;
                    

                    //! ARCHERY GAME
                    case "2":
                    if (bow_broke){
                        clear();
                        deletefile(gui);
                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                        int as = 0;
                        int speed = 100;
                        debugFunction("Hello young one, and welcome to my famous archery minigame!!");
                        debugFunction("The rules are simple: ");
                        debugFunction("Press 'enter' when the target is on top of your bow");
                        debugFunction("Hit it enough times and you might win coins!");
                        debugFunction("Would you like to play? The price is 30 coins");
                        debugFunction("[1] Yes  [2] No");
                        choice = scan.nextLine();
                        while (!(choice.equals("1") || choice.equals("2"))){
                            clear();
                            debugFunction("Please select a valid input");
                            debugFunction("Would you like to play? The price is 30 coins");
                            debugFunction("[1] Yes  [2] No");
                            choice = scan.nextLine();
                        }
                        while(true){
                            if(choice.equals("1")){
                                if (Player_coins < 30){
                                    clear();
                                    debugFunction("Sorry, but it seems you don't have enough coins");
                                    System.out.println("");
                                    pause(2000);
                                }else{
                                    Player_coins -= 30;
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    clear();
                                    while (archery(speed)){
                                        
                                        if (speed > 10){
                                            speed -= 10;
                                        }else{
                                            speed /= 2;
                                        }
                                        as += 1;
                                    }
                                    clear();
                                    debugFunction("Oops, seems like you missed that one");
                                    if (as > 3){
                                        Player_coins += ((as-3)*10);
                                        debugFunction("On the bright side, you won " + ((as-3)*10) + " coins");
                                    }
                                    System.out.println("");
                                }
                                
                            }
                            clear();
                            debugFunction("Hope to see you again sometime");
                            pause(2000);
                            break;
                        }
                        break;
                    }else{
                        deletefile(gui);
                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                        clear();
                        debugFunction("You enter the minigame when you find a bandit shooting arrows everywhere");
                        Player_Stats = battle_system(Bow_bandit, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion, 
                        Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  Cactus_Sword,  Soap, Dodges, Weapons, 
                        Player_Stats, nurse_on);
                        Player_Health = Player_Stats.get(0);
                        agility = Player_Stats.get(1);
                        Player_luck = Player_Stats.get(2);
                        Player_Strength = Player_Stats.get(3);
                        pause(2000);
                        if (Player_Stats.get(4) == 0){
                            Player_coins += (int)Bow_bandit.getHealth()/2;
                            bow_broke = true;
                            clear();
                            debugFunction("Thank you so much traveler, thanks to you, my minigame is safe");
                            debugFunction("And that bandit wont be bothering me anymore");
                            debugFunction("You can pass by my shop anytime youd like, and, dont worry about buying");
                            debugFunction("a bow, I'll lend you one");
                            pause(2000);
                        }
                        break;
                    }
                    

                    //! ITEM SHOP
                    case "3":
                    clear();

                    Player_coins = shop(AllObjects, UserInventory, Small_Health_Potion, Medium_Health_Potion, Big_Health_Potion, 
                    Strength_token, Speedy_Pills, Mysterious_Potion, Lucky_Clover, Dodge_Tonic, Cactus_Sword, Soap, Bow, Player_coins, 
                    Weapons, gui, name, Player_Health, agility, Player_luck, Player_Strength, Dodges);

                    break;

                    //! BACK ALLEY
                    case "4":
                    if (searched_coins){
                        clear();
                        debugFunction("This decision is final and irreversible");
                        debugFunction("Would you like to continue?");
                        debugFunction("[1] Yes      [2] No");
                        choice = scan.nextLine();
                        while (!(choice.strip().toLowerCase().equals("1") || choice.strip().toLowerCase().equals("2"))) {
                            clear();
                            debugFunction("Please select a valid input");
                            debugFunction("This decision is final and irreversible");
                            debugFunction("Would you like to continue?");
                            debugFunction("[1] Yes      [2] No");
                            choice = scan.nextLine();
                        }
                        if (choice.equals("1")) {
                            square = false;
                            break;
                        }
                        break;
                    }else{
                        clear();
                        debugFunction("You follow a trail of coins leading to a dark alley");
                        debugFunction("In the alley you find a bandit searching through someone's wallet");
                        System.out.println("");
                        debugFunction("Bandit - Hey you, whatcha doin over there?");
                        debugFunction("Bandit - Come closer, I wont bite");
                        System.out.println("");
                        debugFunction("Do you: [1] Get closer, [2] Escape");
                        choice = scan.nextLine();
                        while (!(choice.strip().toLowerCase().equals("1") || choice.strip().toLowerCase().equals("2"))) {
                            clear();
                            debugFunction("Please select a valid input");
                            debugFunction("Do you: [1] Get closer, [2] Escape");
                            choice = scan.nextLine();
                        }
                        clear();
                        if(choice.equals("1")){
                            debugFunction("You get close");
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                            debugFunction("Bandit - Yeah, thats right");
                            debugFunction("Bandit - Just in range for me to BITE");
                            Player_Stats = battle_system(Dagger_Bandit, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  
                            Small_Health_Potion,  Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  
                            Cactus_Sword,  Soap, Dodges, Weapons, Player_Stats, nurse_on);
                            
                            Player_Health = Player_Stats.get(0);
                            agility = Player_Stats.get(1);
                            Player_luck = Player_Stats.get(2);
                            Player_Strength = Player_Stats.get(3);
                            pause(2000);
                            if (Player_Stats.get(4) == 0){
                                Player_coins += (int)Dagger_Bandit.getHealth()/2;
                                searched_coins = true;
                            }
                            
                        }
                        break;
                    }

                    //! CASTLE
                    case "5":
                    if (UserInventory.size() > 0){
                        clear();
                        debugFunction("Choose an item from your inventory to use or press 'enter' to close it:");
                        System.out.println("");
                        for (int i = 0; i < UserInventory.size(); i++) {
                            debugFunction("[" + UserInventory.get(i).getidentification_number() + "] " + UserInventory.get(i).getobject_name());
                        }
                        System.out.println("");

                        choice = scan.nextLine();

                        switch (choice) {
                            case "1":
                            // small healing potion
                                if (UserInventory.contains(Small_Health_Potion)) {
                                    clear();
                                    if (Player_Health >= 91){
                                        debugFunction("You can't increase your health past 100");
                                    }else{
                                        debugFunction("Your health has been increased by 10 points");
                                        UserInventory.remove(Small_Health_Potion);
                                        Player_Health += 10;
                                        deletefile(gui);
                                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    }
                                    pause(2000);
                                    break;
                                }
                                
                            case "2":
                            // medium healing potion  
                                if (UserInventory.contains(Medium_Health_Potion)) {
                                    clear();
                                    if (Player_Health >= 86){
                                        debugFunction("You can't increase your health past 100");
                                    }else{
                                        debugFunction("Your health has been increased by 15 points");
                                        UserInventory.remove(Medium_Health_Potion);
                                        Player_Health += 15;
                                        deletefile(gui);
                                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    }
                                    pause(2000);
                                    break;
                                }
                                
                            case "3":
                            // Big healing potion 
                                if (UserInventory.contains(Big_Health_Potion)) {
                                    clear();
                                    if (Player_Health >= 76){
                                        debugFunction("You can't increase your health past 100");
                                    }else{
                                        debugFunction("Your health has been increased by 25 points");
                                        UserInventory.remove(Big_Health_Potion);
                                        Player_Health += 25;
                                        deletefile(gui);
                                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    }
                                    pause(2000);
                                    break;
                                }
                                
                            case "4":
                            // strength object
                                if (UserInventory.contains(Strength_token)) {
                                    clear();
                                    debugFunction("Your strength has been increased by 1 point");
                                    UserInventory.remove(Strength_token);
                                    Player_Strength += 1;
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    pause(2000);
                                    break;
                                }

                            case "5":
                                if (UserInventory.contains(Speedy_Pills)) {
                                    clear();
                                    debugFunction("Your agility has been increased by 1 point");
                                    UserInventory.remove(Speedy_Pills);
                                    agility += 1;
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    pause(2000);
                                    break;
                                }
                                
                            case "6":
                                if (UserInventory.contains(Mysterious_Potion)) {
                                    clear();
                                    debugFunction(".");
                                    pause(500);
                                    debugFunction(".");
                                    UserInventory.remove(Mysterious_Potion);
                                    pause(500);
                                    debugFunction(".");
                                    Player_Health -= 50;
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    pause(500);
                                    pause(2000);
                                    if (Player_Health <= 0) {
                                        Player_Health = 0;
                                        deletefile(gui);
                                        throw new RuntimeException();
                                    }
                                    break;
                                }
                                
                            case "7":
                                if (UserInventory.contains(Lucky_Clover)) {
                                    clear();
                                    debugFunction("Your luck has been increased by 1 point");
                                    UserInventory.remove(Lucky_Clover);
                                    Player_luck += 1;
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    pause(2000);
                                    break;
                                }
                                
                            case "8":
                                if (UserInventory.contains(Dodge_Tonic)) {
                                    clear();
                                    debugFunction("Your dodges have increased by 3 points");
                                    UserInventory.remove(Dodge_Tonic);
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                    Dodges += 3;
                                    pause(2000);
                                }
                                break;

                            case "10":
                                if (UserInventory.contains(Soap)) {
                                    clear();
                                    debugFunction("Your inventory is slightly cleaner");
                                    UserInventory.remove(Soap);
                                    pause(2000);
                                    break;
                                }
                            case "":
                                break;
                            default:
                                while (!(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5")
                                ||choice.equals("6")||choice.equals("7")||choice.equals("8")||choice.equals("9")||choice.equals("10")
                                ||choice.equals(""))){
                                    clear();
                                    debugFunction("You don't have that item");
                                    debugFunction("Choose an item from your inventory to use or press 'enter' to close it:");
                                    System.out.println("");
                                    for (int i = 0; i < UserInventory.size(); i++) {
                                        debugFunction("[" + UserInventory.get(i).getidentification_number() + "] " + UserInventory.get(i).getobject_name());
                                    }
                                    System.out.println("");
                                    choice = scan.nextLine();
                                }
                        }
                    }else{
                        clear();
                        debugFunction("This decision is final and irreversible");
                        debugFunction("Would you like to continue?");
                        debugFunction("[1] Yes      [2] No");
                        choice = scan.nextLine();
                        while (!(choice.strip().toLowerCase().equals("1") || choice.strip().toLowerCase().equals("2"))) {
                            clear();
                            debugFunction("Please select a valid input");
                            debugFunction("This decision is final and irreversible");
                            debugFunction("Would you like to continue?");
                            debugFunction("[1] Yes      [2] No");
                            choice = scan.nextLine();
                        }
                        if (choice.equals("1")) {
                            square = false;
                            break;
                        }
                    }
                    

                    //! INVENTORY
                    case "6":
                    clear();
                    debugFunction("Choose an item from your inventory to use or press 'enter' to close it:");
                    System.out.println("");
                    for (int i = 0; i < UserInventory.size(); i++) {
                        debugFunction("[" + UserInventory.get(i).getidentification_number() + "] " + UserInventory.get(i).getobject_name());
                    }
                    System.out.println("");

                    choice = scan.nextLine();

                    switch (choice) {
                        case "1":
                        // small healing potion
                            if (UserInventory.contains(Small_Health_Potion)) {
                                clear();
                                if (Player_Health >= 91){
                                    debugFunction("You can't increase your health past 100");
                                }else{
                                    debugFunction("Your health has been increased by 10 points");
                                    UserInventory.remove(Small_Health_Potion);
                                    Player_Health += 10;
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                }
                                pause(2000);
                                break;
                            }
                            
                        case "2":
                        // medium healing potion  
                            if (UserInventory.contains(Medium_Health_Potion)) {
                                clear();
                                if (Player_Health >= 86){
                                    debugFunction("You can't increase your health past 100");
                                }else{
                                    debugFunction("Your health has been increased by 15 points");
                                    UserInventory.remove(Medium_Health_Potion);
                                    Player_Health += 15;
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                }
                                pause(2000);
                                break;
                            }
                            
                        case "3":
                        // Big healing potion 
                            if (UserInventory.contains(Big_Health_Potion)) {
                                clear();
                                if (Player_Health >= 76){
                                    debugFunction("You can't increase your health past 100");
                                }else{
                                    debugFunction("Your health has been increased by 25 points");
                                    UserInventory.remove(Big_Health_Potion);
                                    Player_Health += 25;
                                    deletefile(gui);
                                    idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                }
                                pause(2000);
                                break;
                            }
                            
                            
                        case "4":
                        // strength object
                            if (UserInventory.contains(Strength_token)) {
                                clear();
                                debugFunction("Your strength has been increased by 1 point");
                                UserInventory.remove(Strength_token);
                                Player_Strength += 1;
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                pause(2000);
                                break;
                            }

                        case "5":
                            if (UserInventory.contains(Speedy_Pills)) {
                                clear();
                                debugFunction("Your agility has been increased by 1 point");
                                UserInventory.remove(Speedy_Pills);
                                agility += 1;
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                pause(2000);
                                break;
                            }
                            
                        case "6":
                            if (UserInventory.contains(Mysterious_Potion)) {
                                clear();
                                System.out.print(".");
                                pause(500);
                                System.out.print(".");
                                UserInventory.remove(Mysterious_Potion);
                                pause(500);
                                System.out.print(".");
                                Player_Health -= 50;
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                pause(500);
                                pause(2000);
                                if (Player_Health <= 0) {
                                    Player_Health = 0;
                                    deletefile(gui);
                                    throw new RuntimeException();
                                }
                                break;
                            }
                            
                        case "7":
                            if (UserInventory.contains(Lucky_Clover)) {
                                clear();
                                debugFunction("Your luck has been increased by 1 point");
                                UserInventory.remove(Lucky_Clover);
                                Player_luck += 1;
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                pause(2000);
                                break;
                            }
                            
                        case "8":
                            if (UserInventory.contains(Dodge_Tonic)) {
                                clear();
                                debugFunction("Your dodges have increased by 3 points");
                                UserInventory.remove(Dodge_Tonic);
                                deletefile(gui);
                                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins, Dodges);
                                Dodges += 3;
                                pause(2000);
                            }
                            break;

                        case "10":
                            if (UserInventory.contains(Soap)) {
                                clear();
                                debugFunction("Your inventory is slightly cleaner");
                                UserInventory.remove(Soap);
                                pause(2000);
                                break;
                            }
                        case "":
                            break;
                        default:
                            while (!(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5")
                            ||choice.equals("6")||choice.equals("7")||choice.equals("8")||choice.equals("9")||choice.equals("10")
                            ||choice.equals(""))){
                                clear();
                                debugFunction("You don't have that item");
                                debugFunction("Choose an item from your inventory to use or press 'enter' to close it:");
                                System.out.println("");
                                for (int i = 0; i < UserInventory.size(); i++) {
                                    debugFunction("[" + UserInventory.get(i).getidentification_number() + "] " + UserInventory.get(i).getobject_name());
                                }
                                System.out.println("");
                                choice = scan.nextLine();
                            }
                    }
                }
                clear();
            }

            //! END OF VILLAGE
            
            //! Start of dungeon
                
                clear();
                debugFunction("You approach the castle when you see the king sitting in his throne");
                debugFunction("King - We do not allow trespassers in our lands, take him away!");
                debugFunction("You awake up in a dark and small cell, only being able to see due to a small light passing through the bars.");
                debugFunction("You notice that next to you is a ciclops and a door which you think your able to lockpick.");
                
                debugFunction("Do you: [1] Approach the Ciclops, or [2] Lockpick the Door");
                choice = scan.nextLine();
                clear();
                
                while (!choice.equals("1") && !choice.equals("2") && !choice.equals("fight") && !choice.equals("lockpick")){
                    debugFunction("You need to choose to either [1] Fight the Ciclops, or [2] Lockpick the Door");
                    choice = scan.nextLine();
                    clear();
                }
                if (choice.toLowerCase().trim().equals("1") || choice.toLowerCase().trim().equals("fight") ) {
                    debugFunction("You decided to Figth the Ciclops");
                    Player_Stats = battle_system(Ciclops, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion,  
                    Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  Cactus_Sword,  Soap, Dodges, Weapons, 
                    Player_Stats, nurse_on);
                    
                    Player_Health = Player_Stats.get(0);
                    agility = Player_Stats.get(1);
                    Player_luck = Player_Stats.get(2);
                    Player_Strength = Player_Stats.get(3);
                    if (Player_Stats.get(4) == 0){
                        Player_coins += (int)Ciclops.getHealth()/2;
                        debugFunction("You decided to lockpick the door after killing the Ciclops");
                        pause(2000);
                        clear();
                    }
                    else{
                        debugFunction("You lockpick the door and get away from the ciclops");
                        pause(2000);
                        clear();
                    }
                }

                debugFunction("You managed to succesfully lockpick the door and escape the cell");
                pause(3000);
                debugFunction("After getting out of the cell you find yourself in a hall when you encounter a troll");
                Player_Stats = battle_system(Troll, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion,  
                Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  Cactus_Sword,  Soap, Dodges, Weapons, 
                Player_Stats, nurse_on);
                Player_Health = Player_Stats.get(0);
                agility = Player_Stats.get(1);
                Player_luck = Player_Stats.get(2);
                Player_Strength = Player_Stats.get(3);
                if (Player_Stats.get(4) == 0){
                    Player_coins += (int)Troll.getHealth()/2;
                }
                
                pause(2000);
                clear();
                debugFunction("After the fight with the troll,");
                debugFunction("you keep walking down the long hall with flickering lights and unsettling screams in the distance.");
                debugFunction("You manage to see a pack of goblins coming for you");
                Player_Stats = battle_system(Goblin, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion, 
                 Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  Cactus_Sword,  Soap, Dodges, Weapons, 
                 Player_Stats, nurse_on);
                Player_Health = Player_Stats.get(0);
                agility = Player_Stats.get(1);
                Player_luck = Player_Stats.get(2);
                Player_Strength = Player_Stats.get(3);
                if (Player_Stats.get(4) == 0){
                    Player_coins += (int)Goblin.getHealth()/2;
                }

                pause(2000);
                clear();

                debugFunction("Your head feels twisted, your mind is breaking, but you decide to keep walking down the narrow hall");
                debugFunction("Reaching the end of the hall you find a big room with an Ogre");
                Player_Stats = battle_system(Ogre, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion,  
                Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  Cactus_Sword,  Soap, Dodges, Weapons, 
                Player_Stats, nurse_on);
                    Player_Health = Player_Stats.get(0);
                    agility = Player_Stats.get(1);
                    Player_luck = Player_Stats.get(2);
                    Player_Strength = Player_Stats.get(3);
                    if (Player_Stats.get(4) == 0){
                        Player_coins += (int)Ogre.getHealth()/2;
                    }

                    pause(2000);
                    clear();
                    debugFunction("Your head burns, your eyes itch");
                    pause(2000);
                    clear();
                    debugFunction("Your throat is dry, your legs hurt");
                    pause(2000);
                    clear();
                    debugFunction("You lose all sense of balance, and fall to the ground");
                    pause(5000);
                    clear();


                //! END OF Dungeon 

                //! Start of real world

                Cactus_Sword.setName("Shard of glass");
                Bow.setName("Fish hook");
                Strength_token.setName("Steroids");
                Dodge_Tonic.setName("Olive Oil");
                Mysterious_Potion.setName("Cyanide");
                Speedy_Pills.setName("Sugar Pills");
                Small_Health_Potion.setName("Bandaid");
                Medium_Health_Potion.setName("Medicine");
                Big_Health_Potion.setName("Vaccine");
                Lucky_Clover.setName("Oak Leaf");
                Sword_status = "Scapel";
                Weapons.set(0, Sword_status);
                
                debugFunction("You wake up sitting in a white bed");
                debugFunction("Lights are around you and you are in a white jacket with a multitude of belts around your waist");
                debugFunction("A woman is white clothing approaches");
                debugFunction("??? - So, your the one whos been causing havoc all around town, well, the diagnosis says you ARE king of crazy");
                debugFunction("??? - But thats fine, I can treat you, its my job after all, now stand still");
                debugFunction("The woman takes out a needle and puts it close to you");
                debugFunction("Now, stand still");
                nurse_on = true;
                Player_Stats = battle_system(Nurse, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion,  
                Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  Speedy_Pills,  Mysterious_Potion,  Lucky_Clover,  Dodge_Tonic,  Cactus_Sword,  Soap, Dodges, Weapons, 
                Player_Stats, nurse_on);

                if (Player_Stats.get(4) == 0){
                    
                }else if (Player_Health <= 0){
                    clear();
                    debugFunction("Nurse - There you are, not so hard now is it?");
                    clear();
                }


                writer.close();
            }catch (RuntimeException e){
            }
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public static void rules() {
        System.out.println("All dialogue and text will move on its own without the need to press anything unless told to do so");
        System.out.println("");
        System.out.println("Escaping battles only has small probability of success");
        System.out.println("");
        System.out.println("Endings will depend on the fights you do");
        System.out.println("");
        System.out.println("Coins can be obtained in fights");
        System.out.println("");
        System.out.println("HAVE FUN");
    }

    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //! ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    public static void main(String[] args) {
        while (true) {
            try{
                String Choice = ""; 
                Scanner scan = new Scanner(System.in);
                while(!(Choice.equals("1")||Choice.equals("2"))){
                    clear();
                    title_screen();
                    System.out.println("");
                    System.out.println("[1] Play");
                    System.out.println("[2] Rules");
                    Choice = scan.nextLine();
                }

                if (Choice.equals("1")){
                    story();
                    
                    if (deads <= 0){
                        clear();
                        debugFunction("Recaptured and secured, the victim has been detained and given proper treatment");
                        debugFunction("You Achieved the Good Ending");
                        pause(7000);
                        clear();
                    }else if (deads == 12) {
                        clear();
                        debugFunction("Victim sentenced to death after committing mass genocide");
                        debugFunction("You Achieved the Bad Ending");
                        pause(7000);
                        clear();
                    }else if (deads < 12){
                        clear();
                        debugFunction("Victim locked behind bars after committing a multitude of murders");
                        debugFunction("You Achieved the Neutral Ending");
                        pause(7000);
                        clear();

                    }

                }else{
                    clear();
                    rules();
                    System.out.println("");
                    System.out.println("Press any key to return to startscreen:");
                    Choice = scan.nextLine();
                }
            
            }catch(RuntimeException e){
                clear();
                debugFunction("Victim found dead after fighting with nurse and ");
                debugFunction("YOU DIED");
                pause(6000);
                clear();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
}