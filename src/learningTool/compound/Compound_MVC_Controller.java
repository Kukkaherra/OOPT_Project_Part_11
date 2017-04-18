package compound;
public class Compound_MVC_Controller {
    private Compound_MVC_View theView;
    private Compound_MVC_Model theModel;
    public Compound_MVC_Controller(Compound_MVC_View view, Compound_MVC_Model model) {
        this.theView=view;
        this.theModel=model;
    }
    public void runApplication() {
        theModel.setName(theView.askUsername());
        theModel.setPassword(theView.askPassword());
        theView.showUsername(theModel.getName());
        theView.showPassword(theModel.getPassword());
    }
}
