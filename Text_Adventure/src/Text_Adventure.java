//! Carlos STATUS -- no
// * Ethan STATUS -- si
//? Sebastian STATUS -- No


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Text_Adventure {

    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }


    public static void deletefile(File filename){
        try {
            FileWriter deleteContent = new FileWriter(filename, false);
            deleteContent.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    }


    public static void archery() {
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
                Thread.sleep(100);

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
                    if(number <= 16 && number >= 11){
                        slowPrint("Yay, you win");
                        
                        break;
                    }else{
                        slowPrint("Boo, you lose");
                        
                        break;
                    }
                    
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally {
            
        }
        scan.close();
    }

    // the function for the user to buy objects

    public static int shop(ArrayList<InventoryObject> AllObjects,List<InventoryObject> UserInventory, InventoryObject Small_Health_Potion, 
    InventoryObject Medium_Health_Potion, InventoryObject Big_Health_Potion, InventoryObject Strength_token, InventoryObject Bow, 
    InventoryObject SpeedPotion, InventoryObject Mysterious_Potion, InventoryObject Something3, InventoryObject Something4, 
    InventoryObject Something5, InventoryObject Something6, int Player_coins){

        Scanner scan = new Scanner(System.in);
        boolean While = true;
        slowPrint("Welcome to the shop");
        slowPrint("Choose a object to buy and enter 11 or esc to get out of the shop");
        for (int i = 0; i < AllObjects.size(); i++) {
            slowPrint("[" + AllObjects.get(i).getidentification_number() + "] " + AllObjects.get(i).getobject_name() + " Its price is: " + AllObjects.get(i).getprize() + " coins");
            
        }
        do {
            String user_choice = scan.nextLine();
        switch (user_choice) {
            case "0":
                if (Player_coins >= Small_Health_Potion.getprize()) {
                    Player_coins -= Small_Health_Potion.getprize();
                    UserInventory.add(Small_Health_Potion);
                    slowPrint("You succesfully bougth a " + Small_Health_Potion.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "1":
                if (Player_coins >= Medium_Health_Potion.getprize()) {
                    Player_coins -= Medium_Health_Potion.getprize();
                    UserInventory.add(Medium_Health_Potion);
                    slowPrint("You succesfully bougth a " + Medium_Health_Potion.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "2":
                if (Player_coins >= Big_Health_Potion.getprize()) {
                    Player_coins -= Big_Health_Potion.getprize();
                    UserInventory.add(Big_Health_Potion);
                    slowPrint("You succesfully bougth a " + Big_Health_Potion.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "3":
                if (Player_coins >= Strength_token.getprize()) {
                    Player_coins -= Strength_token.getprize();
                    UserInventory.add(Strength_token);
                    slowPrint("You succesfully bougth a " + Strength_token.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "4":
                if (Player_coins >= Bow.getprize()) {
                    Player_coins -= Bow.getprize();
                    UserInventory.add(Bow);
                    slowPrint("You succesfully bougth a " + Bow.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "5":
                if (Player_coins >= SpeedPotion.getprize()) {
                    Player_coins -= SpeedPotion.getprize();
                    UserInventory.add(SpeedPotion);
                    slowPrint("You succesfully bougth a " + SpeedPotion.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "6":
                if (Player_coins >= Mysterious_Potion.getprize()) {
                    Player_coins -= Mysterious_Potion.getprize();
                    UserInventory.add(Mysterious_Potion);
                    slowPrint("You succesfully bougth a " + Mysterious_Potion.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "7":
                if (Player_coins >= Something3.getprize()) {
                    Player_coins -= Something3.getprize();
                    UserInventory.add(Something3);
                    slowPrint("You succesfully bougth a " + Something3.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "8":
                if (Player_coins >= Something4.getprize()) {
                    Player_coins -= Something4.getprize();
                    UserInventory.add(Something4);
                    slowPrint("You succesfully bougth a " + Something4.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "9":
                if (Player_coins >= Something5.getprize()) {
                    Player_coins -= Something5.getprize();
                    UserInventory.add(Something5);
                    slowPrint("You succesfully bougth a " + Something5.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "10":
                if (Player_coins >= Something6.getprize()) {
                    Player_coins -= Something6.getprize();
                    UserInventory.add(Something6);
                    slowPrint("You succesfully bougth a " + Something6.getobject_name());
                }
                else{
                    slowPrint("You don't have enougth coins");
                }
                break;
            case "esc":
                System.out.println("Thanks for shooping with us");
                While = false;
                break;
            case "11":
                System.out.println("Thanks for shooping with us");
                While = false;
                break;
            case "exit":
                System.out.println("Thanks for shooping with us");
                While = false;
                break;
            
            default:
            slowPrint("Please enter a valid input");
                break;
        }
        
        } while (While == true);
        
        scan.close();
        return Player_coins;
        
    }

    public static void sleeping(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_coins){
        File gui = new File("gui.txt");
        try {
            FileWriter writer = new FileWriter(gui, true);
            writer.write("Your name: " + name + "\n");
            writer.write("\n");
            writer.write("-------------------------------------------------------\n");                             
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                                   
            writer.write("░░██████░░░░░░░░██████░░\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Health: "    + Player_Health +     "\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Dexterity: " + agility +  "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Luck: "      + Player_luck +       "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Strength: "  + Player_Strength +   "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Coins: "        + Player_coins +         "\n");                  
            writer.write("░░░░░░░░████████░░░░░░░░\n");                  
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");      
            writer.write("-------------------------------------------------------\n"); 
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void slowPrint(String output) {
        char[] chars = output.toCharArray();
         try {
            for (int i = 0; i < chars.length-1; i++){
                System.out.print(chars[i]);
                Thread.sleep(50);
                }
                System.out.println(chars[chars.length-1]);
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public static void LevelUP(String output) {
        
    }

    // user scape must always be false when using the function
    public static int Player_Health;

    public static int battle_system(Foes Monster, int Player_Health, int agility,  int Player_Strength, int Player_luck, int Player_coins, 
    String name, boolean user_escape, List<InventoryObject> UserInventory, InventoryObject Small_Health_Potion, 
    InventoryObject Medium_Health_Potion, InventoryObject Big_Health_Potion, InventoryObject Strength_token, InventoryObject Bow, 
    InventoryObject SpeedPotion, InventoryObject Mysterious_Potion, InventoryObject Something3, InventoryObject Something4, InventoryObject Something5, 
    InventoryObject Something6){

            int monster_Health = Monster.getHealth();
            int escape_probability = 0;
            int damage_dealt = 0;
            Random rand = new Random();
            File gui = new File("gui.txt");
            Scanner scan = new Scanner(System.in);

        do {
            if (UserInventory.size() == 0){
                slowPrint("Do you: [1] Fight, [2] Escape?");
            }else{
                slowPrint("Do you: [1] Fight, [2] Escape?, [3] Inventory?");
            }
            
            System.out.println("");
            String user_choice = scan.nextLine();
            System.out.println("");
            clear();
            

            if (UserInventory.size() == 0){
                while (!user_choice.strip().toLowerCase().equals("fight") && !user_choice.strip().toLowerCase().equals("escape") && !user_choice.strip().toLowerCase().equals("1") && !user_choice.strip().toLowerCase().equals("2")) {
                    clear();
                    slowPrint("You need to choose to either escape or fight");
                    slowPrint("Do you: [1] Fight, [2] Escape?");
                    user_choice = scan.nextLine();
                    System.out.println("");
                    clear();
                }
            
            }else{
                while (!user_choice.strip().toLowerCase().equals("fight") && !user_choice.strip().toLowerCase().equals("escape") && !user_choice.strip().toLowerCase().equals("1") && !user_choice.strip().toLowerCase().equals("2") && !user_choice.strip().toLowerCase().equals("3") && !user_choice.strip().toLowerCase().equals("inventory")) {
                    clear();
                    slowPrint("You need to choose to escape, fight or open your inventory");
                    slowPrint("Do you: [1] Fight, [2] Escape, [3] Inventory?");
                    user_choice = scan.nextLine();
                    System.out.println("");
                    clear();
                }
            }
            

            if (user_choice.toLowerCase().strip().equals("fight") || user_choice.toLowerCase().strip().equals("1")) {
                for (int i = 1; i <= agility; i++){
                    
                    damage_dealt = Player_Strength;
                    damage_dealt += rand.nextInt(Player_Strength/2);
                    monster_Health -= damage_dealt;
                    slowPrint("Your attack dealt " + damage_dealt + " damage points");
                    if (monster_Health <= 0) {
                        monster_Health = 0;
                        slowPrint("The " + Monster.getMonster_name() + " health is at: " + monster_Health);
                        slowPrint("You managed to kill the " + Monster.getMonster_name() );
                        System.out.println("");
                        damage_dealt = 0;
                        break;
                    }
                    slowPrint("The " + Monster.getMonster_name() + " health is at: " + monster_Health);

                    
                    

                    
                }
                if (monster_Health > 0) {

                    System.out.println("");
                    slowPrint("The " + Monster.getMonster_name() + " managed to attack you back");
                    System.out.println("");
                    for (int i = 1; i <= Monster.getAgility(); i++){
                    
                        if (i >= 2) {
                            slowPrint("The monster managed to make another attack due its high agility");
                        }
                        damage_dealt = Monster.getMinStrength();
                        damage_dealt += rand.nextInt(Monster.getMaxStrength() - Monster.getMinStrength());
                        Player_Health -= damage_dealt;
                        if (damage_dealt < 2){
                            slowPrint("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage point");
                        }else{
                            slowPrint("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage points");
                        }
                        
                        try{
                            deletefile(gui);
                            damage(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);
                            Thread.sleep(1000);
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        slowPrint("Your health is at: " + Player_Health);
                        System.out.println("");
                        damage_dealt = 0;
                    }
                }
                
            }

            // in case the user chooses inventory this code printa every item in the inventory list with their identiication number and the user then chooses the object by writting the identification number after that we just need to add what each object does in each case.

            else if (user_choice.toLowerCase().strip().equals("inventory") || user_choice.toLowerCase().strip().equals("3")) {
                System.out.println("");
                slowPrint("Choose a item to use from your inventory");
                for (int i = 0; i < UserInventory.size(); i++) {
                    slowPrint("[" + UserInventory.get(i).getidentification_number() + "] " + UserInventory.get(i).getobject_name());
                }

                user_choice = scan.nextLine();

                switch (user_choice) {
                    case "0":
                    // small healing potion
                        if (UserInventory.contains(Small_Health_Potion)) {
                            Player_Health += 5;
                            break;
                        }
                        
                    case "1":
                    // medium healing potion  
                        if (UserInventory.contains(Medium_Health_Potion)) {
                            Player_Health += 10;
                            break;
                        }
                        
                    case "2":
                    // Big healing potion
                            
                        if (UserInventory.contains(Big_Health_Potion)) {
                            Player_Health += 25;
                            break;
                        }
                        
                    case "3":
                    // strength object
                        if (UserInventory.contains(Strength_token)) {
                            // strength up function
                            break;
                        }

                    case "4":
                    // bow
                        if (UserInventory.contains(Bow)) {
                            archery();
                            break;
                        }
                        
                    case "5":
                        if (UserInventory.contains(SpeedPotion)) {
                            break;
                        }
                        
                    case "6":
                        if (UserInventory.contains(Mysterious_Potion)) {
                            break;
                        }
                        
                    case "7":
                        if (UserInventory.contains(Something3)) {
                            break;
                        }
                        
                    case "8":
                        if (UserInventory.contains(Something4)) {
                            
                        }
                        
                        break;
                    case "9":
                        if (UserInventory.contains(Something5)) {
                            break;
                        }
                        
                    case "10":
                        if (UserInventory.contains(Something5)) {
                           break;
                        }

                    case "11":
                        if (UserInventory.contains(Something6)) {
                            break;
                        }

                    default:
                        slowPrint("You don't have this item");
                        break;
                }

                // makes the monster attack after you use a object
                System.out.println("");
                    slowPrint("The " + Monster.getMonster_name() + " managed to attack you");
                    System.out.println("");
                    for (int i = 1; i <= Monster.getAgility(); i++){
                    
                        if (i >= 2) {
                            slowPrint("The monster managed to make another attack due its high agility");
                        }
                        damage_dealt = Monster.getMinStrength();
                        damage_dealt += rand.nextInt(Monster.getMaxStrength() - Monster.getMinStrength());
                        Player_Health -= damage_dealt;
                        if (damage_dealt < 2){
                            slowPrint("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage point");
                        }else{
                            slowPrint("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage points");
                        }
                        
                        try{
                            deletefile(gui);
                            damage(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);
                            Thread.sleep(1000);
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        slowPrint("Your health is at: " + Player_Health);
                        System.out.println("");
                        damage_dealt = 0;
                    }
            }
            else{
                escape_probability = rand.nextInt( 6);
                if (escape_probability <= Player_luck) {
                    slowPrint("You successfully managed to escape.");
                    user_escape = true;
                    
                }
                else{
                    slowPrint("The " + Monster.getMonster_name() + " attacked you while you were trying to escape");
                    
                    for (int i = 1; i <= Monster.getAgility(); i++){
                    
                    damage_dealt = Monster.getMinStrength();
                    damage_dealt += rand.nextInt(Monster.getMaxStrength() - Monster.getMinStrength());
                    Player_Health -= damage_dealt;
                    if (damage_dealt < 2){
                        slowPrint("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage point");
                    }else{
                        slowPrint("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage points");
                    }
                    try{
                        deletefile(gui);
                        damage(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);
                        Thread.sleep(1000);
                        deletefile(gui);
                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);
                    }catch(Exception e){
                        System.out.println(e);
                    }
            
                    slowPrint("Your health is at: " + Player_Health);
                    System.out.println("");
                    damage_dealt = 0;
                    }
                }
            }
            
            
        }while (user_escape == false && monster_Health != 0);
        user_escape = false;
      
        scan.close();

        return Player_Health;
    }

    public static void idle(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_coins){
        File gui = new File("gui.txt");
        try {
            FileWriter writer = new FileWriter(gui, true);
            writer.write("Your name: " + name + "\n");
            writer.write("\n");
            writer.write("-------------------------------------------------------\n");                             
            writer.write("░░██████░░░░░░░░██████░░\n");                                   
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Health: "    + Player_Health +     "\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Dexterity: " + agility +  "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Luck: "      + Player_luck +       "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Strength: "  + Player_Strength +   "\n");                  
                writer.write("░░░░██░░░░░░░░░░░░██░░░░        Coins: "        + Player_coins +         "\n");                  
            writer.write("░░░░░░██░░░░░░░░██░░░░░░\n");                  
            writer.write("░░░░░░░░████████░░░░░░░░\n");      
            writer.write("-------------------------------------------------------\n"); 
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void damage(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_coins){
        File gui = new File("gui.txt");
        try {
            FileWriter writer = new FileWriter(gui, true);
            writer.write("Your name: " + name + "\n");
            writer.write("\n");
            writer.write("-------------------------------------------------------\n");                             
            writer.write("░░██████░░░░░░░░██████░░\n");                                   
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Health: "    + Player_Health +     "\n");                  
                writer.write("░░░░░░░░█░░░░░░█░░░░░░░░        Dexterity: " + agility +  "\n");                  
                writer.write("░░░░████░░░░░░░░████░░░░        Luck: "      + Player_luck +       "\n");                  
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        Strength: "  + Player_Strength +   "\n");                  
                writer.write("░░░░░░░░████████░░░░░░░░        Coins: "        + Player_coins +         "\n");                  
            writer.write("░░░░░░░░██░░░░██░░░░░░░░\n");                  
            writer.write("░░░░░░░░████████░░░░░░░░\n");      
            writer.write("-------------------------------------------------------\n"); 
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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



    public static void main(String[] args) throws Exception{
        // archery();
        
        clear();
        Scanner scan = new Scanner(System.in);
        File gui = new File("gui.txt");
        FileWriter writer = new FileWriter(gui, true);
        
        int escape_probability = 0;
        boolean user_escape = false;
        int monster_attacks = 0;
        int monster_Health = 0;

        int Player_coins = 0;
        int Player_Health = 100;
        int Player_Strength = 5;
        int agility = 1;
        int Player_luck = 0;
        int damage_dealt = 0;
        
        // All monsters Stats
        Foes Leaf_Monster = new Foes("Leaf Monster",1, 3, 2,10);
        Foes Wolf = new Foes("Wolf",4, 8, 1, 6);
        Foes Mud_Golem = new Foes("Mud Golem",4, 8, 1, 15);
        Foes Dagger_Bandit = new Foes("Dagger Bandit",7, 12, 1, 20);
        Foes Sword_Bandit = new Foes("Sword Bandit",10, 17, 1, 25);
        Foes Bow_bandit = new Foes("Bow bandit",3, 5, 5, 30);
        Foes Bandit_Boss = new Foes("Bandit Boss",2, 20, 1, 40);
        Foes Troll = new Foes("Troll",7, 9, 1, 50);
        Foes Ciclops = new Foes("Ciclops",12, 23, 1, 40);
        Foes Goblin = new Foes("Goblin gang",7, 12, 3, 24);
        Foes Ogre = new Foes("Ogre",12, 15, 2, 50);
        Foes Nurse = new Foes("Nurse",20, 30, 1, 60);

        // Inventory objects prizes and names

        // change the names and objects if you got good ideas for new objects or names but remeber you will also need to change them on the battle_System function

        InventoryObject Small_Health_Potion = new InventoryObject("Small Healing Potion", "0", 10 );
        InventoryObject Medium_Health_Potion = new InventoryObject("Medium Healing Potion", "1", 20 );
        InventoryObject Big_Health_Potion = new InventoryObject("Big Healing Potion", "2", 30 );
        InventoryObject Strength_token = new InventoryObject("Strength Token", "3", 30 );
        InventoryObject Bow = new InventoryObject("Bow", "4", 10 );
        InventoryObject SpeedPotion = new InventoryObject("Speed Potion", "5", 10 );
        InventoryObject Mysterious_Potion = new InventoryObject("Mysterious Potion", "6", 10 );
        InventoryObject Something3 = new InventoryObject("Something3", "7", 10 );
        InventoryObject Something4 = new InventoryObject("Something4", "8", 10 );
        InventoryObject Something5 = new InventoryObject("Something5", "9", 10 );
        InventoryObject Something6 = new InventoryObject("Something6", "10", 10 );
        
        // a list with all the objects
        ArrayList<InventoryObject> AllObjects = new ArrayList<>(Arrays.asList(Small_Health_Potion,Medium_Health_Potion,Big_Health_Potion,Strength_token,Bow,SpeedPotion,Mysterious_Potion,Something3,Something4,Something5,Something6));
        // a list with all the objects the user have
        List<InventoryObject> UserInventory = new ArrayList<>();


        // A code to test the shop function

        // Player_coins += 40;
        // Player_coins = shop(AllObjects, UserInventory, Small_Health_Potion, Medium_Health_Potion, Big_Health_Potion, Strength_token, Bow, SpeedPotion, Mysterious_Potion, Something3, Something4, Something5, Something6, Player_coins);
        // for (int i = 0; i < UserInventory.size(); i++) {
        //     slowPrint("[" + UserInventory.get(i).getidentification_number() + "] " + UserInventory.get(i).getobject_name());
        // }
        // System.out.println("coins " + Player_coins);

        try {
            deletefile(gui);
            start_screen();
            

            slowPrint("You wake up in a cabin in the middle of the woods, your head is ");
            slowPrint("bleeding and a man is treating your wounds.");
            slowPrint("The man says in a raspy voice:  'You recieved quite a beating in");
            slowPrint("those woods young one, what may your name be?");
            System.out.println("");
            System.out.print("Your name: ");
            String name = scan.nextLine();
            System.out.println("");

            slowPrint(name + "?, huh, thats a nice name");
            slowPrint("Its too dangerous to go into the forest on your own.");
            slowPrint("I have a spare wooden sword,");
            slowPrint("you should take it just in case something happens out there.");
            Thread.sleep(3000);
            slowPrint("Now get out of my house, I can't take care of you forever!'");
            
            Thread.sleep(3000);
            clear();

            deletefile(gui);
            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);

            slowPrint("You get out of the house looking at the bright sun as you walk towards the forest.");
            slowPrint("You slowly walk through the forest when you encounter a leaf monster");
            
            // first monster
            Player_Health = battle_system(Leaf_Monster, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion,  Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  SpeedPotion,  Mysterious_Potion,  Something3,  Something4,  Something5,  Something6);
            Player_coins += Leaf_Monster.getHealth()*2;

        
            slowPrint("After the encounter with the Leaf Monster " + name + " found himself infront of a");
            slowPrint("savage wolf who came due to the commotion caused by your battle.");
            // second monster
            Player_Health = battle_system(Wolf, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion,  Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  SpeedPotion,  Mysterious_Potion,  Something3,  Something4,  Something5,  Something6);
            Player_coins += Wolf.getHealth()*2;

            slowPrint("After what happened with the wolf, extremely tired, you decided to take a nap...");
            
            try{
                deletefile(gui);
                sleeping(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);
                Thread.sleep(1500);
                deletefile(gui);
                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);
            }catch(Exception e){
                System.out.println(e);
            }
            slowPrint("You suddently woke up hearing some screams in the middle of the now completely dark forest.");

            slowPrint("Do you: [1] Go to investigate, [2] Continue sleeping");
            String choice = scan.nextLine();
            System.out.println("");

            while (!choice.strip().toLowerCase().equals("investigate") && !choice.strip().toLowerCase().equals("sleeping") && !choice.strip().toLowerCase().equals("1") && !choice.strip().toLowerCase().equals("2")&& !choice.strip().toLowerCase().equals("sleep")&& !choice.strip().toLowerCase().equals("continuesleeping")) {
                slowPrint("You need to choose either to escape or to fight");
                choice = scan.nextLine();
                System.out.println("");
            }

            if (choice.strip().toLowerCase().equals("1") || choice.strip().toLowerCase().equals("investigate")){
                slowPrint("You find a Mud Golem Attacking the man that saved you earlier");
            Player_Health = battle_system(Mud_Golem, Player_Health, agility, Player_Strength, Player_luck, Player_coins, name, user_escape, UserInventory,  Small_Health_Potion,  Medium_Health_Potion,  Big_Health_Potion,  Strength_token,  Bow,  SpeedPotion,  Mysterious_Potion,  Something3,  Something4,  Something5,  Something6);
                Player_coins += Mud_Golem.getHealth()*2;
                slowPrint(" The man who was almoust killed decides to give you a iron sword in gratitude. ");
                slowPrint("after that match with the golem the sun rise and you decide to continue your quest ");
                
            }
            else{
                
                slowPrint("you continue sleeping until the sun rise and continue your quest");
            }
Thread.sleep(2000);
        slowPrint("During your adventure you found a village so you decide to stay for a moment");
        slowPrint("when you arrive to the village you see a items shop");
        System.out.println("you do: [1]enter , [2]ignore ");
        choice = scan.nextLine();
        while (!choice.strip().toLowerCase().equals("enter") && !choice.strip().toLowerCase().equals("ignore") && !choice.strip().toLowerCase().equals("1") && !choice.strip().toLowerCase().equals("2")) {
                slowPrint("You need to choose either to enter or ignore the shop");
                choice = scan.nextLine();
                System.out.println("");
            }
        if(choice.strip().toLowerCase().equals("enter")||choice.strip().toLowerCase().equals("1") ){
        Player_coins = shop(AllObjects, UserInventory, Small_Health_Potion, Medium_Health_Potion, Big_Health_Potion, Strength_token, Bow, SpeedPotion, Mysterious_Potion, Something3, Something4, Something5, Something6, Player_coins);
        slowPrint("you get outsite the shop and continue your quest ");
    } 
else{
    slowPrint("you decide to keep walking in the village");
}
        slowPrint("then a villager saw your sword and talk to you ");
        slowPrint("traveler some bandits were atackin our village but we dont have any warrior in the village can you take care of those bandits for us");
        Thread.sleep(1500);
        System.out.println("you do: [1]accept , [2]refuse ");
        choice = scan.nextLine();
 while (!choice.strip().toLowerCase().equals("accept") && !choice.strip().toLowerCase().equals("refuse") && !choice.strip().toLowerCase().equals("1") && !choice.strip().toLowerCase().equals("2")) {
                slowPrint("You need to choose either to accept or refuse the request");
                choice = scan.nextLine();
                System.out.println("");
            }
        if(choice.strip().toLowerCase().equals("accept") || choice.strip().toLowerCase().equals("1")){
            slowPrint("Thanks traveler we are in debt on you");
            slowPrint("after accept the request you decide to go to the bandits base and take they down ");
            slowPrint(name+"has arrive to the bandits base during the night ");
            slowPrint("so you decide to raid the base and kill all the bandits");

            
        }
        else{
            slowPrint("you decide to refuse the request and continue your quest ");
        }

            deletefile(gui);

            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_coins);
            
            Thread.sleep(2000);
            deletefile(gui);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //! !!!VERY IMPORTANT!!!
        scan.close();
        
        //! !!!DO NOT DELETE EVERY!!!
    }
}
