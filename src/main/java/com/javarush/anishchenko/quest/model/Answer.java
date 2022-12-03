package com.javarush.anishchenko.quest.model;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class Answer implements Serializable {

    String id;

    String text;

    Question nextQuestion;
}

