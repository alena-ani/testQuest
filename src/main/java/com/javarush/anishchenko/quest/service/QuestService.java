package com.javarush.anishchenko.quest.service;
import com.javarush.anishchenko.quest.model.Answer;
import com.javarush.anishchenko.quest.model.Question;
import com.javarush.anishchenko.quest.model.Statistics;
import com.javarush.anishchenko.quest.provider.QuestProvider;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

public class QuestService {

    public QuestService() {
    }

    public Question getFirstQuestion() {
        return QuestProvider.getQuestions().get(QuestProvider.QUESTION_ID_PREFIX + 1);
    }

    public Question getQuestion(String id) {
        return QuestProvider.getQuestions().get(id);
    }

    public Question findNextQuestion(String currentQuestionId, String answerId) {
        Question question = getQuestion(currentQuestionId);
        List<Answer> answers = question.getAnswers();
        for (Answer answer : answers) {
            if (answer.getId().equals(answerId)) {
                return answer.getNextQuestion();
            }
        }
        return null;
    }

    public Statistics generateStatistics(String userName, Statistics currentStatistics) throws UnknownHostException {
        Statistics statistics = new Statistics();
        if (currentStatistics == null) {
            statistics.setNumberOfGames(1);
        } else {
            statistics.setNumberOfGames(currentStatistics.getNumberOfGames() + 1);
        }
        statistics.setUserName(userName);
        statistics.setIpAddress(Inet4Address.getLocalHost().getHostAddress());
        return statistics;
    }
}
