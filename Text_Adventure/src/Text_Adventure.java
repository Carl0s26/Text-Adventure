//! Carlos STATUS -- No
// * Ethan STATUS -- No
//? Sebastian STATUS -- No


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Text_Adventure {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println("Prueba");
        System.out.println("soy ethan");
        System.out.println("ciwebnfebfiuewybfiyeuwbfuewbf tu mama");

        Scanner scan = new Scanner(System.in);
        try {
            try {
                FileWriter deleteContent = new FileWriter("file.txt", false);
                deleteContent.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            FileWriter writer = new FileWriter("file.txt", true);

            System.out.println("Your name: ");
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
        
            writer.close();

            System.out.println("Text written to file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        scan.close();
    }
}
