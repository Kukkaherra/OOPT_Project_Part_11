package learningTool;

import java.util.ArrayList;

public class PatternComposite implements PatternHelper{
    
    private String question;
    ArrayList<PatternHelper> childNodes = new ArrayList<>();
    
    public PatternComposite(String question) {
        this.question = question;
    } 
    
    public String getData() {
        return question;
    }

    public ArrayList<String> getQuestionList() {
        ArrayList<String> tempList = new ArrayList<>();
        childNodes.forEach((node) -> {
            tempList.add(node.getData());
        });
        return tempList;
    }
    
    public void add(PatternHelper node) {
       childNodes.add(node);
    }

    @Override
    public PatternHelper getChild(int i) {
        return childNodes.get(i);
    }

    @Override
    public String toString() {
        return "Question: " + getData();
    }


    
}
