package learnprogramming.academy.empiricapp;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculations {

    private DisplayMetrics displayMetrics;
    private List<Button> mainList, severityList, yesNoList, capHapList;
    private final Stack<Button> buttonStack = new Stack<>();
    private Button newTitle;
    private Button backButton, pneumoniaButton;
    private TextView title, question1, question2, question3, answerText;
    private ImageView pilar;


    private TextView getAnswerText() {
        return this.answerText;
    }

    private Button getPneumoniaButton() {
        return pneumoniaButton;
    }

    private DisplayMetrics getDisplayMetrics() {
        return this.displayMetrics;
    }

    private TextView getQuestion1() { return this.question1; }

    private TextView getQuestion2() { return this.question2; }

    private TextView getQuestion3() { return this.question3; }

    private List<Button> getSeverityList() {
        return this.severityList;
    }

    private List<Button> getYesNoList() {
        return this.yesNoList;
    }

    private List<Button> getCapHapList() {
        return this.capHapList;
    }

    private List<Button> getMainList() {
        return this.mainList;
    }

    private Button getNewTitle() {
        return this.newTitle;
    }

    private String troughVanco() {
        return "Trough Monitoring";
    }

    private String noCoverage() {
        return "No Indication for MRSA Coverage";
    }

    private String aucVanco() {
        return "AUC Monitoring";
    }

    private void changeBackVisibility() {
        this.backButton.animate().alpha((this.backButton.getAlpha() == 0.0) ? 1.0f : 0.0f).setDuration(500);
        this.modifyVisiblity(this.backButton);
    }

    private void fadeQuestions(TextView question1, TextView question2, TextView question3) {
        question1.animate().alpha((question1.getAlpha() == 0.0) ? 1.0f : 0.0f);
        question2.animate().alpha((question2.getAlpha() == 0.0) ? 1.0f : 0.0f);
        question3.animate().alpha((question3.getAlpha() == 0.0) ? 1.0f : 0.0f);
    }

    private void fadeAnswer() {
        this.answerText.animate().alpha((this.getAnswerText().getAlpha() == 0.0) ? 1.0f : 0.0f).setDuration(300);
    }

    private void fadeTitle() {
        this.getTitle().animate().alpha((this.getTitle().getAlpha() == 0.0) ? 1.0f : 0.0f).setDuration(500);
    }

    private void fadeNewTitle(Button button) {
        button.animate().alpha((button.getAlpha() == 0.0) ? 1.0f : 0.0f).setDuration(500);
        this.modifyVisiblity(button);
    }

    private void fadeButtons(Button button) {
        button.animate().alpha((button.getAlpha() == 0.0) ? 1.0f : 0.0f).setDuration(500);
        this.modifyVisiblity(button);
    }

    private void scaleButton(Button button) {
        button.animate().scaleX((button.getScaleX() == 0.0) ? 1.0f : 0.0f).setDuration(500);
        button.animate().scaleY((button.getScaleY() == 0.0) ? 1.0f : 0.0f).setDuration(500);
    }

    private List<String> capQuestions() {
        List<String> list = new ArrayList<>();
        String question1 = "-Is patient admitted to ICU?";
        String question2 = "-Does patient have necrotizing/cavitating infiltrates?";
        String question3 = "-Does patient have empyema?";
        list.add(question1);
        list.add(question2);
        list.add(question3);
        return list;
    }

    private List<String> diabeticFootQuestions() {
        List<String> list = new ArrayList<>();
        String question1 = "-Does patient have history of MRSA infections?";
        String question2 = "-Local prevalence of MRSA colonization/infection is high?";
        String question3 = "-Is infection clinically severe?";
        list.add(question1);
        list.add(question2);
        list.add(question3);
        return list;
    }

    private List<String> febrileNeutropeniaQuestions() {
        List<String> list = new ArrayList<>();
        String question1 = "-Has patient been previously MRSA colonized/infected?";
        String question2 = "-Was patient at a hospital with high rates of endemicity?";
        String question3 = "";
        list.add(question1);
        list.add(question2);
        list.add(question3);
        return list;
    }

    private List<String> meningitisQuestions() {
        List<String> list = new ArrayList<>();
        String question1 = "-Is patient immunocompromised?";
        String question2 = "-Does patient have a severe beta lactam allergy?";
        String question3 = "-Is meningitis healthcare-associated?";
        list.add(question1);
        list.add(question2);
        list.add(question3);
        return list;
    }

    private void determineAnswer(String buttonClicked) {
        switch (buttonClicked) {
            case "yestoany":
            case "bacteremia":
            case "hap":
            case "osteo/septicarthritis":
            case "endocarditis":
                this.answerText.setText(this.aucVanco());
                break;
            case "notoall":
            case "mild/moderate":
                this.answerText.setText(this.noCoverage());
                break;
            case "severe":
                this.answerText.setText(this.troughVanco());
                break;
        }
    }

    private void displayQuestions(String buttonClicked) {
        List<String> list;
        switch (buttonClicked) {
            case "diabeticfoot":
                list = this.diabeticFootQuestions();
                this.getQuestions(list);
                break;
            case "febrileneutropenia":
                list = this.febrileNeutropeniaQuestions();
                this.getQuestions(list);
                break;
            case "cap":
                list = this.capQuestions();
                this.getQuestions(list);
                break;
            case "meningitis":
                list = this.meningitisQuestions();
                this.getQuestions(list);
                break;
        }
    }

    private void getQuestions(List<String> list) {
        this.getQuestion1().setText(list.get(0));
        this.getQuestion2().setText(list.get(1));
        this.getQuestion3().setText(list.get(2));
    }

    private void pivotButton(Button button) {
        String buttonClick = this.buttonToString(button);

        switch (buttonClick) {
            case "osteo/septicarthritis":
            case "csstis":
            case "diabeticfoot":
            case "endocarditis":
            case "severe":
            case "notoall":
            case "hap":
                button.setPivotX((float) (this.getDisplayMetrics().widthPixels - (this.getDisplayMetrics().widthPixels / this.displayMetrics.xdpi) - button.getX() - (button.getX() * 0.03)));
                break;
            case "pneumonia":
            case "meningitis":
            case "febrileneutropenia":
            case "bacteremia":
            case "mild/moderate":
            case "yestoany":
            case "cap":
                button.setPivotX(this.getDisplayMetrics().widthPixels - (this.getDisplayMetrics().widthPixels) - button.getX() + (button.getX() / 2));
                break;
        }
        button.setPivotY(button.getY());
    }

    private void modifyVisiblity(Button button) {
        button.setVisibility((button.getAlpha() == 0.0) ? View.VISIBLE : View.INVISIBLE);
    }

    private String buttonToString(Button button) {
        return button.getText().toString().toLowerCase().trim().replaceAll(" ", "");
    }

    private void zoom(Button button) {
        button.animate().scaleX((button.getScaleX() == 1.0) ? 2.0f : 1.0f).setStartDelay(0).setDuration(500);
        button.animate().scaleY((button.getScaleY() == 1.0) ? 2.0f : 1.0f).setStartDelay(0).setDuration(500);
        this.pivotButton(button);
    }

    private void modifyPilar() {
        this.pilar.animate().scaleX((this.pilar.getScaleX() == 1.0) ? 1.15f : 1.0f).setDuration(500);
        this.pilar.animate().scaleY((this.pilar.getScaleY() == 1.0) ? 1.15f : 1.0f).setDuration(500);
        movePilar();
    }

    private void movePilar() {
        int count = 0;
        while(count <= (this.getBackButton().getY()*6)){
            count++;
            this.pilar.setPivotY(-count);
        }
    }

    private Button popButtonFromStack(){
        return this.buttonStack.pop();
    }

    private void modifySubsetButtons(List<Button> list) {
        for (Button button : list) {
            this.fadeButtons(button);
            this.scaleButton(button);
        }
    }

    private void modifyMainButtons(List<Button> list, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (i != index) {
                this.fadeButtons(list.get(i));
            } else {
                this.zoom(list.get(index));
            }
        }
    }

    private void adjustScreenDisplay(Button button) {
        this.fadeTitle();
        this.changeBackVisibility();
        this.modifyPilar();
        this.modifyMainButtons(this.getMainList(), this.getMainList().indexOf(button));
    }

    private void changeTitle(Button button, String buttonClicked) {
        switch (buttonClicked) {
            case "csstis":
            case "febrileneutropenia":
            case "diabeticfoot":
            case "meningitis":
            case "cap":
                this.setNewTitle(button);
                break;
            case "pneumonia":
                this.setPneumoniaButton(button);
                break;
        }
    }

    public void setPneumoniaButton(Button button){
        this.pneumoniaButton = button;
    }

    public void setAnswerText(TextView answerText) {
        this.answerText = answerText;
    }

    public void setDisplayMetrics(DisplayMetrics displayMetrics) { this.displayMetrics = displayMetrics; }

    public void setQuestion1(TextView question) {
        question.setText("");
        this.question1 = question;
    }

    public void setQuestion2(TextView question) {
        question.setText("");
        this.question2 = question;
    }

    public void setQuestion3(TextView question) {
        question.setText("");
        this.question3 = question;
    }

    public void setMainList(List<Button> list) { this.mainList = list; }

    public void setSeverityList(List<Button> list) { this.severityList = list; }

    public void setYesNoList(List<Button> list) { this.yesNoList = list; }

    public void setCapHapList(List<Button> list) { this.capHapList = list; }

    public void setTitle(TextView title) { this.title = title; }

    public void setPilar(ImageView pilar) { this.pilar = pilar; }

    public void setNewTitle(Button button) { this.newTitle = button; }

    public void setBackButton(Button backButton) {
        backButton.animate().alpha(0.0f).setDuration(0);
        backButton.setVisibility(View.INVISIBLE);
        this.backButton = backButton;
    }

    public void setButton(Button button) {
        button.setScaleX(0.0f);
        button.setScaleY(0.0f);
    }

    public Button getBackButton() { return this.backButton; }

    public TextView getTitle() { return this.title; }

    public ImageView getPilar() { return this.pilar; }

    public void pushButtonInStack(Button button){
        this.buttonStack.push(button);
    }

    public void getAnswer(Button button) {
        String buttonClicked = this.buttonToString(button);

        this.changeTitle(button, buttonClicked);

        switch (buttonClicked) {
            case "osteo/septicarthritis":
            case "bacteremia":
            case "endocarditis":
                this.adjustScreenDisplay(button);
                this.determineAnswer(buttonClicked);
                this.fadeAnswer();
                break;
            case "febrileneutropenia":
            case "diabeticfoot":
            case "meningitis":
                this.adjustScreenDisplay(button);
                this.displayQuestions(buttonClicked);
                this.fadeQuestions(this.getQuestion1(), this.getQuestion2(), this.getQuestion3());
                this.modifySubsetButtons(this.getYesNoList());
                break;
            case "mild/moderate":
            case "severe":
                this.fadeNewTitle(this.getNewTitle());
                this.modifyMainButtons(this.getSeverityList(), this.getSeverityList().indexOf(button));
                this.determineAnswer(buttonClicked);
                this.fadeAnswer();
                break;
            case "csstis":
                this.adjustScreenDisplay(button);
                this.modifySubsetButtons(this.getSeverityList());
                break;
            case "pneumonia":
                this.adjustScreenDisplay(button);
                this.modifySubsetButtons(this.getCapHapList());
                break;
            case "cap":
                this.fadeNewTitle(this.getPneumoniaButton());
                this.modifyMainButtons(this.getCapHapList(), this.getCapHapList().indexOf(button));
                this.displayQuestions(buttonClicked);
                this.fadeQuestions(this.getQuestion1(), this.getQuestion2(), this.getQuestion3());
                this.modifySubsetButtons(this.getYesNoList());
                break;
            case "hap":
                this.fadeNewTitle(this.getPneumoniaButton());
                this.modifyMainButtons(this.getCapHapList(), this.getCapHapList().indexOf(button));
                this.determineAnswer(buttonClicked);
                this.fadeAnswer();
                break;
            case "yestoany":
            case "notoall":
                this.fadeNewTitle(this.getNewTitle());
                this.modifyMainButtons(this.getYesNoList(), this.getYesNoList().indexOf(button));
                this.fadeQuestions(this.getQuestion1(), this.getQuestion2(), this.getQuestion3());
                this.determineAnswer(buttonClicked);
                this.fadeAnswer();
                break;
            case "back":
                Button poppedButton = this.popButtonFromStack();
                this.getAnswer(poppedButton);
                poppedButton.setClickable(true);
                break;
        }
    }
}
