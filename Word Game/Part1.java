import java.util.*;

public class Part1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userWord = scan.nextLine();

        // Print the first 2 characters of userWord on one line
        // Print an "*" on the next line
        // Print the rest of the userWord on the last line
        
        System.out.println(userWord);
        
        scan.close();
    }

}