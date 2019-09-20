package edu.mum.cs.wap.controller;

import edu.mum.cs.wap.modal.Quiz;
import edu.mum.cs.wap.modal.QuizData;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
      HttpSession session  = request.getSession();
        QuizData quizData;
        if(session.getAttribute("quizData")==null){
            quizData = new QuizData();
            session.setAttribute("quizData", quizData);
        }
        else{
                String answer = request.getParameter("answer");
                quizData = (QuizData)session.getAttribute("quizData");
                quizData.check(answer);
                session.setAttribute("quizData",quizData);
        }
        if(quizData.finish()){
            request.getRequestDispatcher("success.jsp").forward(request,response);
            session.invalidate();
        }
        else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        this.doPost(request,response);
    }
}
