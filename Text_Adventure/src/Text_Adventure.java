//! Carlos STATUS -- Carreando
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
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░            Health: 20\n");                  
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



    public static void idle(String name){
        File file1 = new File("file.txt");
        try {
            FileWriter writer = new FileWriter(file1, true);
            writer.write("Your name: " + name + "\n");
            writer.write("\n");
            writer.write("-------------------------------------------------------\n");                             
            writer.write("░░██████░░░░░░░░██████░░\n");                                   
            writer.write("░░░░░░░░░░░░░░░░░░░░░░░░\n");                  
            writer.write("░░░░████░░░░░░░░████░░░░            Health: 20\n");                  
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
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        File file1 = new File("file.txt");
        FileWriter writer = new FileWriter(file1, true);
        clear();

        try {
            deletefile(file1);
            start_screen();
            
            System.out.print("Your name: ");
            String name = scan.nextLine();

            deletefile(file1);


            idle(name);
            
            System.out.println("borrar?");
            String borrar = scan.nextLine();
            deletefile(file1);
            writer.write("WOWZ");
            writer.close();
            System.out.println("Dormir: ");
            String dormir = scan.nextLine();
            deletefile(file1);
            stop_time.schedule(() -> {
                sleeping(name);
                stop_time.shutdown();
                
            }, 3, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //! !!!VERY IMPORTANT!!!
        scan.close();
        
        //! !!!DO NOT DELETE EVERY!!!
    }
}
