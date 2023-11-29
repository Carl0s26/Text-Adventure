//! Carlos STATUS -- online
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

    public static void battle_system(){
    }

    public static void idle(String name){
        File file1 = new File("file.txt");
        try {
            FileWriter writer = new FileWriter(file1, true);
            writer.write("Your name: " + name + "\n");
            writer.write("\n");
            writer.write("-------------------------------------------------------\n");                             
            writer.write("░░██████░░░░░░░░██████░░\n");                                   
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
            writer.write("░░░░████░░░░░░░░████░░░░            Health: 100\n");                  
            writer.write("░░░░████░░░░░░░░████░░░░\n");                  
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
            writer.write("░░░░██░░░░░░░░░░░░██░░░░\n");                  
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
        

        try {
            deletefile(file1);
            start_screen();
            

            slowPrint("You wake up in a cabin in the middle of the woods, your head is ");
            slowPrint("bleeding and a man is treating your wounds.");
            slowPrint("The man says in a raspy voice: 'You recieved quite a beating in");
            slowPrint("those woods young one, what may your name be?'");
            System.out.print("Your name: ");
            String name = scan.nextLine();

            slowPrint(name + "?, huh, thats a nice name");

            deletefile(file1);


            idle(name);
            
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
