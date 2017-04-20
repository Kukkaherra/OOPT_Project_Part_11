/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Oskari
 */
public class PatternComposite implements PatternHelper{
    
    private String question;
    ArrayList<PatternHelper> childNodes = new ArrayList<>();
    ArrayList<String> questions = new ArrayList<>();
    
    public PatternComposite(String question) {
        this.question = question;
    } 
    
    public String getQuestion() {
        return question;
    }
 
    public void addQuestions() {
        questions.add(question);
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
        return "Question: " + getQuestion();
    }

    
}
