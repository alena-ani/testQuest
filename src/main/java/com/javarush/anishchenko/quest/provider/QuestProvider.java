package com.javarush.anishchenko.quest.provider;
import com.javarush.anishchenko.quest.model.Question;
import com.javarush.anishchenko.quest.storage.QuestionsStorage;

import java.util.Map;

public class QuestProvider {

    private final Map<String, Question> questions;

    public QuestProvider() {
        this.questions = QuestionsStorage.QUESTIONS;
    }

    public Map<String, Question> getQuestions() {
        return questions;
    }
}

