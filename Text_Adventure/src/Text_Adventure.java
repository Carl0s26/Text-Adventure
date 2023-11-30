//! Carlos STATUS -- no
// * Ethan STATUS -- No
//? Sebastian STATUS -- No


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static int return_health(int Player_Health){
        return Player_Health;
    }
    
    }

    public static void sleeping(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_XP){
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
                writer.write("░░░░░░░░░░░░░░░░░░░░░░░░        XP: "        + Player_XP +         "\n");                  
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

    public static void battle_system(Foes Monster, int Player_Health, int agility,  int Player_Strength, int Player_luck, int Player_XP, String name, int monster_Health, boolean user_escape){
            int escape_probability = 0;
            int damage_dealt = 0;
            Random rand = new Random();
            File gui = new File("gui.txt");
            Scanner scan = new Scanner(System.in);
        do {
            
            slowPrint("Do you: [1] Fight or [2] Escape?");
            System.out.println("");
            String user_choice = scan.nextLine();
            System.out.println("");
            clear();
            

            while (!user_choice.strip().toLowerCase().equals("fight") && !user_choice.strip().toLowerCase().equals("escape") && !user_choice.strip().toLowerCase().equals("1") && !user_choice.strip().toLowerCase().equals("2")) {
                clear();
                slowPrint("You need to choose either to escape or to fight");
                slowPrint("Do you: [1] Fight or [2] Escape?");
                user_choice = scan.nextLine();
                System.out.println("");
                clear();
            }

            if (user_choice.toLowerCase().strip().equals("fight") || user_choice.toLowerCase().strip().equals("1")) {
                for (int i = 1; i <= agility; i++){
                    
                    damage_dealt = Player_Strength;
                    damage_dealt += rand.nextInt(Player_Strength/2);
                    monster_Health -= damage_dealt;
                    slowPrint("Your attack dealt " + damage_dealt + " damage points");
                    if (monster_Health <= 0) {
                        monster_Health = 0;
                        slowPrint("The " + Monster.getMonster_name() + " hp is at: " + monster_Health);
                        slowPrint("You managed to kill the " + Monster.getMonster_name() );
                        System.out.println("");
                        damage_dealt = 0;
                        break;
                    }
                    slowPrint("The " + Monster.getMonster_name() + " hp is at: " + monster_Health);

                    
                    

                    
                }
                if (monster_Health > 0) {

                    System.out.println("");
                    slowPrint("The " + Monster.getMonster_name() + " managed to attack you back");
                    System.out.println("");
                    for (int i = 1; i <= Monster.getAgility(); i++){
                    
                        damage_dealt = Monster.getMinStrength();
                        damage_dealt += rand.nextInt(Monster.getMaxStrength() - Monster.getMinStrength());
                        Player_Health -= damage_dealt;
                        slowPrint("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage points");
                        try{
                            deletefile(gui);
                            damage(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);
                            Thread.sleep(750);
                            deletefile(gui);
                            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        slowPrint("Your hp is at: " + Player_Health);
                        System.out.println("");
                        damage_dealt = 0;
                    }
                }
                
            }
            else{
                escape_probability = rand.nextInt(3);
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
                    slowPrint("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage points");
                    try{
                        deletefile(gui);
                        damage(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);
                        Thread.sleep(750);
                        deletefile(gui);
                        idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);
                    }catch(Exception e){
                        System.out.println(e);
                    }
            
                    slowPrint("Your hp is at: " + Player_Health);
                    System.out.println("");
                    damage_dealt = 0;
                    }
                }
            }
            
        }while (user_escape == false && monster_Health != 0);
        user_escape = false;
        Player_XP += Monster.getHealth()*2;
        
        

    }

    public static void idle(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_XP){
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
                writer.write("░░░░██░░░░░░░░░░░░██░░░░        XP: "        + Player_XP +         "\n");                  
            writer.write("░░░░░░██░░░░░░░░██░░░░░░\n");                  
            writer.write("░░░░░░░░████████░░░░░░░░\n");      
            writer.write("-------------------------------------------------------\n"); 
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void damage(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_XP){
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
                writer.write("░░░░░░░░████████░░░░░░░░        XP: "        + Player_XP +         "\n");                  
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
        clear();
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        File gui = new File("gui.txt");
        FileWriter writer = new FileWriter(gui, true);
        
        int escape_probability = 0;
        boolean user_escape = false;
        int monster_attacks = 0;
        int monster_Health = 0;

        int Player_XP = 0;
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

        try {
            deletefile(gui);
            start_screen();
            

            slowPrint("You wake up in a cabin in the middle of the woods, your head is ");
            slowPrint("bleeding and a man is treating your wounds.");
            slowPrint("The man says in a raspy voice: 'You recieved quite a beating in");
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
            Thread.sleep(4000);
            clear();

            deletefile(gui);
            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);

            slowPrint("You get out of the house looking at the bright sun as you walk towards the forest.");
            slowPrint("You slowly walk through the forest when you encounter a leaf monster");
            
            // first monster
            monster_Health = Leaf_Monster.getHealth();
            
            battle_system(Leaf_Monster, Player_Health, agility, Player_Strength, Player_luck, Player_XP, name, monster_Health, user_escape);

        
            slowPrint("After the encounter with the Leaf Monster " + name + " found himself infront of a ");
            slowPrint("savage wolf who came due to the commotion caused by your battle.");
            // second monster
            monster_Health = Wolf.getHealth();
            battle_system(Wolf, Player_Health, agility, Player_Strength, Player_luck, Player_XP, name, monster_Health, user_escape);
            
            slowPrint("After what happened with the wolf, extremely tired, you decided to take a nap...");
            try{
                deletefile(gui);
                sleeping(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);
                Thread.sleep(1500);
                slowPrint("You suddently woke up hearing screams in the middle of the now completely dark forest.");
                deletefile(gui);
                idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);
            }catch(Exception e){
                System.out.println(e);
            }
            slowPrint("You suddently woke up hearing some screams in the middle of the now completely dark forest.");

            slowPrint("Do you: [1] Go to investigate, [2] Continue sleeping");
            String choice = scan.nextLine();
            System.out.println("");

            while (!choice.strip().toLowerCase().equals("investigate") && !choice.strip().toLowerCase().equals("sleeping") && !choice.strip().toLowerCase().equals("1") && !choice.strip().toLowerCase().equals("2")&& !choice.strip().toLowerCase().equals("sleep")&& !choice.strip().toLowerCase().equals("continuesleeping")) {
                slowPrint("You need to choose either to escape or to figth");
                choice = scan.nextLine();
                System.out.println("");
            }

            if (choice.strip().toLowerCase().equals("1") || choice.strip().toLowerCase().equals("investigate")){
                slowPrint("You find a Giagiant Golem Attacking the man that saved you earlier");
                battle_system(Mud_Golem, Player_Health, agility, Player_Strength, Player_luck, Player_XP, name, monster_Health, user_escape);
            }
            else{
                System.out.println(" bla bla bla");
            }



            deletefile(gui);


            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);
            
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
