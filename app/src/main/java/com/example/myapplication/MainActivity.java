package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;


    int score=0;
    int marksPerQuestion =2;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView =findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total question:"+totalQuestion);

        loadNewQuestion();

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        ansA.setBackgroundColor(getResources().getColor(android.R.color.white));
        ansB.setBackgroundColor(getResources().getColor(android.R.color.white));
        ansC.setBackgroundColor(getResources().getColor(android.R.color.white));
        ansD.setBackgroundColor(getResources().getColor(android.R.color.white));


        Button clickedButton = (Button) v;
        if(clickedButton.getId() ==  R.id.submit_btn){
            if(!selectedAnswer.isEmpty()) {
                if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                    score += marksPerQuestion;
                }
                currentQuestionIndex++;
                selectedAnswer = "";
                loadNewQuestion();
            }else{
                // Show an alert if no answer is selected
                new AlertDialog.Builder(this)
                        .setTitle("No answer selected")
                        .setMessage("Please select an answer before submitting.")
                        .setPositiveButton("OK", null)
                        .show();
            }

        }else{
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
        }
    }
    void loadNewQuestion(){
        if(currentQuestionIndex==totalQuestion){
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }
    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score : " + score + " "+"out of question : " + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }
    void restartQuiz(){
        score = 0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }

}