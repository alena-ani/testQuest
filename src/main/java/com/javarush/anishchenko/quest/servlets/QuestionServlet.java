package com.javarush.anishchenko.quest.servlets;
import com.javarush.anishchenko.quest.model.Question;
import com.javarush.anishchenko.quest.provider.QuestProvider;
import com.javarush.anishchenko.quest.service.QuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class QuestionServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionServlet.class);

    private QuestService questService;

    @Override
    public void init() throws ServletException {
        LOGGER.debug("{} initialization", QuestionServlet.class.getName());
        super.init();
        this.questService = new QuestService(new QuestProvider());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        LOGGER.debug("Loading questions");
        servletContext.setAttribute("question", questService.getFirstQuestion());
        servletContext.setAttribute("userName", request.getSession().getAttribute("userName"));
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/question.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answerId = request.getParameter("answer");
        String questionId = request.getParameter("question");
        String userName = (String )request.getSession().getAttribute("userName");
        LOGGER.info("User {} answered to question {} with answer {}", userName, questionId, answerId);
        ServletContext servletContext = getServletContext();
        Question nextQuestion = questService.findNextQuestion(questionId, answerId);
        servletContext.setAttribute("question", nextQuestion);
        LOGGER.info("Loading next question with id {}", nextQuestion.getId());
        servletContext.setAttribute("userName", userName);
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/question.jsp");
        requestDispatcher.forward(request, response);
    }
}
