package com.almaral.guesschat;

public class ListRow {
    private String text;
    private boolean isQuestion;

    public ListRow(String text, boolean isQuestion) {
        this.text = text;
        this.isQuestion = isQuestion;
    }

    public String getText() {
        return text;
    }

    public boolean isQuestion() {
        return isQuestion;
    }
}
