package com.javarush.anishchenko.quest.servlets;

import com.javarush.anishchenko.quest.model.Statistics;
import com.javarush.anishchenko.quest.service.QuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;

public class WelcomeServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeServlet.class);

    private QuestService questService;

    @Override
    public void init() throws ServletException {
        LOGGER.debug("{} initialization", WelcomeServlet.class.getName());
        super.init();
        this.questService = new QuestService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.debug("Loading index.jsp page");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        LOGGER.info("User entered {} as name. Quest will be started now", name);
        request.getSession(false).setAttribute("userName", name);
        collectStatistics(request);
        response.sendRedirect(request.getContextPath() + "/question");
    }

    private void collectStatistics(HttpServletRequest request) throws UnknownHostException {
        Statistics currentStatistics = (Statistics) request.getSession().getAttribute("statistics");
        String userName = (String) request.getSession().getAttribute("userName");
        Statistics statistics = questService.generateStatistics(userName, currentStatistics);
        request.getSession(false).setAttribute("statistics", statistics);
    }
}
