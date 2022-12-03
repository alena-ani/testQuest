package com.javarush.anishchenko.quest.model;
import com.javarush.anishchenko.quest.model.Answer;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class Question implements Serializable {

    private String text;

    private String id;

    @Builder.Default
    private List<Answer> answers = new ArrayList<>();

    private boolean isWin;

    private boolean isLoose;
}

