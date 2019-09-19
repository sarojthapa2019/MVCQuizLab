package edu.mum.cs.wap.controller;

import edu.mum.cs.wap.modal.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/check")
public class QuizController extends HttpServlet {
    public QuizController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String answer = request.getParameter("answer");
        String question ="";
        int score = 0;
        HttpSession session = request.getSession();

            Quiz quiz1 = (Quiz)session.getAttribute("quiz");
            question = quiz1.getQuestion();
            quiz1.setAnswer(answer);
            quiz1.checkAnswer();
            question = quiz1.getRandomQuestion();
            if(question ==""){

            }


        getServletContext().getRequestDispatcher("/index.jsp")
                .forward(request,response);


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            Quiz quiz = new Quiz();
            HttpSession session = request.getSession();
            String question = quiz.getRandomQuestion();
            quiz.setQuestion(question);
            session.setAttribute("quiz",quiz);
            getServletContext().getRequestDispatcher("/index.jsp")
                .forward(request,response);
    }
}
