package edu.mum.cs.wap.modal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizData {
    private List<Quiz> quizList;
    private int questionNumber;
    private int score;

    public QuizData(){
        this.quizList = Arrays.asList( new Quiz("3, 1, 4, 1, 5", "9"),
                new Quiz("1, 1, 2, 3, 5", "8"),
                new Quiz("1, 4, 9, 16, 25", "36"),
                new Quiz("2, 3, 5, 7, 11", "13"),
                new Quiz("1, 2, 4, 8, 16", "32"));
        Collections.shuffle(this.quizList);
    }
    public String nextQuestion(){
        if(questionNumber>=this.quizList.size()) {
            return null;
        }else{

            String q= this.quizList.get(questionNumber++).getQuestion();

            return q;
        }

    }
    public void check(String answer){
        int i = questionNumber-1;
        if(this.quizList.get(i).checkQuiz(answer)){
            this.score++;
        }
    }
    public int getScore(){
        return score;
    }

    public boolean finish(){

    return this.questionNumber == quizList.size();
     }
}
