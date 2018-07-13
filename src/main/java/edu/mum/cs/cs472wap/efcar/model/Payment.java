package edu.mum.cs.cs472wap.efcar.model;

public class Payment {

    private Long id;
    private String cardNumber;
    private String cardNameHolder;
    private String cardCVNumber;
    private String cardDueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNameHolder() {
        return cardNameHolder;
    }

    public void setCardNameHolder(String cardNameHolder) {
        this.cardNameHolder = cardNameHolder;
    }

    public String getCardCVNumber() {
        return cardCVNumber;
    }

    public void setCardCVNumber(String cardCVNumber) {
        this.cardCVNumber = cardCVNumber;
    }

    public String getCardDueDate() {
        return cardDueDate;
    }

    public void setCardDueDate(String cardDueDate) {
        this.cardDueDate = cardDueDate;
    }

    public Payment(Long id, String cardNumber, String cardNameHolder, String cardCVNumber, String cardDueDate) {

        this.id = id;
        this.cardNumber = cardNumber;
        this.cardNameHolder = cardNameHolder;
        this.cardCVNumber = cardCVNumber;
        this.cardDueDate = cardDueDate;
    }

    public Payment() {

    }
}
