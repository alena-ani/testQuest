package com.javarush.anishchenko.quest.service;
import com.javarush.anishchenko.quest.model.Question;
import com.javarush.anishchenko.quest.provider.QuestProvider;
import com.javarush.anishchenko.quest.storage.QuestionsStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static com.javarush.anishchenko.quest.constants.QuestConstants.ANSWER_ID_PREFIX;
import static com.javarush.anishchenko.quest.constants.QuestConstants.QUESTION_ID_PREFIX;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestServiceTest {

    @Mock
    private QuestProvider questProvider;

    @InjectMocks
    private QuestService questService;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.openMocks(this);
        questService = new QuestService(questProvider);
        when(questProvider.getQuestions()).thenReturn(QuestionsStorage.QUESTIONS);
    }

    @Test
    public void getFirstQuestionTest() {
        String firstQuestionId = QUESTION_ID_PREFIX + 1;
        Question firstQuestion = questService.getFirstQuestion();
        assertNotNull(firstQuestion);
        assertEquals(firstQuestionId, firstQuestion.getId());
        verify(questProvider).getQuestions();
    }

    @Test
    public void getThirdQuestionTest() {
        String thirdQuestionId = QUESTION_ID_PREFIX + 3;
        Question thirdQuestion = questService.getQuestion(thirdQuestionId);
        assertNotNull(thirdQuestion);
        assertEquals(thirdQuestionId, thirdQuestion.getId());
        verify(questProvider).getQuestions();
    }

    @Test
    public void findNextQuestionTest() {
        String firstQuestionId = QUESTION_ID_PREFIX + 1;
        String answerId = ANSWER_ID_PREFIX + 2;
        String expectedQuestionId = QUESTION_ID_PREFIX + 2;
        Question nextQuestion = questService.findNextQuestion(firstQuestionId, answerId);
        assertNotNull(nextQuestion);
        assertEquals(expectedQuestionId, nextQuestion.getId());
        verify(questProvider).getQuestions();
    }
}

