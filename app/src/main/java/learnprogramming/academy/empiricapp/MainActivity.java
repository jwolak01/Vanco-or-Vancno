package learnprogramming.academy.empiricapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<PlainText> extends AppCompatActivity {

    private Button pna;
    private Button osteo;
    private Button meningtitis;
    private Button csstis;
    private Button febrile;
    private Button diabeticFoot;
    private Button bacteremia;
    private Button endocarditis;
    private Button mildModerate, severe;
    private Button backButton;
    private Button yes, no;
    private Button cap, hap;
    private List<Button> mainList, severityList, yesNoList, capHapList;
    private TextView title, answer;
    private ImageView pilar;
    private Calculations calc;


    private void startProcess(Button button){
        calc.pushButtonInStack(button);
        calc.getAnswer(button);
        button.setClickable(false);
    }
    @SuppressLint("WrongConstant")
    private void mainMenu() {
        calc.setTitle(findViewById(R.id.direction));
        title = calc.getTitle();

        calc.setBackButton(findViewById(R.id.back));
        backButton = calc.getBackButton();

        calc.setPilar(findViewById(R.id.pillar));
        pilar = calc.getPilar();


        calc.setQuestion1(findViewById(R.id.question1));
        calc.setQuestion2(findViewById(R.id.question2));
        calc.setQuestion3(findViewById(R.id.question3));

        calc.setAnswerText(findViewById(R.id.answer));

        this.pna.setOnClickListener(e -> this.startProcess(this.pna));

        this.osteo.setOnClickListener(e -> this.startProcess(this.osteo));

        this.meningtitis.setOnClickListener(e -> this.startProcess(this.meningtitis));

        this.csstis.setOnClickListener(e -> this.startProcess(this.csstis));

        this.febrile.setOnClickListener(e -> this.startProcess(this.febrile));

        this.diabeticFoot.setOnClickListener(e -> this.startProcess(this.diabeticFoot));

        this.bacteremia.setOnClickListener(e -> this.startProcess(this.bacteremia));

        this.endocarditis.setOnClickListener(e -> this.startProcess(this.endocarditis));

        this.mildModerate.setOnClickListener(e -> this.startProcess(this.mildModerate));

        this.severe.setOnClickListener(e -> this.startProcess(this.severe));

        this.cap.setOnClickListener(e -> this.startProcess(this.cap));

        this.hap.setOnClickListener(e -> this.startProcess(this.hap));

        this.yes.setOnClickListener(e -> this.startProcess(this.yes));

        this.no.setOnClickListener(e -> this.startProcess(this.no));

        this.backButton.setOnClickListener(e -> calc.getAnswer(this.backButton));

    }

    private void createSeverityList() {
        this.severityList = new ArrayList<>();
        this.mildModerate = findViewById(R.id.mildModerate);
        this.severe = findViewById(R.id.severe);

        calc.setButton(this.mildModerate);
        calc.setButton(this.severe);

        severityList.add(this.mildModerate);
        severityList.add(this.severe);

        calc.setSeverityList(this.severityList);
    }

    private void createYesNoList() {
        this.yesNoList = new ArrayList<>();
        this.yes = findViewById(R.id.yesToAny);
        this.no = findViewById(R.id.noToAll);

        calc.setButton(yes);
        calc.setButton(no);

        this.yesNoList.add(this.yes);
        this.yesNoList.add(this.no);

        calc.setYesNoList(this.yesNoList);
    }

    private void createCapHapList() {
        this.capHapList = new ArrayList<>();
        this.cap = findViewById(R.id.cap);
        this.hap = findViewById(R.id.hap);

        calc.setButton(this.cap);
        calc.setButton(this.hap);

        this.capHapList.add(this.cap);
        this.capHapList.add(this.hap);

        calc.setCapHapList(this.capHapList);
    }

    private void createMainList() {
        this.mainList = new ArrayList<>();

        pna = findViewById(R.id.pneumonia);
        osteo = findViewById(R.id.OsteoSepticArthritis);
        meningtitis = findViewById(R.id.Meningitis);
        csstis = findViewById(R.id.cSSTIs);
        febrile = findViewById(R.id.FebrileNeutropenia);
        diabeticFoot = findViewById(R.id.DiabeticFoot);
        bacteremia = findViewById(R.id.Bacteremia);
        endocarditis = findViewById(R.id.Endocarditis);

        mainList.add(pna);
        mainList.add(osteo);
        mainList.add(meningtitis);
        mainList.add(csstis);
        mainList.add(febrile);
        mainList.add(diabeticFoot);
        mainList.add(bacteremia);
        mainList.add(endocarditis);

        calc.setMainList(this.mainList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = new Calculations();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        calc.setDisplayMetrics(displayMetrics);

        createMainList();
        createYesNoList();
        createSeverityList();
        createCapHapList();
        mainMenu();
    }
}