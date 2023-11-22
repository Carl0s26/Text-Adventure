//! Carlos STATUS -- No
// * Ethan STATUS -- No
//? Sebastian STATUS -- No


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Text_Adventure {
    public static void deletefile(File Status_FilePathname){
        try {
                FileWriter deleteContent = new FileWriter(Status_FilePathname, false);
                deleteContent.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Random Random_Generator = new Random();
        Scanner scan = new Scanner(System.in);
        File Status_FilePathname = new File("StatusFile.txt");


        try {
            deletefile(Status_FilePathname);
            
            FileWriter writer = new FileWriter(Status_FilePathname, true);

            System.out.print("Your name: ");
            String name = scan.nextLine();

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
        

            

            System.out.println("Text written to file successfully.");
            
            writer.write("WOWZ");
            writer.close();

            // esto esta para ver se escribe en el codigo antes de ser borrado
            System.out.println("borrar?");
            String borrar = scan.nextLine();
            

            deletefile(Status_FilePathname);
            writer = new FileWriter(Status_FilePathname, true);
            writer.write("WOWZ");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scan.close();
    }
}
