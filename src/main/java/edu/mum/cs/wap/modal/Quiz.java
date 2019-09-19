package edu.mum.cs.wap.modal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Quiz {
    private static String[] questions = {
            "3, 1, 4, 1, 5", //pi
            "1, 1, 2, 3, 5" , // fibonacci
            "1, 4, 9, 16, 25", //square
            "2, 3, 5, 7, 11", //primes
            "1, 2, 4, 8, 16" //power of2
    };
    private static int[] answers = {9,8,36,13,32};

    String question;
    String answer;
    int score;

    public Quiz(String question, String answer, int score) {
        this.question = question;
        this.answer = answer;
        this.score = score;
    }
    public Quiz(){}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public boolean checkAnswer(){
        for(int i = 0; i<questions.length; i++){
            if(questions[i].equals(this.question) && Integer.parseInt(this.answer)==(answers[i])){
                score++;
                return true;
            }
        }
        return false;
    }
    HashMap<Integer, String> myMap = new HashMap<Integer, String>();
    public  String getRandomQuestion(){
        Random r = new Random();
        int random = r.nextInt(questions.length);
        if(!myMap.containsValue(questions[random])){
            myMap.put(Integer.valueOf(random),questions[random]);
            return questions[random];
        }
        return "";

    }
}
