//! Carlos STATUS -- no
// * Ethan STATUS -- No
//? Sebastian STATUS -- No


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

    public static void sleeping(String name){
        File file1 = new File("file.txt");
        try {
            FileWriter writer = new FileWriter(file1, true);
            writer.write("Your name: " + name + "\n");
            writer.write("\n");
            writer.write("-------------------------------------------------------\n");                             
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                                   
            writer.write("░░██████░░░░░░░░██████░░\n");                  
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░            Health: 100\n");                  
            writer.write("░░░░████░░░░░░░░████░░░░\n");                  
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
            writer.write("░░░░░░████████████░░░░░░\n");                  
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
            File file1 = new File("file.txt");
            Scanner scan = new Scanner(System.in);
        do {
            

            slowPrint("Do you: [1] figth or [2] escape?");
            System.out.println("");
            String user_choice = scan.nextLine();
            System.out.println("");
            

            while (!user_choice.strip().toLowerCase().equals("figth") && !user_choice.strip().toLowerCase().equals("escape") && !user_choice.strip().toLowerCase().equals("1") && !user_choice.strip().toLowerCase().equals("2")) {
                slowPrint("You need to choose either to escape or to figth");
                user_choice = scan.nextLine();
                System.out.println("");
            }

            if (user_choice.toLowerCase().strip().equals("figth") || user_choice.toLowerCase().strip().equals("1")) {
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
                        slowPrint("Your hp is at: " + Player_Health);
                        System.out.println("");
                        damage_dealt = 0;
                    }
                }
                
            }
            else{
                escape_probability = rand.nextInt(5);
                if (escape_probability <= Player_luck) {
                    slowPrint("You sucesefully managed to escape.");
                    user_escape = true;
                    
                }
                else{
                    slowPrint("The " + Monster.getMonster_name() + " succesfully attacked you as you were escaping");
                    
                    for (int i = 1; i <= Monster.getAgility(); i++){
                    
                    damage_dealt = Monster.getMinStrength();
                    damage_dealt += rand.nextInt(Monster.getMaxStrength() - Monster.getMinStrength());
                    Player_Health -= damage_dealt;
                    slowPrint("The " + Monster.getMonster_name() + "'s attack dealt " + damage_dealt + " damage points");
                    slowPrint("Your hp is at: " + Player_Health);
                    System.out.println("");
                    damage_dealt = 0;
                    }
                }
            }
            deletefile(file1);
            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);
        }while (user_escape == false && monster_Health != 0);
        user_escape = false;
        Player_XP += Monster.getHealth()*2;
        
        

    }

    public static void idle(String name, int Player_Health, int agility, int Player_luck, int Player_Strength, int Player_XP){
        File file1 = new File("file.txt");
        try {
            FileWriter writer = new FileWriter(file1, true);
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

    public static void start_screen(){
        File file1 = new File("file.txt");
        try {
            FileWriter writer = new FileWriter(file1, true);
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
        ScheduledExecutorService stop_time = Executors.newScheduledThreadPool(1);
        System.out.println("Hello, World!");
        clear();
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        File file1 = new File("file.txt");
        FileWriter writer = new FileWriter(file1, true);
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
        Foes Leaf_Monster = new Foes("Leaf_Monster",4, 6, 2,10 );
        Foes Wolf = new Foes("Wolf",4, 8, 1, 13);
        Foes Mud_Golem = new Foes("Mud_Golem",4, 8, 1, 13);
        Foes Dagger_Bandit = new Foes("Dagger_Bandit",4, 8, 1, 13);
        Foes Sword_Bandit = new Foes("Sword_Bandit",4, 8, 1, 13);
        Foes Bow_bandit = new Foes("Bow_bandit",4, 8, 1, 13);
        Foes Bandit_Boss = new Foes("Bandit_Boss",4, 8, 1, 13);
        Foes Troll = new Foes("Troll",4, 8, 1, 13);
        Foes Ciclops = new Foes("Ciclops",4, 8, 1, 13);
        Foes Goblin = new Foes("Goblin",4, 8, 1, 13);
        Foes Ogre = new Foes("Ogre",4, 8, 1, 13);
        Foes Doctor = new Foes("Doctor",4, 8, 1, 13);






        try {
            deletefile(file1);
            start_screen();
            

            slowPrint("You wake up in a cabin in the middle of the woods, your head is ");
            slowPrint("bleeding and a man is treating your wounds.");
            slowPrint("The man says in a raspy voice: 'You recieved quite a beating in");
            slowPrint("those woods young one, what may your name be?'");
            System.out.println("");
            System.out.print("Your name: ");
            String name = scan.nextLine();
            System.out.println("");

            slowPrint(name + "?, huh, thats a nice name");
            slowPrint("Its to dangerous to go into the forest in your own.");
            slowPrint("I have a spare wooden sword,");
            slowPrint("you should take it in case something happens.");
            slowPrint("Now get out of my house, I can't have you here forever.");
            Thread.sleep(4000);
            clear();
            slowPrint("You get out of the house looking at the bright sun as you walk towards the forest.");
            slowPrint("You slowly walk througth the forest as you see a leaf monster");
            // first monster
            monster_Health = Leaf_Monster.getHealth();
            
            battle_system(Leaf_Monster, Player_Health, agility, Player_Strength, Player_luck, Player_XP, name, monster_Health, user_escape);

        
            slowPrint("After the encounter with the Leaf Monster " + name + " found himself infront of a savage wolf who came due to the load noises.");
            // second monster
            monster_Health = Wolf.getHealth();
            battle_system(Wolf, Player_Health, agility, Player_Strength, Player_luck, Player_XP, name, monster_Health, user_escape);
            
            slowPrint("After what happened with the wolf, extremly tired, you decided to take a nap...");
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



            deletefile(file1);


            idle(name, Player_Health, agility, Player_luck, Player_Strength, Player_XP);
            
            Thread.sleep(2000);
            deletefile(file1);
            writer.write("WOWZ");
            writer.close();
            Thread.sleep(2000);
            deletefile(file1);
            
            Thread.sleep(2000);
            sleeping(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //! !!!VERY IMPORTANT!!!
        scan.close();
        
        //! !!!DO NOT DELETE EVERY!!!
    }
}
