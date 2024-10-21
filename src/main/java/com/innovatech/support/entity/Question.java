package com.innovatech.support.entity;

public class Question {
    private Long id;
    private String question;
    private String answer;
    private String business;
    private String userId;

    public Question(Long id, String question, String answer, String business, String userId) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.business = business;
        this.userId = userId;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public String getBusiness() { return business; }
    public void setBusiness(String business) { this.business = business; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
