package compound;
/*
Mainclass for the MVC example
*/
public class Mainclass {
    public static void main(String[] args) {
        Compound_MVC_Controller controller = new Compound_MVC_Controller(new Compound_MVC_View(), new Compound_MVC_Model());
        controller.runApplication();
    }
    
}
