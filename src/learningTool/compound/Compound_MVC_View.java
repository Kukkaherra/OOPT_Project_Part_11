package compound;
import java.util.Scanner;

public class Compound_MVC_View {
    public void showUsername(String username) {
        System.out.println("Your username: " + username);
    }
    public void showPassword(String password) {
        System.out.println("Your password: " + password);
    }
    public String askUsername() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Your username: ");
        return scan.nextLine();
    }
    public String askPassword() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Your password: ");
        return scan.nextLine();
    }
}
