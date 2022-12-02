package com.javarush.anishchenko.quest.provider;
import com.javarush.anishchenko.quest.model.Answer;
import com.javarush.anishchenko.quest.model.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class QuestProvider {

    public static final String QUESTION_ID_PREFIX = "q-";

    public static final String ANSWER_ID_PREFIX = "answer-";

    private static final Map<String, Question> questions = new HashMap<>();

    static {
        createQuestions();
    }

    public static Map<String, Question> getQuestions() {
        return questions;
    }

    private static void createQuestions() {
        Question q7 = Question.builder()
                .id(QUESTION_ID_PREFIX + 7)
                .text("Тебя разоблачили. Ты проиграл!")
                .isLoose(false)
                .build();

        Question q6 = Question.builder()
                .id(QUESTION_ID_PREFIX + 6)
                .text("Ты не пошел на переговоры. Это провал и поражение!")
                .isLoose(true)
                .build();

        Question q5 = Question.builder()
                .id(QUESTION_ID_PREFIX + 5)
                .text("Твою ложь разоблачили. Прощай!")
                .isWin(true)
                .build();

        Question q4 = Question.builder()
                .id(QUESTION_ID_PREFIX + 4)
                .text("Тебя вернули домой. Победа!")
                .isWin(true)
                .build();

        Question q3 = Question.builder()
                .id(QUESTION_ID_PREFIX + 3)
                .text("Ты поднялся на мостик. Ты кто?")
                .answers(List.of(
                        Answer.builder()
                                .id(ANSWER_ID_PREFIX + 1)
                                .text("Солгать о себе")
                                .nextQuestion(q5)
                                .build(),
                        Answer.builder()
                                .id(ANSWER_ID_PREFIX + 2)
                                .text("Рассказать правду о себе")
                                .nextQuestion(q4)
                                .build()
                ))
                .build();

        Question q2 = Question.builder()
                .id(QUESTION_ID_PREFIX + 2)
                .text("Ты принял вызовю. Поднимаешься на мостик к капитану?")
                .answers(List.of(
                        Answer.builder()
                                .id(ANSWER_ID_PREFIX + 1)
                                .text("Отказаться подниматься на мостик")
                                .nextQuestion(q6)
                                .build(),
                        Answer.builder()
                                .id(ANSWER_ID_PREFIX + 2)
                                .text("Подняться на мостик")
                                .nextQuestion(q3)
                                .build()

                ))
                .build();

        Question q1 = Question.builder()
                .id(QUESTION_ID_PREFIX + 1)
                .text("Ты потерял память. Принять вызов НЛО?")
                .answers(List.of(
                        Answer.builder()
                                .id(ANSWER_ID_PREFIX + 1)
                                .text("Отклонить вызов")
                                .nextQuestion(q7)
                                .build(),
                        Answer.builder()
                                .id(ANSWER_ID_PREFIX + 2)
                                .text("Принять вызов")
                                .nextQuestion(q2)
                                .build()

                ))
                .build();

        questions.put(q1.getId(), q1);
        questions.put(q2.getId(), q2);
        questions.put(q3.getId(), q3);
        questions.put(q4.getId(), q4);
        questions.put(q5.getId(), q5);
        questions.put(q6.getId(), q6);
        questions.put(q7.getId(), q7);
    }

    private QuestProvider() {
        throw new UnsupportedOperationException();
    }
}
